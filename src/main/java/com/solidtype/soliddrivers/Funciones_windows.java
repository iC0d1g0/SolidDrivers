/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solidtype.soliddrivers;
import com.solidtype.soliddrivers.logicaI_instalador.DriversManager;
import java.awt.TextArea;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;



public class Funciones_windows {
  
     private JProgressBar progress;
     private TextArea console;
     public Funciones_windows (JProgressBar progress, TextArea console){
          this.progress = progress;
        this.console = console;
     }
    
    // Método para iniciar la instalación de drivers desde la carpeta Binaries
    public void installDrivers(String folderName) {
      
        DriversManager manager = new DriversManager(folderName, this.console);
        System.out.println("Voy a iniciar la insalacion de drivers");
        manager.iniciar();
      
        new ProgressUpdater(manager).execute();
    }
    public void println(String texto){
         this.console.append(texto + "\n");
    }
    public void copyDriverStore(String folderName) {
        // Ruta de la carpeta FileRepository
       
        println("Extrayendo drivers... por favor espere... ");
        
        String sourcePath = System.getenv("windir") + "\\System32\\DriverStore\\FileRepository";
            // Crear la carpeta "Binaries" en el directorio de ejecución
        println("Extrayendo desde: "+sourcePath);
        String binariesPath = System.getProperty("user.dir") + File.separator + "Binaries";
        File binariesFolder = new File(binariesPath);
        if (!binariesFolder.exists()) {
            binariesFolder.mkdirs();
            println("Creando nueva carpeta..");
        }

        // Crear la carpeta de destino dentro de "Binaries"
        String destPath = binariesPath + File.separator + folderName;
        File destFolder = new File(destPath);
        if (!destFolder.exists()) {
            destFolder.mkdirs();
            println("Configurando destino :"+ destFolder);
                   // Copiar el contenido de FileRepository a la carpeta de destino
        }
        
        try {
            Files.walk(Paths.get(sourcePath))
                 .forEach(source -> {
                     
                  Path destination = Paths.get(destPath, source.toString().substring(sourcePath.length()));
                  println("Copiando: "+source.toString());
         try {
             // Si es un directorio, créalo, si es un archivo, cópialo
             if (Files.isDirectory(source)) {
                 Files.createDirectories(destination); // Crear directorio si no existe
             } else {
                 Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
             }
         } catch (IOException e) {
           
             println("Error copiando archivo o creando directorio: " + source + " -> " + destination);
             println(e.getMessage());
             
         }
         });
            println("");
            println("");
            println("Archivos copiados exitosamente a: " + destPath);
        } catch (IOException e) {
            println("Error al acceder o copiar los archivos de la carpeta FileRepository. " + e.getMessage());
           
             }
         }

 
     // SwingWorker para actualizar la barra de progreso en la UI
    private class ProgressUpdater extends SwingWorker<Void, Integer> {
        private final DriversManager manager;
        private final int totalDrivers;

        public ProgressUpdater(DriversManager manager) {
            this.manager = manager;
            this.totalDrivers = manager.getQueueSize(); // Guardar el total de drivers
        }

        @Override
        protected Void doInBackground() {
            while (!manager.isQueueEmpty()) {
                int processedDrivers = totalDrivers - manager.getQueueSize();
                int progress = (int) ((processedDrivers / (double) totalDrivers) * 100);
                publish(progress); // Publicar el progreso para actualizar en la UI
                try {
                    Thread.sleep(500); // Intervalo de actualización
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            publish(100); // Al finalizar, asegurarse de que la barra de progreso esté al 100%
            return null;
        }

        @Override
        protected void process(List<Integer> chunks) {
            int lastProgress = chunks.get(chunks.size() - 1);
            progress.setValue(lastProgress); // Actualizar la barra de progreso
        }

        @Override
        protected void done() {
            JOptionPane.showMessageDialog(null, "Instalación completada.");
        }
    }

}

