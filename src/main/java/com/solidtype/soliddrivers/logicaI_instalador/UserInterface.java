/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solidtype.soliddrivers.logicaI_instalador;

import javax.swing.JProgressBar;

/**
 *
 * @author adder
 */
public class UserInterface implements ProgressListener {

    private JProgressBar progressBar; // Supongamos que estás usando una barra de progreso en Swing

    public UserInterface(JProgressBar progress) {
       this.progressBar = progress;
    }

    @Override
    public void onProgressUpdate(int progress) {
        progressBar.setValue(progress);
        if (progress >= 100) {
            System.out.println("Instalación completada.");
        }
    }
}
