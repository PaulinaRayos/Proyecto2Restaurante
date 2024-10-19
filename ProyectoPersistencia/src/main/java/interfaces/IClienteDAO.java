/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidadesJPA.Cliente;
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

    // Método para actualizar un cliente
    void actualizarCliente(Cliente cliente);

    // Método para agregar un cliente
    void agregarCliente(Cliente cliente);

    // Método para cerrar el EntityManager y EntityManagerFactory
    void cerrar();

    // Método para eliminar un cliente
    void eliminarCliente(int id);

    // Método para obtener un cliente por ID
    Cliente obtenerClientePorId(int id);

    // Método para obtener todos los clientes
    List<Cliente> obtenerTodosLosClientes();

}
