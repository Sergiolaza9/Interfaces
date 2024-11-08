/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.EjercicioEvaluable;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author alumno
 */
public class VentaOrdenador extends javax.swing.JFrame {
        private Vector<Venta> vectorventa = new Vector<>();
        private DefaultListModel<String> listamodelo = new DefaultListModel<>();
        public void desabilita(){
            this.Localidad.setEnabled(false);
            this.Eliminar.setEnabled(false);
            this.Añadir.setEnabled(false);
            this.Buscar.setEnabled(false);
            this.Procesador1.setEnabled(false);
            this.Procesador2.setEnabled(false);
            this.Procesador3.setEnabled(false);
            this.Procesador4.setEnabled(false);
            this.Memoria1.setEnabled(false);
            this.Memoria2.setEnabled(false);
            this.Memoria3.setEnabled(false);
            this.Memoria4.setEnabled(false);
            this.Monitor1.setEnabled(false);
            this.Monitor2.setEnabled(false);
            this.Monitor3.setEnabled(false);
            this.Monitor4.setEnabled(false);
            this.Disco1.setEnabled(false);
            this.Disco2.setEnabled(false);
            this.Disco3.setEnabled(false);
            this.Disco4.setEnabled(false);
            this.Opciones1.setEnabled(false);
            this.Opciones2.setEnabled(false);
            this.Opciones3.setEnabled(false);
            this.Opciones4.setEnabled(false);
            Localidad.requestFocusInWindow();
        }
          private void procesarNombreCliente(){
              String nombre=Nombre.getText();
             if (!nombre.isEmpty()){ 
                 this.Localidad.setEnabled(true);
                 this.Procesador1.setEnabled(true);
                 this.Procesador2.setEnabled(true);
                 this.Procesador3.setEnabled(true);
                 this.Procesador4.setEnabled(true);
                 this.Memoria1.setEnabled(true);
                 this.Memoria2.setEnabled(true);
                 this.Memoria3.setEnabled (true);
                 this.Memoria4.setEnabled(true);
                 this.Monitor1.setEnabled(true);
                 this.Monitor2.setEnabled(true);
                 this.Monitor3.setEnabled(true);
                 this.Monitor4.setEnabled(true);
                 this.Disco1.setEnabled(true);
                 this.Disco2.setEnabled(true);
                 this.Disco3.setEnabled(true);
                 this.Disco4.setEnabled(true);
                 this.Opciones1.setEnabled(true);
                 this.Opciones2.setEnabled(true);
                 this.Opciones3.setEnabled(true);
                 this.Opciones4.setEnabled(true);
                 Procesador2.setSelected(true);
                 Memoria4.setSelected(true);
                 Monitor4.setSelected(true);
                 Disco4.setSelected(true);
                 Opciones1.setSelected(true);
                 Opciones2.setSelected(true);
                 Añadir.setEnabled(true);
                 Buscar.setEnabled(true);
            }
   }
          private void añadir() {
        String nombre = Nombre.getText();
        String localidad = (String) Localidad.getSelectedItem();
        String procesador = getButton(grupo1);
        String ram = getButton(grupo2);
        String monitor = getButton(grupo3);
        String disco = getButton(grupo4);
        String DVD = Opciones1.isSelected() ? "si" : "no";
        String WiFi = Opciones2.isSelected() ? "si" : "no";
        String Sintonizador = Opciones3.isSelected() ? "si" : "no";
        String Backup = Opciones4.isSelected() ? "si" : "no";
        Venta venta = new Venta(nombre, localidad, procesador, ram, monitor, disco, DVD, WiFi, Sintonizador, Backup);
        vectorventa.add(venta);
        listamodelo.addElement(nombre);
        Lista.setModel(listamodelo);
        desabilita();
        Nombre.setText("");      
    }
        private String getButton(ButtonGroup group) {
        if (group.getSelection() != null) {
            return group.getSelection().getActionCommand();
        }
        return "";
    }
private void buscar() {
    String nombreBuscado = Nombre.getText().trim();
    if (nombreBuscado.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un nombre para buscar.");
        return;
    }

    boolean found = false;
    int ventascliente = 0;
    int index = 0;
    int ventaactual = -1;
    Venta ventaEncontrada = null;

    while (index < vectorventa.size()) {
        Venta venta = vectorventa.get(index);
        

        if (venta.getNombre().equalsIgnoreCase(nombreBuscado)) {
            ventascliente++;
            found = true;
            if (ventaactual == -1) {
                ventaactual = index;
                ventaEncontrada = venta;
            }
            actualizarBotones(venta);
            if (ventascliente > 1) {
                int respuesta = JOptionPane.showConfirmDialog(this, 
                    "¿Desea ver otra venta del mismo cliente?", "Buscar más ventas", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.NO_OPTION) {
                    break;
                }
            }
        }        
        index++;

    if (!found) {
        JOptionPane.showMessageDialog(this, "No se han encontrado ventas para el cliente: " + nombreBuscado);
    } else {
        if (ventaEncontrada != null) {
            actualizarBotones(ventaEncontrada);
            }
        }
    }
}
private void eliminarVenta() {
    String nombreSeleccionado = Lista.getSelectedValue();
    if (nombreSeleccionado == null) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un cliente de la lista.");
        return;
    }
    
    Venta ventaAEliminar = null;
    for (Venta venta : vectorventa) {
        if (venta.getNombre().equalsIgnoreCase(nombreSeleccionado)) {
            ventaAEliminar = venta;
            break;
        }
    }

    if (ventaAEliminar == null) {
        JOptionPane.showMessageDialog(this, "No se ha encontrado una venta para el cliente seleccionado.");
        return;
    }

    Nombre.setText(ventaAEliminar.getNombre());
    actualizarBotones(ventaAEliminar);
    Añadir.setEnabled(false);
    Buscar.setEnabled(false);
    Eliminar.setEnabled(true);

    int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar esta venta?", 
                                                  "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

    if (respuesta == JOptionPane.YES_OPTION) {
        vectorventa.remove(ventaAEliminar);
        listamodelo.removeElement(nombreSeleccionado);
        JOptionPane.showMessageDialog(this, "Venta eliminada exitosamente.");
        Nombre.setText("");
        desmarcarBotones();
        Añadir.setEnabled(true);
        Buscar.setEnabled(true);
        Eliminar.setEnabled(false);
    }
}

private void desmarcarBotones() {
    Procesador1.setSelected(false);
    Procesador2.setSelected(false);
    Procesador3.setSelected(false);
    Procesador4.setSelected(false);
    Memoria1.setSelected(false);
    Memoria2.setSelected(false);
    Memoria3.setSelected(false);
    Memoria4.setSelected(false);
    Monitor1.setSelected(false);
    Monitor2.setSelected(false);
    Monitor3.setSelected(false);
    Monitor4.setSelected(false);
    Disco1.setSelected(false);
    Disco2.setSelected(false);
    Disco3.setSelected(false);
    Disco4.setSelected(false);
    Opciones1.setSelected(false);
    Opciones2.setSelected(false);
    Opciones3.setSelected(false);
    Opciones4.setSelected(false);
}
    public VentaOrdenador() {
    initComponents();
    this.setLocationRelativeTo(null); 
    desabilita();

    // Definir los comandos de los botones
    Procesador1.setActionCommand("Procesador1");
    Procesador2.setActionCommand("Procesador2");
    Procesador3.setActionCommand("Procesador3");
    Procesador4.setActionCommand("Procesador4");

    Memoria1.setActionCommand("Memoria1");
    Memoria2.setActionCommand("Memoria2");
    Memoria3.setActionCommand("Memoria3");
    Memoria4.setActionCommand("Memoria4");

    Monitor1.setActionCommand("Monitor1");
    Monitor2.setActionCommand("Monitor2");
    Monitor3.setActionCommand("Monitor3");
    Monitor4.setActionCommand("Monitor4");

    Disco1.setActionCommand("Disco1");
    Disco2.setActionCommand("Disco2");
    Disco3.setActionCommand("Disco3");
    Disco4.setActionCommand("Disco4");

    Nombre.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            procesarNombreCliente();
        }
    });
    
    Lista.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                String nombreSeleccionado = Lista.getSelectedValue();
                if (nombreSeleccionado != null) {
                    mostrarDetallesVenta(nombreSeleccionado);
                }
            }
        }
    });
}

private void mostrarDetallesVenta(String nombreCliente) {
    Venta ventaSeleccionada = null;
    for (Venta venta : vectorventa) {
        if (venta.getNombre().equalsIgnoreCase(nombreCliente)) {
            ventaSeleccionada = venta;
            break;
        }
    }

    if (ventaSeleccionada != null) {
        Nombre.setText(ventaSeleccionada.getNombre());
        actualizarBotones(ventaSeleccionada);
        Eliminar.setEnabled(true);
        Añadir.setEnabled(false);
        Buscar.setEnabled(false);
    } else {
        JOptionPane.showMessageDialog(this, "No se han encontrado detalles para el cliente seleccionado.");
    }
}

private void actualizarBotones(Venta venta) {
    if (venta.getProcesador().equals("Procesador1")) {
        Procesador1.setSelected(true);
    } else if (venta.getProcesador().equals("Procesador2")) {
        Procesador2.setSelected(true);
    } else if (venta.getProcesador().equals("Procesador3")) {
        Procesador3.setSelected(true);
    } else if (venta.getProcesador().equals("Procesador4")) {
        Procesador4.setSelected(true);
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo1 = new javax.swing.ButtonGroup();
        grupo2 = new javax.swing.ButtonGroup();
        grupo3 = new javax.swing.ButtonGroup();
        grupo4 = new javax.swing.ButtonGroup();
        Nombre = new javax.swing.JTextField();
        pane = new javax.swing.JScrollPane();
        Lista = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Localidad = new javax.swing.JComboBox<>();
        Procesador = new javax.swing.JLabel();
        Procesador1 = new javax.swing.JRadioButton();
        Procesador2 = new javax.swing.JRadioButton();
        Procesador3 = new javax.swing.JRadioButton();
        Procesador4 = new javax.swing.JRadioButton();
        Memoria = new javax.swing.JLabel();
        Memoria1 = new javax.swing.JRadioButton();
        Memoria2 = new javax.swing.JRadioButton();
        Memoria3 = new javax.swing.JRadioButton();
        Memoria4 = new javax.swing.JRadioButton();
        Monitor = new javax.swing.JLabel();
        Monitor1 = new javax.swing.JRadioButton();
        Monitor2 = new javax.swing.JRadioButton();
        Monitor3 = new javax.swing.JRadioButton();
        Monitor4 = new javax.swing.JRadioButton();
        DiscoDuro = new javax.swing.JLabel();
        Disco1 = new javax.swing.JRadioButton();
        Disco2 = new javax.swing.JRadioButton();
        Disco3 = new javax.swing.JRadioButton();
        Disco4 = new javax.swing.JRadioButton();
        Opciones = new javax.swing.JLabel();
        Opciones1 = new javax.swing.JCheckBox();
        Opciones2 = new javax.swing.JCheckBox();
        Opciones3 = new javax.swing.JCheckBox();
        Opciones4 = new javax.swing.JCheckBox();
        Añadir = new javax.swing.JButton();
        Buscar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        clientes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 250));
        setResizable(false);

        Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreActionPerformed(evt);
            }
        });
        Nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NombreKeyTyped(evt);
            }
        });

        pane.setViewportView(Lista);

        jLabel1.setText("Nombre del cliente");

        jLabel2.setText("Localidad");

        Localidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Villalba", "Alpedrete", "Galapagar", "Guadarrama", "Moralzarzal" }));

        Procesador.setText("Procesador");

        grupo1.add(Procesador1);
        Procesador1.setText("P4 3.0 Gb");
        Procesador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Procesador1ActionPerformed(evt);
            }
        });

        grupo1.add(Procesador2);
        Procesador2.setText("P4 3.2 Gb");

        grupo1.add(Procesador3);
        Procesador3.setText("P4 Celeron");

        grupo1.add(Procesador4);
        Procesador4.setText("Amd 650");

        Memoria.setText("Memoria");

        grupo2.add(Memoria1);
        Memoria1.setText("128 Mb");
        Memoria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Memoria1ActionPerformed(evt);
            }
        });

        grupo2.add(Memoria2);
        Memoria2.setText("256 Mb");

        grupo2.add(Memoria3);
        Memoria3.setText("512Mb");
        Memoria3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Memoria3ActionPerformed(evt);
            }
        });

        grupo2.add(Memoria4);
        Memoria4.setText("1024Mb");

        Monitor.setText("Monitor");

        grupo3.add(Monitor1);
        Monitor1.setText("15\"");
        Monitor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Monitor1ActionPerformed(evt);
            }
        });

        grupo3.add(Monitor2);
        Monitor2.setText("17\"");

        grupo3.add(Monitor3);
        Monitor3.setText("TFT 15\"");

        grupo3.add(Monitor4);
        Monitor4.setText("TFT 17\"");

        DiscoDuro.setText("Disco Duro");

        grupo4.add(Disco1);
        Disco1.setText("60Gb");
        Disco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Disco1ActionPerformed(evt);
            }
        });

        grupo4.add(Disco2);
        Disco2.setText("80Gb");
        Disco2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Disco2ActionPerformed(evt);
            }
        });

        grupo4.add(Disco3);
        Disco3.setText("120Gb");
        Disco3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Disco3ActionPerformed(evt);
            }
        });

        grupo4.add(Disco4);
        Disco4.setText("200Gb");
        Disco4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Disco4ActionPerformed(evt);
            }
        });

        Opciones.setText("Opciones");

        Opciones1.setText("Grabadora DVD");

        Opciones2.setText("Wifi");
        Opciones2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Opciones2ActionPerformed(evt);
            }
        });

        Opciones3.setText("Sintonizador TV");

        Opciones4.setText("Backup/Restore");

        Añadir.setText("Añadir");
        Añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AñadirActionPerformed(evt);
            }
        });

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        clientes.setText("Lista de Clientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clientes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pane, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Procesador3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                    .addComponent(Procesador4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Memoria3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Memoria4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Procesador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Localidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Procesador1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                    .addComponent(Procesador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Memoria, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Memoria1)
                                    .addComponent(Memoria2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Monitor2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Monitor1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Monitor, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Monitor3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Monitor4)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Añadir, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Buscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Eliminar)))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Disco3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Opciones3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Disco2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Opciones2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Disco1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Opciones1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DiscoDuro, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Opciones, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(Disco4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Opciones4))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(111, 111, 111)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(clientes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(Localidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pane, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Procesador)
                    .addComponent(Memoria)
                    .addComponent(Monitor)
                    .addComponent(DiscoDuro)
                    .addComponent(Opciones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Procesador1)
                    .addComponent(Memoria1)
                    .addComponent(Monitor1)
                    .addComponent(Disco1)
                    .addComponent(Opciones1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Procesador2)
                    .addComponent(Memoria2)
                    .addComponent(Monitor2)
                    .addComponent(Disco2)
                    .addComponent(Opciones2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Procesador3)
                    .addComponent(Monitor3)
                    .addComponent(Memoria3)
                    .addComponent(Disco3)
                    .addComponent(Opciones3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Procesador4)
                    .addComponent(Monitor4)
                    .addComponent(Memoria4)
                    .addComponent(Disco4)
                    .addComponent(Opciones4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Salir, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Añadir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Buscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreActionPerformed

    private void Disco2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Disco2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Disco2ActionPerformed

    private void Disco3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Disco3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Disco3ActionPerformed

    private void Disco4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Disco4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Disco4ActionPerformed

    private void Disco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Disco1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Disco1ActionPerformed

    private void Procesador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Procesador1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Procesador1ActionPerformed

    private void Memoria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Memoria1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Memoria1ActionPerformed

    private void Monitor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Monitor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Monitor1ActionPerformed

    private void Opciones2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Opciones2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Opciones2ActionPerformed

    private void AñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñadirActionPerformed
        añadir();
    }//GEN-LAST:event_AñadirActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
       System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    private void Memoria3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Memoria3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Memoria3ActionPerformed

    private void NombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreKeyTyped
        if (Nombre.getText().length()>=15){
            evt.consume();
        }
    }//GEN-LAST:event_NombreKeyTyped

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
       desabilita();
       Nombre.setText("");
       
    }//GEN-LAST:event_CancelarActionPerformed
    
    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
    buscar();
    }//GEN-LAST:event_BuscarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        eliminarVenta();
    }//GEN-LAST:event_EliminarActionPerformed

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
            java.util.logging.Logger.getLogger(VentaOrdenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentaOrdenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentaOrdenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentaOrdenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentaOrdenador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Añadir;
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Cancelar;
    private javax.swing.JRadioButton Disco1;
    private javax.swing.JRadioButton Disco2;
    private javax.swing.JRadioButton Disco3;
    private javax.swing.JRadioButton Disco4;
    private javax.swing.JLabel DiscoDuro;
    private javax.swing.JButton Eliminar;
    private javax.swing.JList<String> Lista;
    private javax.swing.JComboBox<String> Localidad;
    private javax.swing.JLabel Memoria;
    private javax.swing.JRadioButton Memoria1;
    private javax.swing.JRadioButton Memoria2;
    private javax.swing.JRadioButton Memoria3;
    private javax.swing.JRadioButton Memoria4;
    private javax.swing.JLabel Monitor;
    private javax.swing.JRadioButton Monitor1;
    private javax.swing.JRadioButton Monitor2;
    private javax.swing.JRadioButton Monitor3;
    private javax.swing.JRadioButton Monitor4;
    private javax.swing.JTextField Nombre;
    private javax.swing.JLabel Opciones;
    private javax.swing.JCheckBox Opciones1;
    private javax.swing.JCheckBox Opciones2;
    private javax.swing.JCheckBox Opciones3;
    private javax.swing.JCheckBox Opciones4;
    private javax.swing.JLabel Procesador;
    private javax.swing.JRadioButton Procesador1;
    private javax.swing.JRadioButton Procesador2;
    private javax.swing.JRadioButton Procesador3;
    private javax.swing.JRadioButton Procesador4;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel clientes;
    private javax.swing.ButtonGroup grupo1;
    private javax.swing.ButtonGroup grupo2;
    private javax.swing.ButtonGroup grupo3;
    private javax.swing.ButtonGroup grupo4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane pane;
    // End of variables declaration//GEN-END:variables
}
