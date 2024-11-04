
package com.solidtype.soliddrivers;

import java.awt.TextField;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 *
 * @author adder
 */
public class LogicaDriversInterfaz implements LogicaDrivers {

    @Override
    public InfoEntity getInfo() {
        InfoEntity info= new InfoEntity();
        var local = getLocalInfo();
        
         info.setOsName(local.get("OsName"));
         info.setVersion(local.get("Version"));
         info.setArquitectura(local.get("Arquitectura"));
         info.setManufacture(local.get("Manufacture"));
         info.setModelo(local.get("Modelo"));
         info.setSystemType(local.get("SystemType"));
         info.setProcesador(local.get("Procesador"));
         info.setBios(local.get("BIOS"));
         info.setMemoria(local.get("Memoria"));
       
        return info;
    }

    @Override
    public void instalarDrivers(File carpeta, TextField consola) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public File extraerDrivers() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void customDrivers() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void manualDriver(String path) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
    private  Map<String, String> getLocalInfo(){
        
        Map<String, String> info = new HashMap<>(); 
     
                
        // Información del sistema básico usando System.getProperty
        info.put("OsName", System.getProperty("os.name"));
        info.put("Version", System.getProperty("os.version"));
        info.put("Arquitectura", System.getProperty("os.arch"));

        // Información avanzada usando comandos de Windows
        info.put("Manufacture", getWmicOutput("wmic csproduct get vendor"));
        info.put("Modelo", getWmicOutput("wmic csproduct get name"));
        info.put("SystemType", getWmicOutput("wmic computersystem get systemtype"));
        info.put("Procesador", getWmicOutput("wmic cpu get name"));
        info.put("BIOS", getWmicOutput("wmic bios get smbiosbiosversion"));
        info.put("Memoria", getWmicOutput("wmic computersystem get totalphysicalmemory"));

        // Mostrar la información
      //  info.forEach((key, value) -> System.out.println(key + ": " + value.trim()));
        return info;
    }

 private static String getWmicOutput(String command) {
        StringBuilder result = new StringBuilder();
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
            // Leer la salida, omitiendo la primera línea (encabezado)
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {  // Omitir encabezado
                    isFirstLine = false;
                    continue;
                }
                result.append(line.trim()).append("\n"); // Añadir línea sin espacios extras
            }
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error obteniendo información";
        }
        return result.toString().trim(); // Remover espacios y saltos de línea finales
    }
}

