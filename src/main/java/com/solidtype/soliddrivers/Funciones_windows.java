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
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileSystemView;



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
    
    public void installCustomDrivers(String folderName){
        DriversManager manager = new DriversManager(folderName, this.console);
        System.out.println("Voy a iniciar la insalacion de drivers");
        manager.installCustomDriver(folderName);
      
        new ProgressUpdater(manager).execute();
        
    }
    public void println(String texto){
         this.console.append(texto + "\n");
    }
    public void copyDriverStore(String folderName) {
     
            DriversManager manager = new DriversManager(folderName, this.console);
            System.out.println("Voy a iniciar la insalacion de drivers");
            manager.extraer();

            new ProgressUpdater(manager).execute();
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
             Instant inicio = Instant.now();
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
            Instant fin = Instant.now();
            long duracionMinutos = Duration.between(inicio, fin).toSeconds();
            println("\nDuracion : " +duracionMinutos+ " Segundos\n");
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
    
    public  String seleccionarCarpeta() {
        // Crear un JFileChooser con el modo de selección de directorios
        JFileChooser selectorCarpeta = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        selectorCarpeta.setDialogTitle("Selecciona una carpeta");
        selectorCarpeta.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        // Mostrar el diálogo y capturar la selección
        int resultado = selectorCarpeta.showOpenDialog(null);

        // Verificar si el usuario seleccionó una carpeta
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File carpetaSeleccionada = selectorCarpeta.getSelectedFile();
            return carpetaSeleccionada.getAbsolutePath(); // Devolver la ruta de la carpeta seleccionada
        } else {
            System.out.println("No se seleccionó ninguna carpeta.");
            return null;
        }
    }

}

