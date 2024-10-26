/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.IConexion;
import entidadesJPA.Horario;
import interfaces.IHorarioDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author pauli
 */
public class HorarioDAO implements IHorarioDAO{
    
        private final IConexion conexion;
    
        // Constructor
    public HorarioDAO(IConexion conexion) {
        this.conexion = conexion;
    }
    
    // Método para crear un nuevo Horario
    public void crearHorario(Horario horario) {
        EntityManager em = this.conexion.crearConexion();
        em.persist(horario);
    }
    
    
    // Método para buscar un HorarioMesa por su ID
    public Horario HorarioPorId(Long id) {
        EntityManager em = this.conexion.crearConexion();
        return em.find(Horario.class, id);
    }
    
    
    
    // Método para obtener todos los HorarioMesa
    public List<Horario> HorarioTodos() {
        EntityManager em = this.conexion.crearConexion();
        return em.createQuery("FROM Horario", Horario.class).getResultList();
    }
    
    // Método para actualizar un Horario
    public void actualizarHorario(Horario horario) {
        EntityManager em = this.conexion.crearConexion();
        em.merge(horario);
    }
    
    
}
