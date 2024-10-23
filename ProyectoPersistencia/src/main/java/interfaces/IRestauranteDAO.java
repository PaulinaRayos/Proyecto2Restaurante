/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidadesJPA.Restaurante;
import excepciones.PersistenciaException;

/**
 *
 * @author Chris
 */
public interface IRestauranteDAO {

    Restaurante obtenerPorId(Long idRestaurante) throws PersistenciaException;
}
