/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.MesaDTO;
import dto.RestauranteDTO;
import excepciones.NegocioException;
import java.util.Map;

/**
 *
 * @author Chris
 */
public interface IAgregaMesasBO {

    void agregarMesas(RestauranteDTO restauranteDTO, Map<String, Integer> cantidadPorTipo, String ubicacion) throws NegocioException;
}
