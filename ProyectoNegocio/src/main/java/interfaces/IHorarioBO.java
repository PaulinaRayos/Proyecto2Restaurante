/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.HorarioDTO;
import entidadesJPA.Horario;
import excepciones.NegocioException;
import java.util.List;

/**
 * Interfaz que define los métodos para la lógica de negocio relacionada con los
 * horarios de los restaurantes.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public interface IHorarioBO {

    /**
     * Método para obtener el horario de un restaurante dado su ID. Devuelve un
     * objeto HorarioDTO que representa el horario del restaurante.
     *
     * @param idRestaurante El ID del restaurante para el cual se desea obtener
     * el horario.
     * @return Un objeto HorarioDTO que contiene la información del horario, o
     * null si el restaurante no tiene horario o si el ID es nulo.
     * @throws NegocioException Si ocurre un error en la capa de persistencia.
     */
    HorarioDTO obtenerHorarioPorId(Long idRestaurante) throws NegocioException;

    /**
     * Método para obtener una lista de días asignados a un restaurante en
     * función de su ID. Convierte cada entidad Horario en un objeto HorarioDTO.
     *
     * @param restauranteId El ID del restaurante para el cual se desean obtener
     * los días asignados.
     * @return Una lista de objetos HorarioDTO que representan los horarios
     * asignados al restaurante.
     */
    List<HorarioDTO> obtenerDiasAsignadosParaRestaurante(Long restauranteId);

    /**
     * Método para obtener una lista de IDs de horarios asociados a un
     * restaurante. Llama al DAO correspondiente y retorna la lista de IDs.
     *
     * @param idRestaurante El ID del restaurante para el cual se desean obtener
     * los IDs de horarios.
     * @return Una lista de Long que contiene los IDs de los horarios del
     * restaurante.
     * @throws NegocioException Si ocurre un error en la capa de persistencia.
     */
    List<Long> obtenerIdsHorariosPorIdRestaurante(Long idRestaurante) throws NegocioException;

    /**
     * Método para obtener un horario específico a partir de su ID. Si no se
     * encuentra el horario, retorna null.
     *
     * @param idHorario El ID del horario que se desea obtener.
     * @return Un objeto Horario que representa el horario correspondiente al
     * ID, o null si no se encuentra.
     * @throws NegocioException Si ocurre un error en la capa de persistencia.
     */
    Horario obtenerHorarioPorIdHorario(Long idHorario) throws NegocioException;
}
