/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidadesJPA.Restaurante;
import excepciones.PersistenciaException;
import java.util.Date;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad
 * Restaurante. Proporciona métodos para realizar operaciones de creación,
 * lectura, actualización y eliminación (CRUD) de restaurantes en la base de
 * datos. Contribuciones de Paulina Rodríguez Rodríguez Rayos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 */
public interface IRestauranteDAO {

    /**
     * Busca las ciudades y direcciones de todos los restaurantes en la base de
     * datos.
     *
     * @return Una lista de arreglos de objetos, donde cada arreglo contiene la
     * ciudad y la dirección de un restaurante.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    List<Object[]> buscarCiudadesYDireccionesRestaurantes() throws PersistenciaException;

    /**
     * Guarda un nuevo restaurante en la base de datos o actualiza uno
     * existente.
     *
     * @param restaurante El restaurante a guardar.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    void guardarRestaurante(Restaurante restaurante) throws PersistenciaException;

    /**
     * Obtiene un restaurante de la base de datos por su ID.
     *
     * @param idRestaurante El ID del restaurante a buscar.
     * @return El restaurante correspondiente al ID proporcionado.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    Restaurante obtenerPorId(Long idRestaurante) throws PersistenciaException;

    /**
     * Obtiene todos los restaurantes de la base de datos.
     *
     * @return Una lista de todos los restaurantes.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    List<Restaurante> obtenerTodosLosRestaurantes() throws PersistenciaException;

    /**
     * Obtiene la hora de apaertura del restaurante.
     *
     * @param idRestaurante el id del restaurante al que le pertenece el horario
     * apertura
     * @param diaSemana el dia de la semana
     * @return la hora de apertura.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    Date obtenerHoraApertura(Long idRestaurante, String diaSemana) throws PersistenciaException;

    /**
     * Obtiene la hora de cierre del restaurante.
     *
     * @param idRestaurante el id del restaurante al que le pertenece el horario
     * cierre
     * @param diaSemana el dia de la semana
     * @return la hora de cirre.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    Date obtenerHoraCierre(Long idRestaurante, String diaSemana) throws PersistenciaException;

}
