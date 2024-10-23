/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.IConexion;
import entidadesJPA.Restaurante;
import excepciones.PersistenciaException;
import interfaces.IRestauranteDAO;
import javax.persistence.EntityManager;

/**
 *
 * @author pauli
 */
public class RestauranteDAO implements IRestauranteDAO {

    private final IConexion conexion;

    public RestauranteDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    public Restaurante obtenerPorId(Long idRestaurante) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();

        try {
            return em.find(Restaurante.class, idRestaurante); // Usar el método find para obtener el objeto
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener el Restaurante.", e);
        } finally {
            em.close(); // Asegurarte de cerrar el EntityManager
        }
    }
}
