/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.IConexion;
import entidadesJPA.HorarioMesa;
import interfaces.IHorarioMesaDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author pauli
 */
public class HorarioMesaDAO implements IHorarioMesaDAO{
    
    private final IConexion conexion;
    
        // Constructor
    public HorarioMesaDAO(IConexion conexion) {
        this.conexion = conexion;
    }
    
    // Método para crear un nuevo HorarioMesa
    public void crearHorarioMesa(HorarioMesa horarioMesa) {
        EntityManager em = this.conexion.crearConexion();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(horarioMesa);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    // Método para buscar un HorarioMesa por su ID
    public HorarioMesa horarioMesaPorId(Long id) {
        EntityManager em = this.conexion.crearConexion();
        return em.find(HorarioMesa.class, id);
    }

    // Método para obtener todos los HorarioMesa
    public List<HorarioMesa> horarioMesaTodos() {
        EntityManager em = this.conexion.crearConexion();
        return em.createQuery("SELECT hm FROM HorarioMesa hm", HorarioMesa.class).getResultList();
    }
    
    
    // Método para actualizar un HorarioMesa
    public void actualizarHorarioMesa(HorarioMesa horarioMesa) {
        EntityManager em = this.conexion.crearConexion();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(horarioMesa);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
}
