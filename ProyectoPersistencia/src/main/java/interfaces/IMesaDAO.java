/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidadesJPA.Mesa;
import excepciones.PersistenciaException;
import java.math.BigDecimal;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Mesa.
 * Proporciona métodos para realizar operaciones de creación, lectura,
 * actualización y eliminación (CRUD) de mesas en la base de datos.
 * Contribuciones de Paulina Rodríguez Rodríguez Rayos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 */
public interface IMesaDAO {

    /**
     * Agrega una nueva mesa a la base de datos.
     *
     * @param mesa La mesa a agregar.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    long agregarMesa(Mesa mesa) throws PersistenciaException;

    /**
     * Elimina una mesa de la base de datos por su ID.
     *
     * @param id El ID de la mesa a eliminar.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    void eliminarMesa(Long id) throws PersistenciaException;

    /**
     * Inserta una lista de mesas en la base de datos de manera masiva.
     *
     * @param mesas La lista de mesas a insertar.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    void insertarMesas(List<Mesa> mesas) throws PersistenciaException;

    /**
     * Obtiene la cantidad total de mesas en la base de datos.
     *
     * @return La cantidad total de mesas.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    long obtenerCantidadDeMesas() throws PersistenciaException;

    /**
     * Obtiene el costo de reserva de una mesa por su ID.
     *
     * @param idMesa El ID de la mesa.
     * @return El costo de reserva de la mesa, o null si no se encontró.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    BigDecimal obtenerCostoPorIdMesa(Long idMesa) throws PersistenciaException;

    /**
     * Obtiene una mesa por su ID.
     *
     * @param id El ID de la mesa a buscar.
     * @return La mesa correspondiente al ID proporcionado.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    Mesa obtenerMesaPorId(Long id) throws PersistenciaException;

    /**
     * Obtiene todas las mesas de la base de datos.
     *
     * @return Una lista de todas las mesas.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    List<Mesa> obtenerTodasLasMesas() throws PersistenciaException;

    /**
     * Obtiene el ID del restaurante asociado a una mesa específica.
     *
     * @param idMesa el ID de la mesa para la cual se desea obtener el ID del
     * restaurante
     * @return el ID del restaurante asociado a la mesa
     * @throws PersistenciaException si ocurre un error al obtener el ID del
     * restaurante
     */
    Long obtenerIdRestaurantePorIdMesa(Long idMesa) throws PersistenciaException;

}
