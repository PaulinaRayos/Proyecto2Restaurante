/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.MesaDTO;
import dto.TipoMesaDTO;
import entidadesJPA.TipoMesa;
import excepciones.NegocioException;
import java.math.BigDecimal;
import java.util.List;

/**
 * Interfaz que define los métodos para la lógica de negocio relacionada con
 * mesas.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public interface IMesaBO {

    /**
     * Obtiene una lista de todas las mesas registradas.
     *
     * @return Una lista de objetos MesaDTO que representan todas las mesas.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    List<MesaDTO> obtenerTodasLasMesas() throws NegocioException;

    /**
     * Obtiene el costo de reserva para una mesa específica.
     *
     * @param idMesa El ID de la mesa para la cual se desea obtener el costo de
     * reserva.
     * @return Un BigDecimal que representa el costo de reserva de la mesa.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    BigDecimal obtenerCostoPorIdMesa(Long idMesa) throws NegocioException;

    /**
     * Inicializa los tipos de mesa predeterminados en la base de datos.
     *
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    void inicializarTiposMesaPredeterminados() throws NegocioException;

    /**
     * Obtiene una lista de tipos de mesa en formato DTO.
     *
     * @return Una lista de objetos TipoMesaDTO que representan los tipos de
     * mesa.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    List<TipoMesaDTO> obtenerTiposMesa() throws NegocioException;

    /**
     * Obtiene los detalles de una mesa específica por su ID.
     *
     * @param idMesa El ID de la mesa que se desea obtener.
     * @return Un objeto MesaDTO que representa la mesa correspondiente al ID
     * proporcionado.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    MesaDTO obtenerMesaPorId(Long idMesa) throws NegocioException;

    /**
     * Obtiene el ID del restaurante al que pertenece una mesa específica.
     *
     * @param idMesa El ID de la mesa para la cual se desea obtener el ID del
     * restaurante.
     * @return El ID del restaurante correspondiente a la mesa.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    Long obtenerIdRestaurantePorIdMesa(Long idMesa) throws NegocioException;

    /**
     * Obtiene un tipo de mesa por su ID.
     *
     * @param id El ID del tipo de mesa a buscar.
     * @return El objeto TipoMesa correspondiente al ID proporcionado.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    TipoMesa obtenerTipoMesaPorId(Long id) throws NegocioException;

    /**
     * Obtiene un tipo de mesa en formato DTO por su ID.
     *
     * @param id El ID del tipo de mesa a buscar.
     * @return Un objeto TipoMesaDTO correspondiente al ID proporcionado.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    TipoMesaDTO obtenerTipoMesaaPorId(Long id) throws NegocioException;
}
