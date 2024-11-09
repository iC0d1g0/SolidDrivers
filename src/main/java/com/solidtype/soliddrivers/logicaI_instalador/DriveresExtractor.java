/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solidtype.soliddrivers.logicaI_instalador;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
/**
 *
 * @author adder
 */
public class DriveresExtractor implements Runnable{
      private final DriversManager manager;
    private final String folderNamee;
    
    
      public DriveresExtractor(DriversManager manager, String folderNamee) {
        this.manager = manager;
        this.folderNamee = folderNamee;
    }
      
 
    @Override
    public void run() {
        try {
            while(true){
            var driver = manager.obtenerDriver();
  
            if(driver == null){    
                System.out.println("EL QUEUE DEBE DE ESTAR VACIO++++++++++++++++++++++");
                return;
            }
            this.manager.clearText();
            this.manager.setPrintText("ruta: " + driver.getDriver());
            extractor(this.folderNamee,driver.getDriver());
            //Thread.sleep(1000);
            this.manager.setPrintText("Estado : Iniciando....");
            
        }
            
        } catch (InterruptedException ex) {
           this.manager.setPrintText("error en thread : " + ex.getMessage());
        }
    }
 
    
     public void extractor(String folderName, Path source){
             // Crear la carpeta "Binaries" en el directorio de ejecución
        String sourcePath = System.getenv("windir") + "\\System32\\DriverStore\\FileRepository";
        
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
        
         // Ruta de la carpeta FileRepository
             try {
                Path destination = Paths.get(destPath, source.toString().substring(sourcePath.length()));
              this.manager.setPrintText("Copiando: " +source.getFileName());
             // Si es un directorio, créalo, si es un archivo, cópialo
             if (Files.isDirectory(source)) {
                 Files.createDirectories(destination); // Crear directorio si no existe
             } else {
                 Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
             }
              
              // Imprime la salida (incluye errores)
                
         } catch (IOException e) {
            Thread.currentThread().interrupt();  
           //  println("Error copiando archivo o creando directorio: " + source);
           
             
         }
       
     }

    
}
