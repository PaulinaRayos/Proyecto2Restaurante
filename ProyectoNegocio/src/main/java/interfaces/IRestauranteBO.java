/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.RestauranteDTO;
import excepciones.NegocioException;
import java.util.Date;
import java.util.List;

/**
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public interface IRestauranteBO {

    /**
     * Obtiene un restaurante por su ID.
     *
     * @param idRestaurante el ID del restaurante que se desea obtener
     * @return RestauranteDTO que representa el restaurante encontrado
     * @throws NegocioException si ocurre un error en la lógica de negocio
     */
    RestauranteDTO obtenerRestaurantePorId(Long idRestaurante) throws NegocioException;

    /**
     * Guarda un nuevo restaurante.
     *
     * @param restauranteDTO el objeto RestauranteDTO que contiene los datos del
     * restaurante a guardar
     * @throws NegocioException si ocurre un error en la lógica de negocio
     */
    void guardarRestaurante(RestauranteDTO restauranteDTO) throws NegocioException;

    /**
     * Obtiene una lista de ciudades y direcciones de restaurantes.
     *
     * @return una lista de cadenas con las ciudades y direcciones
     * @throws NegocioException si ocurre un error en la lógica de negocio
     */
    List<String> obtenerCiudadesYDirecciones() throws NegocioException;

    /**
     * Obtiene todos los restaurantes.
     *
     * @return una lista de objetos RestauranteDTO que representan todos los
     * restaurantes
     * @throws NegocioException si ocurre un error en la lógica de negocio
     */
    List<RestauranteDTO> obtenerRestaurantes() throws NegocioException;

    /**
     * Obtiene la hora de cierre del restaurante.
     *
     * @param idRestaurante el id del restaurante al que le pertenece el horario
     * cierre
     * @param diaSemana el dia de la semana
     * @return la hora de cirre.
     * @throws NegocioException
     */
    Date obtenerHoraCierre(Long idRestaurante, String diaSemana) throws NegocioException;

    /**
     * Obtiene la hora de apaertura del restaurante.
     *
     * @param idRestaurante el id del restaurante al que le pertenece el horario
     * apertura
     * @param diaSemana el dia de la semana
     * @return la hora de apertura.
     * @throws NegocioException
     */
    Date obtenerHoraApertura(Long idRestaurante, String diaSemana) throws NegocioException;

}
