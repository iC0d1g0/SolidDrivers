/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solidtype.soliddrivers.logicaI_instalador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BatchFileCreator {
       // Función para verificar si el archivo batch existe, y crearlo si no es así
    public static String checkAndCreateBatchFile() {
        Path currentPath = Paths.get("").toAbsolutePath();
        File batchFile = new File(currentPath.toFile(), "Binaries/bin/internalBinary.bat");

        // Verificar si el archivo batch existe
        if (!batchFile.exists()) {
            System.out.println("El archivo internalBinary.bat no existe. Creando el archivo...");
             batchFile.getAbsolutePath();
            // Llamar a la función para crear el archivo batch
            createBatchFile();
            
            return checkAndCreateBatchFile();           
        }
         return  batchFile.getAbsolutePath();
    }
    public static void createBatchFile() {
        // Obtén el directorio de ejecución del programa y crea las carpetas necesarias
        Path currentPath = Paths.get("").toAbsolutePath();
        File binariesDir = new File(currentPath.toFile(), "Binaries/bin");

        if (!binariesDir.exists() && !binariesDir.mkdirs()) {
            System.err.println("No se pudo crear la carpeta Binaries/bin.");
            return;
        }

        // Ruta al archivo batch
        File batchFile = new File(binariesDir, "internalBinary.bat");

        // Contenido del archivo batch
        String batchContent = """
            @echo off
            net session >nul 2>&1
            if %errorLevel% neq 0 (
                echo SolidDrivers necesita privilegios de administrador.
                echo Por favor, cierre el programa y ejecutelo como administrador. 
                echo si el problema persiste, favor comuniquese con soporte : adderlis@live.com
                echo error: 0x00002
                pause
                exit /b
            )

            rem Asigna el primer parámetro pasado al batch como la variable DIR_PATH
            set "DIR_PATH=%~1"
       echo ****************************************************************************************
                                                            
            pnputil /add-driver "%DIR_PATH%"  /install
                     
      echo *****************************************************************************************
            
            """;

        // Escribe el contenido en el archivo batch
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(batchFile))) {
            writer.write(batchContent);
            System.out.println("El archivo batch se ha creado correctamente en: " + batchFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error al crear el archivo batch: " + e.getMessage());
        }
    }

 
}
