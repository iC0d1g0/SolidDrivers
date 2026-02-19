/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.solidtype.soliddrivers;


public class UserScreen extends javax.swing.JFrame {

    private final LogicaDrivers driver;

    public UserScreen() {
        initComponents();
        driver = new LogicaDriversInterfaz(jProgressBar1, consola);
        jProgressBar1.setMinimum(0);
        jProgressBar1.setMaximum(100);
        jProgressBar1.setValue(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btInfo = new javax.swing.JButton();
        btn_extraer = new javax.swing.JButton();
        btn_instalar = new javax.swing.JButton();
        btn_custom = new javax.swing.JButton();
        btn_cardReader = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        consola = new java.awt.TextArea();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(153, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        btInfo.setText("Info");
        btInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btInfoMouseEntered(evt);
            }
        });
        btInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInfoActionPerformed(evt);
            }
        });

        btn_extraer.setText("Extraer Drivers");
        btn_extraer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_extraerMouseEntered(evt);
            }
        });
        btn_extraer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_extraerActionPerformed(evt);
            }
        });

        btn_instalar.setText("Instalar Todo");
        btn_instalar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_instalarMouseEntered(evt);
            }
        });
        btn_instalar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_instalarActionPerformed(evt);
            }
        });

        btn_custom.setText("Custom Drivers");
        btn_custom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_customMouseEntered(evt);
            }
        });
        btn_custom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_customActionPerformed(evt);
            }
        });

        btn_cardReader.setText("Instalar CardDriver");
        btn_cardReader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cardReaderMouseEntered(evt);
            }
        });
        btn_cardReader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cardReaderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cardReader, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btn_custom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_extraer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_instalar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btInfo)
                        .addComponent(btn_cardReader))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_instalar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_extraer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_custom)))
                .addGap(15, 15, 15))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setText("Console:");

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        consola.setBackground(new java.awt.Color(102, 102, 102));
        consola.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        consola.setEditable(false);
        consola.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        consola.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(consola, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(consola, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 518, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jProgressBar1.setBackground(new java.awt.Color(204, 204, 255));
        jProgressBar1.setForeground(new java.awt.Color(0, 102, 102));
        jProgressBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jProgressBar1.setFocusCycleRoot(true);
        jProgressBar1.setInheritsPopupMenu(true);
        jProgressBar1.setStringPainted(true);

        jLabel2.setText("SolidDrives by SolidType S.R.L.");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInfoActionPerformed
        InfoEntity info = this.driver.getInfo();
        this.consola.append("Leyendo informaciones" + "\n");

        this.consola.append("Modelo: " + info.getModelo() + "\n");

        this.consola.append("Fabricante: " + info.getManufacture() + "\n");

        this.consola.append("Systema Operativo: " + info.getOsName() + "\n");

        this.consola.append("Arquitectura: "
                +info.getArquitectura() + "\n");

        this.consola.append("Compilacion: "
                + info.getMemoria() + "\n"
        );

        this.consola.append("Version de Bios : "
                + info.getBios() + "\n"
        );
         this.consola.append("Windows : "
                + info.getVersion()+ "\n"
        );
        this.consola.append("Tipo de Sistema : "
                +info.getSystemType()+ "\n"
        );
         this.consola.append("Procesador : "
                + info.getProcesador()+ "\n"
        );

    }//GEN-LAST:event_btInfoActionPerformed

    private void btn_extraerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_extraerActionPerformed
        // TODO add your handling code here:
        driver.extraerDrivers();
    }//GEN-LAST:event_btn_extraerActionPerformed

    private void btn_instalarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_instalarActionPerformed
        driver.instalarDrivers();
    }//GEN-LAST:event_btn_instalarActionPerformed

    private void btn_cardReaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cardReaderActionPerformed
           driver.installarCardReader();
                
    }//GEN-LAST:event_btn_cardReaderActionPerformed

    private void btn_customActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_customActionPerformed
         driver.customDrivers();
    }//GEN-LAST:event_btn_customActionPerformed

    private void btInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btInfoMouseEntered
        this.btInfo.setToolTipText("Leer informaciones");
    }//GEN-LAST:event_btInfoMouseEntered

    private void btn_extraerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_extraerMouseEntered
         this.btn_extraer.setToolTipText("Extaer todos los drivers de esta maquina");
    }//GEN-LAST:event_btn_extraerMouseEntered

    private void btn_instalarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_instalarMouseEntered
         this.btn_instalar.setToolTipText("Instalar drivers existentes, o extraido");
    }//GEN-LAST:event_btn_instalarMouseEntered

    private void btn_cardReaderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cardReaderMouseEntered
        this.btn_cardReader.setToolTipText("Instalar lector de targetas: sdcard, sdcard reader ...");
    }//GEN-LAST:event_btn_cardReaderMouseEntered

    private void btn_customMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_customMouseEntered
       this.btn_custom.setToolTipText("Instalar drivers personalizados o de terceros");
    }//GEN-LAST:event_btn_customMouseEntered

    /**
     * @param args the command line arguments
     */   public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     }
 



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btInfo;
    private javax.swing.JButton btn_cardReader;
    private javax.swing.JButton btn_custom;
    private javax.swing.JButton btn_extraer;
    private javax.swing.JButton btn_instalar;
    public java.awt.TextArea consola;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
