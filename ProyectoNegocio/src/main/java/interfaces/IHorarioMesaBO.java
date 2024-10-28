/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidadesJPA.HorarioMesa;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define los métodos para la lógica de negocio relacionada con los
 * horarios de las mesas.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public interface IHorarioMesaBO {

    /**
     * Obtiene una lista de horarios asignados a una mesa específica.
     *
     * @param idMesa El ID de la mesa para la cual se desean obtener los
     * horarios.
     * @return Una lista de objetos HorarioMesa que representan los horarios de
     * la mesa.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    List<HorarioMesa> obtenerHorariosPorMesa(Long idMesa) throws PersistenciaException;

    /**
     * Crea un nuevo horario para una mesa.
     *
     * @param horarioMesa El objeto HorarioMesa que representa el horario a
     * crear.
     * @throws NegocioException Si ocurre un error durante la operación de
     * negocio.
     */
    void crearHorarioMesa(HorarioMesa horarioMesa) throws NegocioException;

}
