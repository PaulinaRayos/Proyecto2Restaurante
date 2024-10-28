/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.FiltrosReportesDTO;
import dto.ReporteDTO;
import dto.ReservaDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Chris
 */
public interface IReporteBO {

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
    List<ReporteDTO> obtenerReservasReporte(FiltrosReportesDTO filtro);

    /* 
     * Genera un reporte en formato PDF a partir de una lista de ReporteDTO.
     * Permite al administrador seleccionar la ubicación y el nombre del archivo PDF.
     *
     * @param listaReservas La lista de ReporteDTO que se utilizará para generar
     * el reporte.
     */
    void generarReporte(List<ReporteDTO> listaReservas) throws NegocioException;

    /**
     * Convierte una lista de reservas en una lista de reportes. Cada elemento
     * de la lista de reservas se transforma en un objeto ReporteDTO.
     *
     * @param listaReservas La lista de reservas que se va a convertir en
     * reportes.
     * @return Una lista de ReporteDTO que representa los reportes generados a
     * partir de las reservas.
     */
    public List<ReporteDTO> convertirReservasAReportes(List<ReservaDTO> listaReservas);
}
