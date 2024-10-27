/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidadesJPA.TipoMesa;
import excepciones.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad
 * TipoMesa. Proporciona métodos para realizar operaciones de creación, lectura,
 * actualización y eliminación (CRUD) de tipos de mesa en la base de datos.
 * Contribuciones de Paulina Rodríguez Rodríguez Rayos.
 * 
 * @author Cristopher Alberto Elizalde Andrade - 240005
 */
public interface ITipoMesaDAO {

    /**
     * Actualiza un tipo de mesa en la base de datos.
     *
     * @param tipoMesa El tipo de mesa a actualizar.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    void actualizarTipoMesa(TipoMesa tipoMesa) throws PersistenciaException;

    /**
     * Agrega un nuevo tipo de mesa en la base de datos.
     *
     * @param tipoMesa El tipo de mesa a agregar.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    void agregarTipoMesa(TipoMesa tipoMesa) throws PersistenciaException;

    /**
     * Cierra el EntityManager si está abierto.
     */
    void cerrar();

    /**
     * Elimina un tipo de mesa de la base de datos por su ID.
     *
     * @param id El ID del tipo de mesa a eliminar.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    void eliminarTipoMesa(Long id) throws PersistenciaException;

    /**
     * Inserta tipos de mesa predeterminados en la base de datos si no existen.
     *
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    void insertarTiposMesaPredeterminados() throws PersistenciaException;

    /**
     * Obtiene un tipo de mesa a partir de su nombre.
     *
     * @param nombreTipo El nombre del tipo de mesa a buscar.
     * @return El tipo de mesa correspondiente al nombre proporcionado.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    TipoMesa obtenerPorNombre(String nombreTipo) throws PersistenciaException;

    /**
     * Obtiene un tipo de mesa de la base de datos por su ID.
     *
     * @param id El ID del tipo de mesa a buscar.
     * @return El tipo de mesa correspondiente al ID proporcionado.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    TipoMesa obtenerTipoMesaPorId(Long id) throws PersistenciaException;

    /**
     * Obtiene un tipo de mesa a partir de su nombre.
     *
     * @param nombreTipo El nombre del tipo de mesa a buscar.
     * @return El tipo de mesa correspondiente al nombre proporcionado.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    TipoMesa obtenerTipoMesaPorNombre(String nombreTipo) throws PersistenciaException;

    /**
     * Obtiene todos los tipos de mesa en la base de datos.
     *
     * @return Una lista de todos los tipos de mesa.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    List<TipoMesa> obtenerTodosLosTipos() throws PersistenciaException;

    /**
     * Obtiene todos los tipos de mesa de la base de datos.
     *
     * @return Una lista de todos los tipos de mesa.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    List<TipoMesa> obtenerTodosLosTiposMesa() throws PersistenciaException;

    

}
