/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.RestauranteDTO;
import excepciones.NegocioException;
import java.util.Map;

/**
 * Interfaz que define los métodos para agregar mesas a un restaurante.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public interface IAgregaMesasBO {

    /**
     * Agrega mesas al restaurante especificado en el objeto RestauranteDTO.
     * Valida que el restaurante exista y que el ID no sea nulo. Para cada tipo
     * de mesa y la cantidad solicitada, se generan las mesas y se persisten en
     * la base de datos.
     *
     * @param restauranteDTO Objeto que contiene la información del restaurante
     * al que se agregarán las mesas.
     * @param cantidadPorTipo Mapa que asocia nombres de tipos de mesa con la
     * cantidad solicitada para cada tipo.
     * @param ubicacion Cadena que indica la ubicación de las mesas (ej.
     * "Terraza").
     * @throws NegocioException Si ocurre un error al agregar mesas o si el
     * restaurante no se encuentra.
     */
    void agregarMesas(RestauranteDTO restauranteDTO, Map<String, Integer> cantidadPorTipo, String ubicacion) throws NegocioException;
}
