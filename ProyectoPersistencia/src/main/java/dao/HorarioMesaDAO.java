/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.IConexion;
import entidadesJPA.HorarioMesa;
import interfaces.IHorarioMesaDAO;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author pauli
 */
public class HorarioMesaDAO implements IHorarioMesaDAO {

    private final IConexion conexion;

    // Constructor
    public HorarioMesaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    // Método para crear un nuevo HorarioMesa
    public void crearHorarioMesa(HorarioMesa horarioMesa) {
        EntityManager em = this.conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(horarioMesa);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
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

    public Optional<HorarioMesa> buscarHorarioMesa() {
        EntityManager em = this.conexion.crearConexion();
        // Crear una consulta para buscar cualquier HorarioMesa
        TypedQuery<HorarioMesa> query = em.createQuery("SELECT h FROM HorarioMesa h", HorarioMesa.class);

        // Configura la consulta para devolver solo un resultado
        query.setMaxResults(1);

        // Obtener el resultado de la consulta
        List<HorarioMesa> resultados = query.getResultList();

        // Devolver el primer HorarioMesa encontrado o un Optional vacío si no hay resultados
        return resultados.isEmpty() ? Optional.empty() : Optional.of(resultados.get(0));
    }

    public HorarioMesa obtenerOcrearHorarioMesa() {

        // 1. Buscar si ya existe un HorarioMesa con ciertas características (si aplica algún filtro)
        Optional<HorarioMesa> horarioMesaExistente = this.buscarHorarioMesa();

        if (horarioMesaExistente.isPresent()) {
            return horarioMesaExistente.get(); // Usar el HorarioMesa existente
        } else {
            // 2. Crear un nuevo HorarioMesa si no existe
            HorarioMesa nuevoHorarioMesa = new HorarioMesa();
            // Configura los atributos necesarios de HorarioMesa, si tiene alguno más
            this.crearHorarioMesa(nuevoHorarioMesa); // Guardar en la base de datos para generar el ID
            return nuevoHorarioMesa;
        }

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
