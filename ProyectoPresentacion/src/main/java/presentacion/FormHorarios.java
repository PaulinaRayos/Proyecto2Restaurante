/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dto.HorarioDTO;
import dto.RestauranteDTO;
import excepciones.NegocioException;
import interfaces.IActualizaHorarioBO;
import interfaces.IRestauranteBO;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import negocio.ActualizaHorarioBO;
import negocio.RestauranteBO;
import utilidades.Forms;

/**
 *
 * @author Chris
 */
public class FormHorarios extends javax.swing.JFrame {

    private final IRestauranteBO restbo;
    private final HorarioDTO horario;
    private final IActualizaHorarioBO acthorarioBO;
    private Long idRestauranteSeleccionado;
    private List<RestauranteDTO> listaRestaurantes;

    /**
     * Creates new form FormHorarios
     */
    public FormHorarios() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.restbo = new RestauranteBO();
        this.horario = new HorarioDTO();
        this.acthorarioBO = new ActualizaHorarioBO();
        this.SetImageLabel(jLabel3, "src/main/java/Imagenes/logo.png");
        this.cargarRestaurantes();
        this.cargarDiasDeLaSemana();
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
        jPanel5 = new javax.swing.JPanel();
        Date date = new Date();
        SpinnerDateModel sm =
        new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        jHoraApertura = new javax.swing.JSpinner(sm);
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Date date1 = new Date();
        SpinnerDateModel sm1 =
        new SpinnerDateModel(date1, null, null, Calendar.HOUR_OF_DAY);
        jHoraCierre = new javax.swing.JSpinner(sm1);
        jLabel10 = new javax.swing.JLabel();
        jLabelaa = new javax.swing.JLabel();
        bConfirmar = new javax.swing.JButton();
        cbRestaurante = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbDia = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        JSpinner.DateEditor de = new JSpinner.DateEditor(jHoraApertura, "HH:mm");
        jHoraApertura.setEditor(de);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel7.setText("Dia de la semana:");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel8.setText("Hora apertura:");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JSpinner.DateEditor de1 = new JSpinner.DateEditor(jHoraCierre, "HH:mm");
        jHoraCierre.setEditor(de1);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel10.setText("Hora cierre:");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelaa.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabelaa.setText("Horario de Mesas");
        jLabelaa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bConfirmar.setBackground(new java.awt.Color(255, 51, 153));
        bConfirmar.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        bConfirmar.setText("Confirmar");
        bConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConfirmarActionPerformed(evt);
            }
        });

        cbRestaurante.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        cbRestaurante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona restaurante" }));
        cbRestaurante.setBorder(null);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel9.setText("Restaurante:");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbDia.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        cbDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar el día", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo", " " }));
        cbDia.setBorder(null);
        cbDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelaa)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel9))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(cbDia, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(jLabel7))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel8)
                        .addGap(167, 167, 167)
                        .addComponent(jLabel10))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jHoraApertura, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(jHoraCierre, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(bConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(cbRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabelaa)
                .addGap(47, 47, 47)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(cbRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jHoraApertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHoraCierre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(bConfirmar)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void bConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConfirmarActionPerformed
        try {

            // Obtener las horas de apertura y cierre desde los spinners
            LocalTime horaApertura = obtenerHoraDesdeSpinner(jHoraApertura);
            LocalTime horaCierre = obtenerHoraDesdeSpinner(jHoraCierre);

            // Obtener el día de la semana seleccionado
            String diaSemana = (String) cbDia.getSelectedItem();

            // Validar que el día de la semana no sea nulo
            if (diaSemana == null || diaSemana.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un día de la semana.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return; // Salir del método si no hay un día válido
            }

            // Establecer los valores en el objeto horario
            horario.setDiaSemana(diaSemana);
            horario.setIdRestaurante(idRestauranteSeleccionado);

            // Convertir LocalTime a Date
            LocalDate fechaActual = LocalDate.now();
            Date aperturaDate = convertirLocalTimeADate(horaApertura, fechaActual);
            Date cierreDate = convertirLocalTimeADate(horaCierre, fechaActual);

            horario.setHoraApertura(aperturaDate);
            horario.setHoraCierre(cierreDate);

            // Llamar a la capa de negocio para guardar o actualizar el horario
            acthorarioBO.guardarHorario(horario); // Cambia este método según tu implementación en el BO

            // Mensaje de éxito
            JOptionPane.showMessageDialog(this, "Horario actualizado exitosamente para " + " en " + cbDia.getSelectedItem().toString() + ".");

            // Opcional: Limpiar el formulario o realizar otras acciones
            //limpiarFormulario(); // Llama a un método para limpiar los campos si es necesario
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_bConfirmarActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        Forms.cargarForm(new FormMenu(), this);

    }//GEN-LAST:event_jLabel3MouseClicked

    private void cbDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDiaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bConfirmar;
    private javax.swing.JComboBox<String> cbDia;
    private javax.swing.JComboBox<String> cbRestaurante;
    private javax.swing.JSpinner jHoraApertura;
    private javax.swing.JSpinner jHoraCierre;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelaa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
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

    public Date combinarFechaYHora(Date fecha, LocalTime hora) {
        LocalDate localDate = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Crear LocalDateTime combinando la fecha con la hora
        LocalDateTime fechaConHora = LocalDateTime.of(localDate, hora);

        // Convertir LocalDateTime de vuelta a java.util.Date
        return Date.from(fechaConHora.atZone(ZoneId.systemDefault()).toInstant());
    }

    private Date convertirLocalTimeADate(LocalTime localTime, LocalDate fecha) {
        return Date.from(LocalDateTime.of(fecha, localTime).atZone(java.time.ZoneId.systemDefault()).toInstant());
    }

    private void cargarRestaurantes() {
        try {
            cbRestaurante.removeAllItems(); // Limpiar elementos actuales
            listaRestaurantes = restbo.obtenerRestaurantes(); // Obtener la lista de restaurantes

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

    private void cargarDiasDeLaSemana() {
        String[] dias = {"Seleccionar día", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        for (String dia : dias) {
            cbDia.addItem(dia);
        }
    }

}
