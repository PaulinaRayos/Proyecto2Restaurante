/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import conexion.Conexion;
import conexion.IConexion;
import dao.ReservaDAO;
import dto.ClienteDTO;
import dto.FiltrosReportesDTO;
import dto.MesaDTO;
import dto.ReporteDTO;
import dto.ReservaDTO;
import dto.TipoMesaDTO;
import entidadesJPA.Reserva;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IClienteBO;
import interfaces.IMesaBO;
import interfaces.IReporteBO;
import interfaces.IReservaDAO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.List;
import recursos.FiltrosReportes;

/**
 * Clase que implementa la lógica de negocio para la generación de reportes.
 * Proporciona métodos para crear reportes basados en reservas y otros datos
 * relevantes.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class ReporteBO implements IReporteBO {

    private final IConexion conexion;
    private final IReservaDAO reservasdao;
    private final IClienteBO clientedao;
    private final IMesaBO mesadao;

    /**
     * Constructor que inicializa las dependencias necesarias para la generación
     * de reportes. Se establece la conexión a la base de datos y se inicializan
     * los DAOs requeridos.
     */
    public ReporteBO() {
        this.conexion = new Conexion();
        this.reservasdao = new ReservaDAO(conexion);
        this.clientedao = new ClienteBO();
        this.mesadao = new MesaBO();
    }

    /**
     * Obtiene una lista de reservas que coinciden con los filtros especificados
     * en el objeto FiltrosReportesDTO.
     *
     * @param filtro El objeto FiltrosReportesDTO que contiene los filtros para
     * la búsqueda de trámites.
     * @return Una lista de ReporteDTO que representa las reservas encontradas
     * que coinciden con los filtros especificados. Si no se encuentran trámites
     * que coincidan con los filtros, se devuelve una lista vacía.
     */
    @Override
    public List<ReporteDTO> obtenerReservasReporte(FiltrosReportesDTO filtro) {

        List<ReporteDTO> listaReportes = new ArrayList<>();

        FiltrosReportes filtrosReporte = new FiltrosReportes();
        filtrosReporte.setFechaInicio(filtro.getFechaFin());
        filtrosReporte.setFechaFin(filtro.getFechaFin());
        filtrosReporte.setTipoMesa(filtro.getTipoMesa());
        filtrosReporte.setUbicacion(filtro.getUbicacion());

        try {
            // Obtener los trámites de acuerdo a los filtros proporcionados
            List<Reserva> reservasEncontrados = reservasdao.obtenerTodasLasReservas();

            // Convertir los trámites encontrados a TramiteDTO
            for (Reserva reserva : reservasEncontrados) {

                Date fechaHora = reserva.getFechaHora();

                String cliente = reserva.getCliente().getNombre() + " " + reserva.getCliente().getApellidoPaterno() + " " + reserva.getCliente().getApellidoMaterno();

                String codigoMesa = reserva.getMesa().getCodigoMesa();

                String tipoMesa = reserva.getMesa().getTipoMesa().getNombreTipo();

                String ubicacion = reserva.getMesa().getUbicacion();

                BigDecimal precio = reserva.getCosto();

                String costoFormato = "$" + String.format("%.2f", precio) + " MXN";

                BigDecimal multa = reserva.getMulta();

                String multaFormato = "$" + String.format("%.2f", multa) + " MXN";

                ReporteDTO reporteDTO = new ReporteDTO(fechaHora, cliente, codigoMesa, tipoMesa, ubicacion, costoFormato, multaFormato);

                listaReportes.add(reporteDTO);
            }

            return listaReportes;
        } catch (PersistenciaException ex) {
            // Manejar la excepción en caso de error
            Logger.getLogger(ReporteBO.class.getName()).log(Level.SEVERE, "No fue posible obtener los trámites con los filtros especificados");
            return Collections.emptyList();
        }
    }

    /* 
     * Genera un reporte en formato PDF a partir de una lista de ReporteDTO.
     * Permite al administrador seleccionar la ubicación y el nombre del archivo PDF.
     *
     * @param listaReservas Lista de reservas para generar el reporte.
     * @return ReporteDTO Objeto que representa el reporte generado.
     * @throws NegocioException Si ocurre un error durante la generación
     *                          del reporte.
     */
    @Override
    public void generarReporte(List<ReporteDTO> listaReservas) throws NegocioException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar Reporte");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF", "pdf"));
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            java.io.File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();

            if (!filePath.endsWith(".pdf")) {
                filePath += ".pdf";
            }

            try (PdfWriter writer = new PdfWriter(filePath); PdfDocument pdfDoc = new PdfDocument(writer); Document document = new Document(pdfDoc)) {

                // Agregar título
                document.add(new Paragraph("Reporte de Reservas Amadeusraurant").setBold().setFontSize(18));

                // Crear tabla con encabezados
                Table table = new Table(new float[]{4, 4, 4, 4, 4, 4}); // Definir número y ancho de columnas
                table.addHeaderCell(new Cell().add(new Paragraph("Fecha Reserva")));
                table.addHeaderCell(new Cell().add(new Paragraph("Nombre Cliente")));
                table.addHeaderCell(new Cell().add(new Paragraph("Tipo Mesa")));
                table.addHeaderCell(new Cell().add(new Paragraph("Ubicacion")));
                table.addHeaderCell(new Cell().add(new Paragraph("Costo")));
                table.addHeaderCell(new Cell().add(new Paragraph("Multa")));

                // Llenar la tabla con datos
                for (ReporteDTO reserva : listaReservas) {
                    table.addCell(new Cell().add(new Paragraph(reserva.getFechaHora().toString())));
                    table.addCell(new Cell().add(new Paragraph(reserva.getCliente())));
                    table.addCell(new Cell().add(new Paragraph(reserva.getTipoMesa())));
                    table.addCell(new Cell().add(new Paragraph(reserva.getUbicacion())));
                    table.addCell(new Cell().add(new Paragraph(reserva.getCosto())));
                    String multa = (reserva.getMulta() != null) ? reserva.getMulta() : "0";
                    table.addCell(new Cell().add(new Paragraph(multa)));
                }

                // Agregar tabla al documento
                document.add(table);

                // Mensaje de éxito
                JOptionPane.showMessageDialog(null, "Archivo guardado", "Info", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al generar el reporte PDF: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (userSelection == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Usuario canceló la operación", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Convierte una lista de reservas en una lista de reportes. Cada elemento
     * de la lista de reservas se transforma en un objeto ReporteDTO.
     *
     * @param listaReservas La lista de reservas que se va a convertir en
     * reportes.
     * @return Una lista de ReporteDTO que representa los reportes generados a
     * partir de las reservas.
     */
    @Override
    public List<ReporteDTO> convertirReservasAReportes(List<ReservaDTO> listaReservas) {
        List<ReporteDTO> listaReportes = new ArrayList<>();

        for (ReservaDTO reserva : listaReservas) {
            try {
                ClienteDTO cliente = clientedao.obtenerClientePorId(reserva.getIdCliente());
                MesaDTO mesa = mesadao.obtenerMesaPorId(reserva.getIdMesa());
                TipoMesaDTO tipoMesaa = mesadao.obtenerTipoMesaaPorId(mesa.getIdTipoMesa());

                Date fechaHora = reserva.getFechaHora();

                String nombreCliente = cliente.getNombre() + " " + cliente.getApellidoPaterno() + " " + cliente.getApellidoMaterno();

                String codigoMesa = mesa.getCodigoMesa();

                String tipoMesa = tipoMesaa.getNombreTipo();

                String ubicacion = mesa.getUbicacion();

                BigDecimal precio = reserva.getCosto();

                String costoFormato = "$" + String.format("%.2f", precio) + " MXN";

                BigDecimal multa = reserva.getMulta();

                String multaFormato = "$" + String.format("%.2f", multa) + " MXN";

                ReporteDTO reporteDTO = new ReporteDTO(fechaHora, nombreCliente, codigoMesa, tipoMesa, ubicacion, costoFormato, multaFormato);

                listaReportes.add(reporteDTO);
            } catch (NegocioException ex) {
                Logger.getLogger(ReporteBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return listaReportes;
    }

}
