/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solidtype.soliddrivers.logicaI_instalador;

import java.awt.TextArea;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

/**
 *
 * @author adder
 */
public class DriversManager {
    
    
    private static final int DRIVERS_INSTALLERS =1;
    private TextArea console;
    private Queue<Drivers> cola = new LinkedList<>(); 
    private final String folderName;
    Object lock = new Object();
    private Thread[] installers;
    
    private int cantidadDrivers;
    
    public DriversManager(String folderName, TextArea console){
        this.console = console;
        installers = new Thread[DRIVERS_INSTALLERS];
        for(int i= 0; i<DRIVERS_INSTALLERS; i++){
            installers[i] = new Thread(new DriverInstallerThread(this, "Installer"+(i+1)));
        }
        this.folderName = folderName;
    }
    
    public void iniciar(){
        installDrivers(this.folderName);
        
        for(Thread install :installers){
            install.start();
        }
       
    }
    public void setPrintText(String texto){
         this.console.append( texto + "\n");
    }
    public void clearText(){
         this.console.setText("");
    }
    public void agregarDrivers(Drivers driver){
        synchronized(lock){
            cola.offer(driver);
            lock.notify();
        }
    }
    
    public Drivers obtenerDriver() throws InterruptedException{
        synchronized(lock){
            while(cola.isEmpty()){
                this.console.append("Driver restantes :" + cola.size() + "/" + this.cantidadDrivers);
                lock.wait();
            }
        }
        this.console.append("Driver restantes :" + cola.size() + "/" + this.cantidadDrivers +"\n");
        return cola.poll();
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
                .forEach(path -> agregarDrivers(new Drivers(path))); // Usar expresión lambda en lugar de referencia de método
              
            this.cantidadDrivers = this.cola.size();
         } catch (IOException e) {
            this.console.append("Error al recorrer la carpeta: " + driversPath.toAbsolutePath());
            e.printStackTrace();
        }
    }
    
     public synchronized int getQueueSize() {
        return cola.size();
    }

    public synchronized boolean isQueueEmpty() {
        return cola.isEmpty();
    }
}
