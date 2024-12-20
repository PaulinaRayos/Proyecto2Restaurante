/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dto.ClienteDTO;
import dto.MesaDTO;
import dto.ReporteDTO;
import dto.ReservaDTO;
import dto.TipoMesaDTO;
import excepciones.NegocioException;
import interfaces.IClienteBO;
import interfaces.IConsultarReservasBO;
import interfaces.IMesaBO;
import interfaces.IReporteBO;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.ClienteBO;
import negocio.ConsultarReservasBO;
import negocio.MesaBO;
import negocio.ReporteBO;
import utilidades.Forms;

/**
 *
 * @author Chris
 */
public class FormReportes extends javax.swing.JFrame {

    DefaultTableModel modeloTabla = new DefaultTableModel();
    private final IClienteBO clienteBO;
    private final IMesaBO mesabo;
    private final IReporteBO reportebo;
    private final IConsultarReservasBO consultaBO;
    private List<ReservaDTO> reservas;
    private List<ReservaDTO> reservasFiltradas;

    /**
     * Creates new form FormReportes
     */
    public FormReportes() {
        initComponents();
        this.reportebo = new ReporteBO();
        this.consultaBO = new ConsultarReservasBO();
        this.clienteBO = new ClienteBO();
        this.mesabo = new MesaBO();
        try {
            this.reservas = consultaBO.obtenerTodasLasReservas();
        } catch (Exception e) {
            Logger.getLogger(FormReportes.class.getName()).log(Level.SEVERE, null, e);
        }
        this.setLocationRelativeTo(this);
        this.actualizarTabla(reservas);

        this.SetImageLabel(jLabel3, "src/main/java/Imagenes/logo.png");
    }

    /**
     * Metodo para limpiar la tabla de Reportes.
     */
    private void limpiarTabla() {
        modeloTabla = (DefaultTableModel) tblReportes.getModel();
        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }
    }

    /**
     * Actualiza la tabla de reportes con la información de las reservas
     * especificados. Crea un nuevo modelo de tabla y lo asigna a la tabla de
     * reportes.
     *
     * @param reservas La lista de las reservas que se utilizará para actualizar
     * la tabla.
     */
    private void actualizarTabla(List<ReservaDTO> reservas) {
        try {
            DefaultTableModel reservasTabla = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Hacer que todas las celdas sean no editables
                }
            };
            reservasTabla.addColumn("Fecha/Hora");
            reservasTabla.addColumn("Cliente");
            reservasTabla.addColumn("Codigo mesa");
            reservasTabla.addColumn("Tipo de mesa");
            reservasTabla.addColumn("Ubicación");
            reservasTabla.addColumn("Costo");
            reservasTabla.addColumn("Multa");

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            for (ReservaDTO reserva : reservas) {

                ClienteDTO cliente = clienteBO.obtenerClientePorId(reserva.getIdCliente());
                MesaDTO mesa = mesabo.obtenerMesaPorId(reserva.getIdMesa());
                TipoMesaDTO tipoMesa = mesabo.obtenerTipoMesaaPorId(mesa.getIdTipoMesa());

                String nombreCliente = cliente.getNombre() + " " + cliente.getApellidoPaterno() + " " + cliente.getApellidoMaterno();

                String costoFormato = String.format("%.2f", reserva.getCosto());
                String multaFormato = reserva.getMulta() != null ? String.format("%.2f", reserva.getMulta()) : "0.00";
                Object[] fila = {
                    dateFormat.format(reserva.getFechaHora()),
                    nombreCliente,
                    mesa.getCodigoMesa(),
                    tipoMesa.getNombreTipo(),
                    mesa.getUbicacion(),
                    "$" + costoFormato + " MXN",
                    "$" + multaFormato + " MXN"
                };

                reservasTabla.addRow(fila);
            }

            tblReportes.setModel(reservasTabla);

        } catch (PersistenceException | NegocioException ex) {
            Logger.getLogger(FormReportes.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReportes = new javax.swing.JTable();
        jLabelaa2 = new javax.swing.JLabel();
        bPDF = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabelaa1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jFechaFin = new com.toedter.calendar.JDateChooser();
        cbUbicacion = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbTipoMesa = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        bFiltro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 51, 153));

        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText(" Amadeustaurant");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(411, 411, 411)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setForeground(new java.awt.Color(0, 0, 0));

        tblReportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Fecha/Hora", "Cliente", "Codigo mesa", "Tipo de mesa", "Ubicación", "Costo", "Multa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblReportes);

        jLabelaa2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabelaa2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelaa2.setText("Vista Previa del Reporte");
        jLabelaa2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bPDF.setBackground(new java.awt.Color(255, 51, 153));
        bPDF.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        bPDF.setText("Exportar PDF");
        bPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelaa2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1036, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelaa2)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(bPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Rango de fechas:");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelaa1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabelaa1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelaa1.setText("Filtros de Reporte");
        jLabelaa1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("hasta");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbUbicacion.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        cbUbicacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona ubicacion mesa", "General", "Terraza", "Ventana" }));
        cbUbicacion.setBorder(null);
        cbUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUbicacionActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel9.setText("Ubicación:");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbTipoMesa.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        cbTipoMesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona tipo de mesa", "Mesa pequeña", "Mesa mediana", "Mesa grande" }));
        cbTipoMesa.setBorder(null);
        cbTipoMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoMesaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel10.setText("Tipo de Mesa:");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bFiltro.setBackground(new java.awt.Color(255, 51, 153));
        bFiltro.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        bFiltro.setText("Filtrar");
        bFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFiltroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTipoMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(cbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabelaa1)
                        .addGap(55, 55, 55))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabelaa1)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbTipoMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        Forms.cargarForm(new FormMenu(), this);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void cbUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUbicacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbUbicacionActionPerformed

    private void cbTipoMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoMesaActionPerformed

    private void bPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDFActionPerformed
        if (reservasFiltradas != null && !reservasFiltradas.isEmpty()) {
            try {
                // Convertir tramitesFiltrados a ReporteDTO
                List<ReporteDTO> reportes = reportebo.convertirReservasAReportes(reservasFiltradas);

                reportebo.generarReporte(reportes);
                JOptionPane.showMessageDialog(this, "Reporte generado exitosamente");
            } catch (NegocioException ex) {
                JOptionPane.showMessageDialog(this, "El reporte no ha sido generado, seleccione un filtro y inténtelo ", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            int respuesta = JOptionPane.showConfirmDialog(this,
                    "No ha seleccionado ningún filtro. ¿Desea continuar sin filtros?",
                    "Confirmación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (respuesta == JOptionPane.YES_OPTION) {
                try {
                    // Generar reporte sin filtros
                    List<ReporteDTO> reportes = reportebo.convertirReservasAReportes(reservas);
                    reportebo.generarReporte(reportes);
                    JOptionPane.showMessageDialog(this, "Reporte generado exitosamente");
                } catch (NegocioException ex) {
                    JOptionPane.showMessageDialog(this, "El reporte no ha sido generado, seleccione un filtro y inténtelo ", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Operación cancelada. Por favor, seleccione un filtro e intente nuevamente.", "Operación Cancelada", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_bPDFActionPerformed

    private void bFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFiltroActionPerformed
        reservasFiltradas = new ArrayList<>();

        if (cbTipoMesa.getSelectedItem() != null) {
            String tipoMesaSeleccionado = cbTipoMesa.getSelectedItem().toString().trim();
            if (!tipoMesaSeleccionado.equals("Selecciona el tipo mesa")) {
                List<ReservaDTO> reservasPorTipo = new ArrayList<>();
                for (ReservaDTO reserva : reservas) {
                    try {
                        MesaDTO mesa = mesabo.obtenerMesaPorId(reserva.getIdMesa());
                        TipoMesaDTO tipomesa = mesabo.obtenerTipoMesaaPorId(mesa.getIdTipoMesa());
                        String tipoMesa = tipomesa.getNombreTipo();
                        if (tipoMesa.equalsIgnoreCase(tipoMesaSeleccionado)) {
                            reservasPorTipo.add(reserva);
                        }
                    } catch (NegocioException ex) {
                        Logger.getLogger(FormReportes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                reservasFiltradas = reservasPorTipo;
            }
        }

        // Filtro de ubicación
        if (cbUbicacion.getSelectedItem() != null) {
            String ubicacionSeleccionada = cbUbicacion.getSelectedItem().toString().trim();
            if (!ubicacionSeleccionada.equals("Selecciona ubicacion mesa")) {
                List<ReservaDTO> reservasPorUbicacion = new ArrayList<>();
                for (ReservaDTO reserva : reservas) {
                    try {
                        MesaDTO mesa = mesabo.obtenerMesaPorId(reserva.getIdMesa());
                        String ubicacionMesa = mesa.getUbicacion();
                        if (ubicacionMesa.equalsIgnoreCase(ubicacionSeleccionada)) {
                            reservasPorUbicacion.add(reserva);
                        }
                    } catch (NegocioException ex) {
                        Logger.getLogger(FormReportes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                reservasFiltradas = reservasPorUbicacion;
            }
        }

        // Filtro de rango de fecha
        Date fechaInicioSeleccionada = jFechaInicio.getDate();
        Date fechaFinSeleccionada = jFechaFin.getDate();
        if (fechaInicioSeleccionada != null && fechaFinSeleccionada != null) {
            List<ReservaDTO> reservasPorFecha = new ArrayList<>();
            for (ReservaDTO reserva : reservas) {
                Date fechaReserva = reserva.getFechaHora();
                if ((fechaReserva.equals(fechaInicioSeleccionada) || fechaReserva.after(fechaInicioSeleccionada))
                        && (fechaReserva.equals(fechaFinSeleccionada) || fechaReserva.before(fechaFinSeleccionada))) {
                    reservasPorFecha.add(reserva);
                }
            }
            reservasFiltradas = reservasPorFecha;
        }

        // Limpiar y actualizar la tabla con los resultados filtrados
        limpiarTabla();
        actualizarTabla(reservasFiltradas);
    }//GEN-LAST:event_bFiltroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bFiltro;
    private javax.swing.JButton bPDF;
    private javax.swing.JComboBox<String> cbTipoMesa;
    private javax.swing.JComboBox<String> cbUbicacion;
    private com.toedter.calendar.JDateChooser jFechaFin;
    private com.toedter.calendar.JDateChooser jFechaInicio;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelaa1;
    private javax.swing.JLabel jLabelaa2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblReportes;
    // End of variables declaration//GEN-END:variables
private void SetImageLabel(JLabel labelname, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelname.getWidth(), labelname.getHeight(), Image.SCALE_DEFAULT));
        labelname.setIcon(icon);
        this.repaint();
    }

}
