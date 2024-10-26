/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.RestauranteDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Chris
 */
public interface IRestauranteBO {

    RestauranteDTO obtenerRestaurantePorId(Long idRestaurante) throws NegocioException;

    void guardarRestaurante(RestauranteDTO restauranteDTO) throws NegocioException;

    List<String> obtenerCiudadesYDirecciones() throws NegocioException;

}
