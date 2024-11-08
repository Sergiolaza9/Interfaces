/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.EjercicioEvaluable;

/**
 *
 * @author alumno
 */
public class Venta extends javax.swing.JFrame {
    private String nombre;
    private String localidad;
    private String procesador;
    private String ram;
    private String monitor;
    private String disco;
    private String DVD;
    private String WiFi;
    private String Sintonizador;
    private String Backup;
    
    
    public Venta(String clientName, String location, String processor, String ram, String monitor, String disco, String DVD, String WiFi, String sintonizador, String backup) {
        this.nombre = clientName;
        this.localidad = location;
        this.procesador = processor;
        this.ram = ram;
        this.monitor = monitor;
        this.disco = disco;
        this.DVD = DVD;
        this.WiFi = WiFi;
        this.Sintonizador=sintonizador;
        this.Backup= backup;
    }
      public String toString() {
        return nombre + " - " + localidad + " - " + procesador + " - " + ram + " - " + monitor + " - " + disco
               + " - DVD: " + DVD + ", WiFi: " + WiFi + ", Sintonizador: " + Sintonizador + ", Backup: " + Backup;
    }
    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getProcesador() {
        return procesador;
    }

    public String getRam() {
        return ram;
    }

    public String getMonitor() {
        return monitor;
    }

    public String getDisco() {
        return disco;
    }

    public String getDVD() {
        return DVD;
    }

    public String getWiFi() {
        return WiFi;
    }

    public String getSintonizador() {
        return Sintonizador;
    }

    public String getBackup() {
        return Backup;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public void setDisco(String disco) {
        this.disco = disco;
    }

    public void setDVD(String DVD) {
        this.DVD = DVD;
    }

    public void setWiFi(String WiFi) {
        this.WiFi = WiFi;
    }

    public void setSintonizador(String Sintonizador) {
        this.Sintonizador = Sintonizador;
    }

    public void setBackup(String Backup) {
        this.Backup = Backup;
    }
    /**
     * Creates new form VEnta
     */
    public Venta() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Venta().setVisible(true);
            }
        });
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
