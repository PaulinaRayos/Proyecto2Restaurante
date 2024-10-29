/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase que implementa la interfaz IConexion y proporciona métodos para
 * establecer una conexión con el gestor de persistencia.
 *
 * Esta clase es responsable de crear un objeto EntityManager que permite
 * interactuar con la base de datos utilizando JPA (Java Persistence API).
 * Utiliza una unidad de persistencia definida en el archivo de configuración
 * Contribuciones de Paulina Rodríguez Rodríguez Rayos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 */
public class Conexion implements IConexion {

    /**
     * Constructor por defecto de la clase Conexion. Este constructor se utiliza
     * para crear instancias de Conexion.
     */
    public Conexion() {
        // Constructor por defecto
    }

    /**
     * Crea una conexión con el gestor de persistencia.
     *
     * @return Un objeto EntityManager para interactuar con la base de datos.
     */
    @Override
    public EntityManager crearConexion() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("pu_restaurante");

        EntityManager entityManager = emFactory.createEntityManager();

        return entityManager;
    }
}
