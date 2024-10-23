/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dto.MesaDTO;
import dto.ReservaDTO;
import dto.RestauranteDTO;
import excepciones.NegocioException;
import interfaces.IAgregarReservaBO;
import interfaces.IClienteBO;
import interfaces.IMesaBO;
import interfaces.IRestauranteBO;
import java.awt.Image;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import negocio.AgregarReservaBO;
import negocio.ClienteBO;
import negocio.MesaBO;
import negocio.RestauranteBO;
import utilidades.Forms;

/**
 *
 * @author pauli
 */
public class FormMenu extends javax.swing.JFrame {

    private final IAgregarReservaBO agregarReservaBO;
    private JTable tablaMesas;
    private Long idMesaSeleccionada;
    private final IClienteBO clienteBO;
    private boolean isComboBoxLoaded = false;
    private final IMesaBO mesaBO;
    private final IRestauranteBO restBO;

    /**
     * Creates new form FormMenu
     */
    public FormMenu() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.agregarReservaBO = new AgregarReservaBO();
        this.clienteBO = new ClienteBO();
        this.mesaBO = new MesaBO();
        this.restBO = new RestauranteBO();

        this.SetImageLabel(jLabel3, "src/main/java/Imagenes/logo.png");

        cargarClientes();
        cargarMesasEnTabla();

        try {
            System.out.println(mesaBO.obtenerTodasLasMesas());
        } catch (NegocioException ex) {
            Logger.getLogger(FormMenu.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelaa = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbCantidad = new javax.swing.JComboBox<>();
        jFecha = new com.toedter.calendar.JDateChooser();
        Date date = new Date();
        SpinnerDateModel sm =
        new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        jHora = new javax.swing.JSpinner(sm);
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbUbicacion = new javax.swing.JComboBox<>();
        bConfirmar = new javax.swing.JButton();
        jComboBoxClientes = new javax.swing.JComboBox<>();
        txtTelefono = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMesas = new javax.swing.JTable();
        jLabelaa1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        bReservas = new javax.swing.JButton();
        bMesas = new javax.swing.JButton();
        bConsultas = new javax.swing.JButton();
        bReportes = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        bClientes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setText("Nombre Completo:");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelaa.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabelaa.setText("Nueva Reservación");
        jLabelaa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel5.setText("Telefono:");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel6.setText("Cantidad personas:");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbCantidad.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        cbCantidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        cbCantidad.setBorder(null);

        JSpinner.DateEditor de = new JSpinner.DateEditor(jHora, "HH:mm:ss");
        jHora.setEditor(de);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel7.setText("Fecha:");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel8.setText("Hora:");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel9.setText("Ubicación:");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbUbicacion.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        cbUbicacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General", "Terraza", "Ventana" }));
        cbUbicacion.setBorder(null);

        bConfirmar.setBackground(new java.awt.Color(255, 51, 153));
        bConfirmar.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        bConfirmar.setText("Reservar");
        bConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConfirmarActionPerformed(evt);
            }
        });

        jComboBoxClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxClientesActionPerformed(evt);
            }
        });

        txtTelefono.setEditable(false);
        txtTelefono.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefono.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(0, 0, 0));
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(40, 40, 40)
                                .addComponent(cbCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jHora, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel9)
                            .addComponent(cbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(bConfirmar)))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabelaa)
                    .addContainerGap(236, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(cbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(bConfirmar)
                .addGap(41, 41, 41))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabelaa)
                    .addContainerGap(634, Short.MAX_VALUE)))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblMesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ubicacion", "Mesa", "Capacidad", "Horario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMesas);

        jLabelaa1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabelaa1.setText("Mesas Disponibles");
        jLabelaa1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabelaa1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabelaa1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 51, 153));

        bReservas.setBackground(new java.awt.Color(255, 51, 153));
        bReservas.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        bReservas.setText("Reservas");
        bReservas.setBorder(null);
        bReservas.setContentAreaFilled(false);
        bReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReservasActionPerformed(evt);
            }
        });

        bMesas.setBackground(new java.awt.Color(255, 51, 153));
        bMesas.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        bMesas.setText("Mesas");
        bMesas.setBorder(null);
        bMesas.setContentAreaFilled(false);
        bMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMesasActionPerformed(evt);
            }
        });

        bConsultas.setBackground(new java.awt.Color(255, 51, 153));
        bConsultas.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        bConsultas.setText("Consultas");
        bConsultas.setBorder(null);
        bConsultas.setContentAreaFilled(false);
        bConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsultasActionPerformed(evt);
            }
        });

        bReportes.setBackground(new java.awt.Color(255, 51, 153));
        bReportes.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        bReportes.setText("Reportes");
        bReportes.setBorder(null);
        bReportes.setContentAreaFilled(false);
        bReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReportesActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        jLabel4.setText(" Amadeustaurant");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bClientes.setBackground(new java.awt.Color(255, 51, 153));
        bClientes.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        bClientes.setText("Clientes");
        bClientes.setBorder(null);
        bClientes.setContentAreaFilled(false);
        bClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bReservas)
                .addGap(43, 43, 43)
                .addComponent(bMesas)
                .addGap(51, 51, 51)
                .addComponent(bConsultas)
                .addGap(53, 53, 53)
                .addComponent(bReportes)
                .addGap(53, 53, 53)
                .addComponent(bClientes)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bReservas)
                    .addComponent(bMesas)
                    .addComponent(bConsultas)
                    .addComponent(bReportes)
                    .addComponent(jLabel4)
                    .addComponent(bClientes))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMesasActionPerformed
        Forms.cargarForm(new FormMesas(), this);
    }//GEN-LAST:event_bMesasActionPerformed

    private void bReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReservasActionPerformed
        Forms.cargarForm(new FormReservas(), this);
    }//GEN-LAST:event_bReservasActionPerformed

    private void bConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsultasActionPerformed
        Forms.cargarForm(new FormConsultas(), this);
    }//GEN-LAST:event_bConsultasActionPerformed

    private void bReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bReportesActionPerformed

    private void bConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConfirmarActionPerformed
        try {
            // Obtener el cliente seleccionado del JComboBox
            String clienteSeleccionado = (String) jComboBoxClientes.getSelectedItem();
            String selectedItem = (String) cbCantidad.getSelectedItem();
            // Obtener el número de personas seleccionado
            int numPersonas = Integer.parseInt(selectedItem); // Asumiendo que es un JComboBox con enteros

            // Obtener la fecha seleccionada del JSpinner
            Date fechaSeleccionada = (Date) jFecha.getDate(); // Asegúrate que jFecha está configurado correctamente

            // Obtener la hora seleccionada del JSpinner
            Date horaSeleccionada = (Date) jHora.getValue(); // Asegúrate que jHora está configurado correctamente

            // Combinar fecha y hora
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaSeleccionada); // Establecer la fecha seleccionada

            // Extraer la hora y los minutos del JSpinner de hora
            Calendar horaCalendar = Calendar.getInstance();
            horaCalendar.setTime(horaSeleccionada);

            // Establecer la hora y los minutos en el calendar principal
            calendar.set(Calendar.HOUR_OF_DAY, horaCalendar.get(Calendar.HOUR_OF_DAY));
            calendar.set(Calendar.MINUTE, horaCalendar.get(Calendar.MINUTE));
            calendar.set(Calendar.SECOND, 0); // Puedes establecer los segundos si lo necesitas
            calendar.set(Calendar.MILLISECOND, 0); // Puedes establecer los milisegundos si lo necesitas

            // Crear el Date final combinando fecha y hora
            Date fechaHoraFinal = calendar.getTime();

            // Crear un objeto ReservaDTO
            Long idReserva = null; // Si es autoincremental y se genera en la base de datos
            BigDecimal costo = mesaBO.obtenerCostoPorIdMesa(this.idMesaSeleccionada); // Método para calcular el costo
            String estado = "Reservado"; // Estado inicial, puede cambiar según tu lógica
            Date fechaCancelacion = null; // O puedes establecerlo en caso de cancelación
            BigDecimal multa = BigDecimal.ZERO; // O establecer según tu lógica

            String nombreCompleto = (String) jComboBoxClientes.getSelectedItem(); // Obtener el nombre completo seleccionado
            Long idCliente = clienteBO.obtenerIdClientePorNombre(nombreCompleto); // Obtener el ID del cliente

            // Crear el objeto ReservaDTO con fechaHoraFinal
            ReservaDTO reservaDTO = new ReservaDTO(idReserva, fechaHoraFinal, numPersonas, costo, estado, fechaCancelacion, multa, idCliente, this.idMesaSeleccionada);

            // Llamar al método agregarReserva
            try {
                agregarReservaBO.agregarReserva(reservaDTO);
                JOptionPane.showMessageDialog(this, "Reserva agregada exitosamente.");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al agregar la reserva: " + e.getMessage());

            }
        } catch (NegocioException ex) {
            Logger.getLogger(FormMenu.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_bConfirmarActionPerformed

    private void bClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClientesActionPerformed
        Forms.cargarForm(new FormClientes(), this);
    }//GEN-LAST:event_bClientesActionPerformed

    private void jComboBoxClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxClientesActionPerformed

    }//GEN-LAST:event_jComboBoxClientesActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FormMenu().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClientes;
    private javax.swing.JButton bConfirmar;
    private javax.swing.JButton bConsultas;
    private javax.swing.JButton bMesas;
    private javax.swing.JButton bReportes;
    private javax.swing.JButton bReservas;
    private javax.swing.JComboBox<String> cbCantidad;
    private javax.swing.JComboBox<String> cbUbicacion;
    private javax.swing.JComboBox<String> jComboBoxClientes;
    private com.toedter.calendar.JDateChooser jFecha;
    private javax.swing.JSpinner jHora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelaa;
    private javax.swing.JLabel jLabelaa1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMesas;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    private void SetImageLabel(JLabel labelname, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelname.getWidth(), labelname.getHeight(), Image.SCALE_DEFAULT));
        labelname.setIcon(icon);
        this.repaint();
    }

    private void cargarClientes() {
        try {
            // Limpiar el JComboBox de clientes antes de cargar nuevos elementos
            jComboBoxClientes.removeAllItems();
            txtTelefono.setText(""); // Limpiar el JTextField del teléfono

            // Agregar un valor inicial al JComboBox
            jComboBoxClientes.addItem("Seleccionar cliente");

            // Obtener los nombres completos y teléfonos de los clientes desde la capa de negocio
            List<Object[]> clientes = clienteBO.obtenerNombresYTelefonosDeClientes();

            // Llenar el JComboBox con los nombres completos
            for (Object[] cliente : clientes) {
                String nombreCompleto = (String) cliente[0];
                jComboBoxClientes.addItem(nombreCompleto); // Llenar el ComboBox con los nombres
            }

            isComboBoxLoaded = true; // Marcar que el JComboBox ya fue cargado

            jComboBoxClientes.addActionListener(e -> {
                if (isComboBoxLoaded && jComboBoxClientes.getSelectedIndex() > 0) {
                    // Solo ejecutar el código si el ComboBox ya fue cargado y hay una selección válida
                    int selectedIndex = jComboBoxClientes.getSelectedIndex() - 1; // Ajustar el índice debido a la opción extra
                    if (selectedIndex >= 0) {
                        // Obtener el teléfono asociado y mostrarlo en el JTextField
                        String telefono = (String) clientes.get(selectedIndex)[1];
                        txtTelefono.setText(telefono); // Rellenar el JTextField con el teléfono
                    }
                } else {
                    // Limpiar el campo de teléfono si no hay selección válida
                    txtTelefono.setText("");
                }
            });

        } catch (NegocioException e) {
            e.printStackTrace(); // Manejo de errores
        }
    }

    private void cargarMesasEnTabla() {
        try {
            List<MesaDTO> mesas = mesaBO.obtenerTodasLasMesas();

            // Crear un modelo de tabla
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Mesa");
            modelo.addColumn("Ubicación");
            modelo.addColumn("Capacidad");
            modelo.addColumn("Horario");

            // Llenar el modelo con los datos de las mesas
            for (MesaDTO mesa : mesas) {
                Object[] fila = new Object[5];
                fila[0] = mesa.getIdMesa();
                fila[1] = mesa.getCodigoMesa();
                fila[2] = mesa.getUbicacion();
                fila[3] = mesa.getCapacidad();

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

                RestauranteDTO restaurante = restBO.obtenerRestaurantePorId(mesa.getIdRestaurante());

                String horarios = "Apertura: " + (restaurante != null && restaurante.getHoraApertura() != null
                        ? sdf.format(restaurante.getHoraApertura()) : "N/A")
                        + ", Cierre: " + (restaurante != null && restaurante.getHoraCierre() != null
                        ? sdf.format(restaurante.getHoraCierre()) : "N/A");

                fila[4] = horarios;

                modelo.addRow(fila);
            }

            // Crear la JTable con el modelo
            tablaMesas = new JTable(modelo);
            tablaMesas.setFillsViewportHeight(true);

            // Agregar un listener para la selección de filas
            tablaMesas.getSelectionModel().addListSelectionListener(event -> {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = tablaMesas.getSelectedRow();
                    if (selectedRow != -1) {
                        Long idMesa = (Long) tablaMesas.getValueAt(selectedRow, 0);
                        guardarIdMesaSeleccionada(idMesa);
                    }
                }
            });

            // Agregar la JTable al JScrollPane
            jScrollPane1.setViewportView(tablaMesas);
        } catch (NegocioException ex) {
            Logger.getLogger(FormMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void guardarIdMesaSeleccionada(Long idMesa) {
        this.idMesaSeleccionada = idMesa;
    }

}
