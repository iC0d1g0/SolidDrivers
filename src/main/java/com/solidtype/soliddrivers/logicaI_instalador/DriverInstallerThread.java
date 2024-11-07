
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
            System.out.println("Empieza con driver " + driver.getDriver() + "en el hilo:" + installerName );
            installDriver(driver.getDriver());
            Thread.sleep(2000);
            System.out.println("Termine con:" + driver + "en el hilo:" + installerName );
        }
            
        } catch (InterruptedException ex) {
            System.out.println("error en thread : " + ex.getMessage());
        }
    }
     public void installDriver(Path infFilePath) {
        System.out.println("Instalando driver: " + infFilePath.toAbsolutePath());
            
            String rutaBatch = checkAndCreateBatchFile();

        try {
            // Ejecuta el comando pnputil
            ProcessBuilder processBuilder = new ProcessBuilder(rutaBatch, infFilePath.toAbsolutePath().toString());
            processBuilder.redirectErrorStream(true); // Combina la salida de error con la salida estándar
            Process process = processBuilder.start();
           
            // Lee la salida del proceso para obtener mensajes de instalación
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    this.manager.setPrintText(line);  // Imprime la salida (incluye errores)
                }
            }
            
            process.waitFor(20, TimeUnit.MINUTES);

        } catch (IOException | InterruptedException e) {
            System.err.println("Error al ejecutar pnputil para el archivo: " + infFilePath.getFileName());
            e.printStackTrace();
            Thread.currentThread().interrupt();  // Restaura el estado de interrupción
        }
    }

   
}
