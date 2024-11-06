/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solidtype.soliddrivers;
import com.solidtype.soliddrivers.logicaI_instalador.DriversManager;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;



public class Funciones_windows {
    


    // Método para iniciar la instalación de drivers desde la carpeta Binaries
    public void installDrivers(String folderName) {
      DriversManager manager = new DriversManager(folderName);
        System.out.println("Voy a iniciar la insalacion de drivers");
      manager.iniciar();
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

