/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solidtype.soliddrivers.logicaI_instalador;

import java.nio.file.Path;


public class Drivers {
    
    private final Path driver;
    
    public Drivers(Path driver){
        this.driver = driver;
    }
    
    public Path getDriver(){
        return this.driver;
    }
 
}
