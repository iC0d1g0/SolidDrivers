/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solidtype.soliddrivers.logicaI_instalador;

import static com.solidtype.soliddrivers.logicaI_instalador.BatchFileCreator.checkAndCreateBatchFile;
import static com.solidtype.soliddrivers.logicaI_instalador.BatchFileCreator.createBatchFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

/**
 *  SilentInstall.bat
 * @author adder
 */


public class CardReaderInstaller {
    
     public String checkAndCreateBatchFile() {
        Path currentPath = Paths.get("").toAbsolutePath();
        File batchFile = new File(currentPath.toFile(), "JRE/CR/setup.exe");

        // Verificar si el archivo batch existe
        if (!batchFile.exists()) {
            System.out.println("El archivo SilentInstall.batt no existe. Creando el archivo...");
             batchFile.getAbsolutePath();
            // Llamar a la función para crear el archivo batch
      
            
            return "Error de instalacion, vuelve a instalar el programa, : Error 0x00CR";           
        }
         System.out.println("Existe : " + batchFile.getAbsolutePath());
         installDriver(batchFile.getAbsolutePath());
         return "Instalacion de CardReader completada. Favor reinicar";
    }
     
      public void installDriver(String infFilePath) {
           System.out.println("proceso : Instalando, wait...");
            
        try {
            // Ejecuta el comando pnputil
            ProcessBuilder processBuilder = new ProcessBuilder(infFilePath);
            System.out.println("archivos : " + infFilePath);
            processBuilder.redirectErrorStream(true); // Combina la salida de error con la salida estándar
            Process process = processBuilder.start();
           
            // Lee la salida del proceso para obtener mensajes de instalación
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);  // Imprime la salida (incluye errores)
                }
            }
            
          //  Thread.sleep(500);      
            process.waitFor(5, TimeUnit.MINUTES);
            System.out.println("Instalacion : Completa...\n");    
            System.out.println("");
                         
            

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al ejecutar pnputil para el archivo: " + infFilePath);
           
            Thread.currentThread().interrupt();  // Restaura el estado de interrupción
        }
    }
    
}
