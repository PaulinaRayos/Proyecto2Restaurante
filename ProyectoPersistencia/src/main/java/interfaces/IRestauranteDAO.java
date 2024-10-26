/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidadesJPA.Restaurante;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Chris
 */
public interface IRestauranteDAO {

    void guardarRestaurante(Restaurante restaurante) throws PersistenciaException;

    Restaurante obtenerPorId(Long idRestaurante) throws PersistenciaException;

    List<Object[]> buscarCiudadesYDireccionesRestaurantes() throws PersistenciaException;
}
