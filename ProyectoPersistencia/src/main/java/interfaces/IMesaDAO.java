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
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public interface IMesaDAO {

    // Método para actualizar una mesa
    void actualizarMesa(Mesa mesa) throws PersistenciaException;

    // Método para agregar una mesa
    void agregarMesa(Mesa mesa) throws PersistenciaException;
    
    void insertarMesas(List<Mesa> mesas) throws PersistenciaException;

    // Método para cerrar el EntityManager y EntityManagerFactory
    void cerrar() throws PersistenciaException;

    // Método para eliminar una mesa por ID
    void eliminarMesa(Long id) throws PersistenciaException;

    // Método para obtener una mesa por ID
    Mesa obtenerMesaPorId(Long id) throws PersistenciaException;

    // Método para obtener todas las mesas
    List<Mesa> obtenerTodasLasMesas() throws PersistenciaException;
    
    BigDecimal obtenerCostoPorIdMesa(Long idMesa) throws PersistenciaException;

}
