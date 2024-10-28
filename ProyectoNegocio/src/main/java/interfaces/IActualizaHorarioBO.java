/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.HorarioDTO;
import excepciones.NegocioException;

/**
 * Interfaz que define los métodos para la lógica de negocio relacionada con la
 * actualización de horarios de restaurantes. Proporciona una abstracción para
 * las operaciones de guardar y actualizar horarios en la base de datos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public interface IActualizaHorarioBO {

    /**
     * Método para guardar un horario en la base de datos. Si ya existe un
     * horario para el día de la semana específico, se actualiza. Si no existe,
     * se crea un nuevo horario.
     *
     * @param horarioDTO Objeto que contiene la información del horario a
     * guardar.
     * @throws NegocioException Si ocurre un error al guardar o actualizar el
     * horario.
     */
    void guardarHorario(HorarioDTO horarioDTO) throws NegocioException;

}
