/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidadesJPA.Cliente;
import excepciones.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad
 * Cliente. Proporciona métodos para realizar operaciones de creación, lectura,
 * actualización y eliminación (CRUD) de clientes en la base de datos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public interface IClienteDAO {

    // Método para agregar un cliente
    void agregarCliente(Cliente cliente) throws PersistenciaException;
    
    //Metodo para insertar 20 clientes a la base de datos
    public void insercionMasiva();

    // Método para cerrar el EntityManager y EntityManagerFactory
    void cerrar();

    // Método para obtener un cliente por ID
    Cliente obtenerClientePorId(Long id) throws PersistenciaException;

    // Método para obtener todos los clientes
    List<Cliente> obtenerTodosLosClientes() throws PersistenciaException;

}
