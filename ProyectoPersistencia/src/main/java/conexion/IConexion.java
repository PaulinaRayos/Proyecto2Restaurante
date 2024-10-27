/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package conexion;

import javax.persistence.EntityManager;

/**
 * Interfaz que define un contrato para la creación de conexiones con el gestor
 * de persistencia.
 *
 * Esta interfaz proporciona un método para obtener un objeto EntityManager, que
 * es fundamental para realizar operaciones de acceso a datos utilizando JPA
 * (Java Persistence API). Las implementaciones de esta interfaz deben
 * proporcionar la lógica necesaria para establecer la conexión a la base de
 * datos.
 * Contribuciones de Paulina Rodríguez Rodríguez Rayos.
 * 
 * @author Cristopher Alberto Elizalde Andrade - 240005
 */
public interface IConexion {

    /**
     * Crea una conexión con el gestor de persistencia.
     *
     * @return Un objeto EntityManager para interactuar con la base de datos.
     */
    public EntityManager crearConexion();
}
