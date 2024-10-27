/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.IConexion;
import entidadesJPA.Horario;
import excepciones.PersistenciaException;
import interfaces.IHorarioDAO;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;

/**
 *
 * @author pauli
 */
public class HorarioDAO implements IHorarioDAO {

    private final IConexion conexion;

    // Constructor
    public HorarioDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    // Método para crear un nuevo Horario
    public void crearHorario(Horario horario) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            em.getTransaction().begin();

            // Validar el horario antes de persistir
            if (horario == null || horario.getHoraApertura() == null || horario.getHoraCierre() == null) {
                throw new PersistenciaException("El horario no puede ser nulo y debe contener horas de apertura y cierre válidas.");
            }

            // Aquí puedes agregar lógica adicional para verificar conflictos de horarios, si es necesario
            em.persist(horario);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al crear horario: " + e.getMessage(), e);
        } finally {
            em.close();

        }
    }
        // Método para buscar un HorarioMesa por su ID
    public Horario HorarioPorId(Long id) {
        EntityManager em = this.conexion.crearConexion();
        return em.find(Horario.class, id);
    }

    public Optional<Horario> buscarPorDiaSemana(String diaSemana) {
        EntityManager em = this.conexion.crearConexion();
        try {
            Horario horario = em.createQuery("SELECT h FROM Horario h WHERE h.diaSemana = :diaSemana", Horario.class)
                    .setParameter("diaSemana", diaSemana)
                    .getSingleResult();
            return Optional.of(horario);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    // Método para obtener todos los HorarioMesa
    public List<Horario> HorarioTodos() {
        EntityManager em = this.conexion.crearConexion();
        return em.createQuery("FROM Horario", Horario.class).getResultList();
    }

    // Método para actualizar un Horario
    public void actualizarHorario(Horario horario) {
        EntityManager em = this.conexion.crearConexion();
        em.getTransaction().begin();

        em.merge(horario);

        em.getTransaction().commit();

        em.close();
    }

}
