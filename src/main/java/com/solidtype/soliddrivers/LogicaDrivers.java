
package com.solidtype.soliddrivers;

import java.awt.TextField;
import java.io.File;

public interface LogicaDrivers {
       
    public InfoEntity getInfo();
    
    public void instalarDrivers(File carpeta, TextField consola);
    
    public File extraerDrivers();
    
    public void customDrivers();
    
    public void manualDriver(String path);
    
    
}
