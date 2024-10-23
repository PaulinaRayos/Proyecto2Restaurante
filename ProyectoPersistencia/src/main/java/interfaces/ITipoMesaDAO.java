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
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public interface ITipoMesaDAO {

    // Método para actualizar un tipo de mesa
    void actualizarTipoMesa(TipoMesa tipoMesa) throws PersistenciaException;

    // Método para agregar un tipo de mesa
    void agregarTipoMesa(TipoMesa tipoMesa) throws PersistenciaException;

    // Método para cerrar el EntityManager y EntityManagerFactory
    void cerrar() throws PersistenciaException;

    // Método para eliminar un tipo de mesa por ID
    void eliminarTipoMesa(Long id) throws PersistenciaException;

    // Método para obtener un tipo de mesa por ID
    TipoMesa obtenerTipoMesaPorId(Long id) throws PersistenciaException;

    // Método para obtener todos los tipos de mesa
    List<TipoMesa> obtenerTodosLosTiposMesa() throws PersistenciaException;
    
    void insertarTiposMesaPredeterminados() throws PersistenciaException;
    
    public List<TipoMesa> obtenerTodosLosTipos() throws PersistenciaException;
    
    TipoMesa obtenerTipoMesaPorNombre(String nombreTipo) throws PersistenciaException;

}
