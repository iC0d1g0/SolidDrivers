
package com.solidtype.soliddrivers.logicaI_instalador;

import static com.solidtype.soliddrivers.logicaI_instalador.BatchFileCreator.checkAndCreateBatchFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public class DriverInstallerThread implements Runnable {
    private final DriversManager manager;
    private final String installerName;
    
    

    public DriverInstallerThread(DriversManager manager, String installerName) {
        this.manager = manager;
        this.installerName = installerName;
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
            installDriver(driver.getDriver());
            //Thread.sleep(1000);
            this.manager.setPrintText("Estado : Iniciando....");
            
        }
            
        } catch (InterruptedException ex) {
           this.manager.setPrintText("error en thread : " + ex.getMessage());
        }
    }
     public void installDriver(Path infFilePath) {
          this.manager.setPrintText("proceso : Instalando, wait...");
            
            String rutaBatch = checkAndCreateBatchFile();

        try {
            // Ejecuta el comando pnputil
            ProcessBuilder processBuilder = new ProcessBuilder(rutaBatch, infFilePath.toAbsolutePath().toString());
            System.out.println("archivos : " + infFilePath.toAbsolutePath().toString());
            processBuilder.redirectErrorStream(true); // Combina la salida de error con la salida estándar
            Process process = processBuilder.start();
           
            // Lee la salida del proceso para obtener mensajes de instalación
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    this.manager.setPrintText(line);  // Imprime la salida (incluye errores)
                }
            }
            
          //  Thread.sleep(500);      
            process.waitFor(5, TimeUnit.MINUTES);
            this.manager.setPrintText("Instalacion : Completa...\n");    
            System.out.println("");
                         
            

        } catch (IOException | InterruptedException e) {
            this.manager.setPrintText("Error al ejecutar pnputil para el archivo: " + infFilePath.getFileName());
           
            Thread.currentThread().interrupt();  // Restaura el estado de interrupción
        }
    }

   
}
