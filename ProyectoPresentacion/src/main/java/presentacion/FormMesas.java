/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dto.HorarioDTO;
import dto.MesaDTO;
import dto.RestauranteDTO;
import excepciones.NegocioException;
import interfaces.IAgregaMesasBO;
import interfaces.IMesaBO;
import interfaces.IRestauranteBO;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import negocio.ActualizaHorarioBO;
import negocio.AgregaMesasBO;
import negocio.MesaBO;
import negocio.RestauranteBO;
import utilidades.Forms;
import interfaces.IActualizaHorarioBO;
import interfaces.IHorarioBO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import negocio.HorarioBO;

/**
 *
 * @author Chris
 */
public class FormMesas extends javax.swing.JFrame {

    private IMesaBO mesaBO;
    private IRestauranteBO restBO;
    private IAgregaMesasBO agregadao;
    private IActualizaHorarioBO acthorarioBO;
    private RestauranteDTO restauranteDTO;
    private HorarioDTO horario;
    private List<RestauranteDTO> listaRestaurantes;
    private Long idRestauranteSeleccionado;
    private Long idMesaSeleccionada;
    private final IHorarioBO horariobo;

    /**
     * Creates new form FormMesas
     */
    public FormMesas() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.mesaBO = new MesaBO();
        this.restBO = new RestauranteBO();
        this.agregadao = new AgregaMesasBO();
        this.restauranteDTO = new RestauranteDTO();
        this.horario = new HorarioDTO();
        this.acthorarioBO = new ActualizaHorarioBO();
        this.horariobo = new HorarioBO();
        this.SetImageLabel(jLabel3, "src/main/java/Imagenes/logo.png");

        this.cargarMetodosIniciales();
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
        jLabel9 = new javax.swing.JLabel();
        cbUbicacion = new javax.swing.JComboBox<>();
        bCrear = new javax.swing.JButton();
        jLabelaa2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtPequeña = new javax.swing.JTextField();
        txtMediana = new javax.swing.JTextField();
        txtGrande = new javax.swing.JTextField();
        bTiposMesa = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cbRestaurante = new javax.swing.JComboBox<>();
        cbDia = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMesas = new javax.swing.JTable();
        jLabelaa1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel9.setText("Ubicación:");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbUbicacion.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        cbUbicacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General", "Terraza", "Ventana" }));
        cbUbicacion.setBorder(null);
        cbUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUbicacionActionPerformed(evt);
            }
        });

        bCrear.setBackground(new java.awt.Color(255, 51, 153));
        bCrear.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        bCrear.setText("Generar Mesas");
        bCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCrearActionPerformed(evt);
            }
        });

        jLabelaa2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabelaa2.setText("Agrega Mesas");
        jLabelaa2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel11.setText("Cantidad por tipo:");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel12.setText("Pequeña:");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel13.setText("Mediana:");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel14.setText("Grande:");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtPequeña.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N

        txtMediana.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N

        txtGrande.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N

        bTiposMesa.setBackground(new java.awt.Color(255, 51, 153));
        bTiposMesa.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        bTiposMesa.setText("Inserta tipos");
        bTiposMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTiposMesaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel10.setText("Restaurante:");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbRestaurante.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        cbRestaurante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona restaurante" }));
        cbRestaurante.setBorder(null);

        cbDia.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        cbDia.setBorder(null);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel15.setText("Dia de la semana:");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabelaa2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bTiposMesa)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel10)
                        .addGap(233, 233, 233))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPequeña, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMediana, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtGrande, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(bCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(167, 167, 167))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbUbicacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbDia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbRestaurante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(145, 145, 145))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(222, 222, 222))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(206, 206, 206)))))
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelaa2)
                    .addComponent(bTiposMesa))
                .addGap(3, 3, 3)
                .addComponent(jLabel10)
                .addGap(12, 12, 12)
                .addComponent(cbRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(txtPequeña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMediana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGrande, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bCrear)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblMesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblMesas);

        jLabelaa1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabelaa1.setText("Mesas Disponibles");
        jLabelaa1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelaa1))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabelaa1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 51, 153));

        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        jLabel4.setText(" Amadeustaurant");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(402, 402, 402))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarMetodosIniciales() {
        this.cargarRestaurantes();
        this.cargarMesasEnTabla();
    }

    private void bCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCrearActionPerformed
        try {
            // Obtener el restaurante seleccionado
            RestauranteDTO restauranteSeleccionado = restBO.obtenerRestaurantePorId(idRestauranteSeleccionado);

            // Verificar si se ha seleccionado un restaurante
            if (idRestauranteSeleccionado == null) {
                // Mostrar un diálogo indicando que debe seleccionar un restaurante
                JOptionPane.showMessageDialog(this, "Por favor, seleccione un restaurante válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir del método si no hay selección válida
            }
            // Obtener la ubicación seleccionada
            String ubicacion = (String) cbUbicacion.getSelectedItem();

            // Crear un mapa para almacenar la cantidad de mesas por tipo
            Map<String, Integer> cantidadPorTipo = new HashMap<>();

            // Agregar las cantidades de mesas según los campos de texto
            if (!txtPequeña.getText().isEmpty()) {
                cantidadPorTipo.put("Mesa pequeña", Integer.parseInt(txtPequeña.getText()));
            }
            if (!txtMediana.getText().isEmpty()) {
                cantidadPorTipo.put("Mesa mediana", Integer.parseInt(txtMediana.getText()));
            }
            if (!txtGrande.getText().isEmpty()) {
                cantidadPorTipo.put("Mesa grande", Integer.parseInt(txtGrande.getText()));
            }

            // Llamar al método agregarMesas
            agregadao.agregarMesas(restauranteSeleccionado, cantidadPorTipo, ubicacion);

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(this, "Mesas agregadas exitosamente.");
        } catch (NegocioException e) {
            // Manejar excepciones y mostrar mensaje de error
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            // Manejar errores de formato de número
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos para la cantidad de mesas.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bCrearActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        Forms.cargarForm(new FormMenu(), this);


    }//GEN-LAST:event_jLabel3MouseClicked

    private void bTiposMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTiposMesaActionPerformed
        try {
            // Inicializar tipos de mesa predeterminados
            mesaBO.inicializarTiposMesaPredeterminados();

        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(this, "Error al inicializar los tipos de mesa: " + e.getMessage());
        }
    }//GEN-LAST:event_bTiposMesaActionPerformed

    private void cbUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUbicacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbUbicacionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCrear;
    private javax.swing.JButton bTiposMesa;
    private javax.swing.JComboBox<String> cbDia;
    private javax.swing.JComboBox<String> cbRestaurante;
    private javax.swing.JComboBox<String> cbUbicacion;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelaa1;
    private javax.swing.JLabel jLabelaa2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMesas;
    private javax.swing.JTextField txtGrande;
    private javax.swing.JTextField txtMediana;
    private javax.swing.JTextField txtPequeña;
    // End of variables declaration//GEN-END:variables
private void SetImageLabel(JLabel labelname, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelname.getWidth(), labelname.getHeight(), Image.SCALE_DEFAULT));
        labelname.setIcon(icon);
        this.repaint();
    }

    public LocalTime obtenerHoraDesdeSpinner(JSpinner spinner) {
        // Obtener la hora desde el spinner
        Date date = (Date) spinner.getValue();

        // Convertir el objeto Date a LocalTime (para trabajar solo con el tiempo)
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        return LocalTime.of(hour, minute);
    }

    private String obtenerNombreDia(Date fecha) {
        SimpleDateFormat formatoDia = new SimpleDateFormat("EEEE", new Locale("es", "ES"));
        return formatoDia.format(fecha);
    }

    public Date combinarFechaYHora(Date fecha, LocalTime hora) {
        LocalDate localDate = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Crear LocalDateTime combinando la fecha con la hora
        LocalDateTime fechaConHora = LocalDateTime.of(localDate, hora);

        // Convertir LocalDateTime de vuelta a java.util.Date
        return Date.from(fechaConHora.atZone(ZoneId.systemDefault()).toInstant());
    }

    private void cargarRestaurantes() {
        try {
            cbRestaurante.removeAllItems(); // Limpiar elementos actuales
            listaRestaurantes = restBO.obtenerRestaurantes(); // Obtener la lista de restaurantes

            cbRestaurante.addItem("Seleccionar restaurante"); // Agregar opción de selección

            // Llenar el JComboBox con las cadenas que deseas mostrar
            for (RestauranteDTO restaurante : listaRestaurantes) {
                String displayText = restaurante.getCiudad() + " - " + restaurante.getDireccion(); // Crear el texto para mostrar
                cbRestaurante.addItem(displayText); // Agregar solo el texto
            }

            // Agregar un ActionListener para detectar la selección de un restaurante
            cbRestaurante.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedIndex = cbRestaurante.getSelectedIndex(); // Obtener el índice seleccionado

                    // Asegúrate de que no se haya seleccionado la opción de "Seleccionar restaurante"
                    if (selectedIndex > 0) { // Si hay un restaurante seleccionado
                        RestauranteDTO restauranteSeleccionado = listaRestaurantes.get(selectedIndex - 1); // Obtener el objeto correspondiente
                        idRestauranteSeleccionado = restauranteSeleccionado.getId(); // Obtener el ID del restaurante seleccionado
                        System.out.println("ID del restaurante seleccionado: " + idRestauranteSeleccionado);
                        cargarDia();
                        cargarMesasEnTabla();
                    } else {
                        // Restablecer el ID si se selecciona "Seleccionar restaurante"
                        idRestauranteSeleccionado = null; // O puedes usar un valor predeterminado
                    }
                }
            });

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, "Error al mostrar los restaurantes", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarDia() {
        List<HorarioDTO> horarios = horariobo.obtenerDiasAsignadosParaRestaurante(idRestauranteSeleccionado);

// Limpiar el JComboBox antes de llenarlo
        cbDia.removeAllItems();

// Llenar el JComboBox con los días asignados
        for (HorarioDTO horario : horarios) {
            cbDia.addItem(horario.getDiaSemana());
        }
    }

    private void cargarMesasEnTabla() {
        try {
            String ubicacionSeleccionada = cbUbicacion.getSelectedItem().toString();

            List<MesaDTO> mesas = mesaBO.obtenerTodasLasMesas();

            List<HorarioDTO> horariosRestaurante = horariobo.obtenerDiasAsignadosParaRestaurante(idRestauranteSeleccionado);
            
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

            // Crear un modelo de tabla
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Mesa");
            modelo.addColumn("Dia semana");
            modelo.addColumn("Ubicación");
            modelo.addColumn("Capacidad");
            modelo.addColumn("Horario apertura");
            modelo.addColumn("Horario cierre");

            // Llenar el modelo con los datos de las mesas filtradas
            for (MesaDTO mesa : mesas) {
                boolean coincideRestaurante = mesa.getIdRestaurante().equals(idRestauranteSeleccionado);

                // Si coincide la ubicación, capacidad y restaurante, se agrega a la tabla
                if (coincideRestaurante) {

                    // Iterar sobre los horarios asignados al restaurante y crear una fila para cada día
                    for (HorarioDTO horario : horariosRestaurante) {
                        Object[] fila = new Object[6];

                        fila[0] = mesa.getCodigoMesa();
                        fila[1] = horario.getDiaSemana();
                        fila[2] = mesa.getUbicacion();
                        fila[3] = mesa.getCapacidad();
                        fila[4] = sdf.format(horario.getHoraApertura());
                        fila[5] = sdf.format(horario.getHoraCierre());

                        modelo.addRow(fila);
                    }
                }
            }

            // Crear la JTable con el modelo
            tblMesas = new JTable(modelo);
            tblMesas.setFillsViewportHeight(true);

            // Agregar un listener para la selección de filas
            tblMesas.getSelectionModel().addListSelectionListener(event -> {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = tblMesas.getSelectedRow();
                    if (selectedRow != -1) {
                        Long idMesa = (Long) tblMesas.getValueAt(selectedRow, 0);
                        guardarIdMesaSeleccionada(idMesa);
                    }
                }
            });

            // Agregar la JTable al JScrollPane
            jScrollPane1.setViewportView(tblMesas);
        } catch (NegocioException ex) {
            Logger.getLogger(FormMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void guardarIdMesaSeleccionada(Long idMesa) {
        this.idMesaSeleccionada = idMesa;
    }

}
