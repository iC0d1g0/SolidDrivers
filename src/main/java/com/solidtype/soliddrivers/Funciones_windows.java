/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solidtype.soliddrivers;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.util.stream.Stream;


public class Funciones_windows {
    
    // Método para instalar un driver usando pnputil
    public void installDriver(Path infFilePath) {
        System.out.println("Instalando driver: " + infFilePath.toAbsolutePath());

        try {
            // Ejecuta el comando pnputil
            ProcessBuilder processBuilder = new ProcessBuilder("pnputil", "/add-driver", infFilePath.toString(), "/install");
            processBuilder.redirectErrorStream(true); // Combina la salida de error con la salida estándar
            Process process = processBuilder.start();

            // Lee la salida del proceso para obtener mensajes de instalación
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);  // Imprime la salida (incluye errores)
                }
            }

            // Agregar un tiempo de espera al proceso para que intente finalizar en caso de bloqueos
            boolean completed = process.waitFor(60, java.util.concurrent.TimeUnit.SECONDS);
            if (completed) {
                int exitCode = process.exitValue();
                if (exitCode == 0) {
                    System.out.println("Driver instalado exitosamente: " + infFilePath.getFileName());
                } else {
                    System.out.println("Error al instalar el driver: " + infFilePath.getFileName() + ". Código de salida: " + exitCode);
                }
            } else {
                System.err.println("El proceso tardó demasiado y fue terminado.");
                process.destroy();  // Termina el proceso si se excede el tiempo de espera
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Error al ejecutar pnputil para el archivo: " + infFilePath.getFileName());
            e.printStackTrace();
            Thread.currentThread().interrupt();  // Restaura el estado de interrupción
        }
    }

    // Método para iniciar la instalación de drivers desde la carpeta Binaries
    public void installDrivers(String folderName) {
        Path driversPath = Paths.get("Binaries", folderName);

        if (!driversPath.toFile().exists()) {
            System.out.println("Carpeta de drivers no encontrada en: " + driversPath);
            return;
        }

        try (Stream<Path> paths = Files.walk(driversPath)) {
            paths.filter(Files::isRegularFile) // Filtra solo archivos
                .filter(path -> path.toString().toLowerCase().endsWith(".inf")) // Filtra archivos .inf
                .forEach(path -> installDriver(path)); // Usar expresión lambda en lugar de referencia de método
        } catch (IOException e) {
            System.err.println("Error al recorrer la carpeta: " + driversPath.toAbsolutePath());
            e.printStackTrace();
        }
    }

    public void copyDriverStore(String folderName) {
        // Ruta de la carpeta FileRepository
        String sourcePath = System.getenv("windir") + "\\System32\\DriverStore\\FileRepository";
            // Crear la carpeta "Binaries" en el directorio de ejecución
        String binariesPath = System.getProperty("user.dir") + File.separator + "Binaries";
        File binariesFolder = new File(binariesPath);
        if (!binariesFolder.exists()) {
            binariesFolder.mkdirs();
        }

        // Crear la carpeta de destino dentro de "Binaries"
        String destPath = binariesPath + File.separator + folderName;
        File destFolder = new File(destPath);
        if (!destFolder.exists()) {
            destFolder.mkdirs();
                   // Copiar el contenido de FileRepository a la carpeta de destino
        }
        
        try {
            Files.walk(Paths.get(sourcePath))
                 .forEach(source -> {
                  Path destination = Paths.get(destPath, source.toString().substring(sourcePath.length()));
         try {
             // Si es un directorio, créalo, si es un archivo, cópialo
             if (Files.isDirectory(source)) {
                 Files.createDirectories(destination); // Crear directorio si no existe
             } else {
                 Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
             }
         } catch (IOException e) {
             System.err.println("Error copiando archivo o creando directorio: " + source + " -> " + destination);
             e.printStackTrace();
         }
         });
            System.out.println("Archivos copiados exitosamente a: " + destPath);
        } catch (IOException e) {
            System.err.println("Error al acceder o copiar los archivos de la carpeta FileRepository.");
            e.printStackTrace();
             }
         }

 
}

