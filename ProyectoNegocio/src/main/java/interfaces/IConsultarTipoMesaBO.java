/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.NegocioException;

/**
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public interface IConsultarTipoMesaBO {

    /**
     * Método para obtener el nombre del tipo de mesa asociado a una mesa dada
     * su ID.
     *
     * @param idMesa El ID de la mesa para la que se desea obtener el nombre del
     * tipo de mesa.
     * @return El nombre del tipo de mesa si se encuentra, o null si no se
     * encuentra la mesa o el tipo de mesa.
     * @throws NegocioException Si ocurre un error en la capa de persistencia.
     */
    String obtenerNombreTipoMesaPorIdMesa(Long idMesa) throws NegocioException;

}
