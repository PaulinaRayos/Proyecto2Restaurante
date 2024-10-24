/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.RestauranteDTO;
import excepciones.NegocioException;

/**
 *
 * @author Chris
 */
public interface IActualizaHorarioRestauranteBO {
    
    void guardarOActualizarRestaurante(RestauranteDTO restauranteDTO) throws NegocioException;
    
}
