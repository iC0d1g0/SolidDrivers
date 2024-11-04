/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solidtype.soliddrivers;

/**
 *
 * @author adder
 */
public class InfoEntity {
   private String   
    OsName, 
    Version,
    Manufacture,
    Modelo, 
    SystemType,
    Procesador,
    Bios,
    Arquitectura,
    Memoria;
    public String getArquitectura() {
        return Arquitectura;
    }

    public void setArquitectura(String Arquitectura) {
        this.Arquitectura = Arquitectura;
    }

    public String getOsName() {
        return OsName;
    }

    public void setOsName(String OsName) {
        this.OsName = OsName;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String Version) {
        this.Version = Version;
    }

    public String getManufacture() {
        return Manufacture;
    }

    public void setManufacture(String Manufacture) {
        this.Manufacture = Manufacture;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getSystemType() {
        return SystemType;
    }

    public void setSystemType(String SystemType) {
        this.SystemType = SystemType;
    }

    public String getProcesador() {
        return Procesador;
    }

    public void setProcesador(String Procesador) {
        this.Procesador = Procesador;
    }

    public String getBios() {
        return Bios;
    }

    public void setBios(String Bios) {
        this.Bios = Bios;
    }

    public String getMemoria() {
        return Memoria;
    }

    public void setMemoria(String Memoria) {
        this.Memoria = Memoria;
    }
}
