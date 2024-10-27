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
 * Implementación de la interfaz IHorarioMesaDAO que proporciona métodos para el
 * acceso a datos de la entidad HorarioMesa. Esta clase permite realizar
 * operaciones de creación, búsqueda, actualización y obtención de horarios de
 * mesas en la base de datos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class HorarioMesaDAO implements IHorarioMesaDAO {

    private final IConexion conexion;

    /**
     * Constructor de la clase HorarioMesaDAO.
     *
     * @param conexion Objeto que proporciona la conexión a la base de datos.
     */
    public HorarioMesaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Crea un nuevo horario de mesa en la base de datos.
     *
     * @param horarioMesa El objeto HorarioMesa a crear.
     */
    public void crearHorarioMesa(HorarioMesa horarioMesa) {
        EntityManager em = this.conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(horarioMesa); // Persistir el horarioMesa en la base de datos
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();// Manejo básico de errores
        } finally {
            em.close(); // Cerrar el EntityManager

        }
    }

    /**
     * Busca un horario de mesa por su ID.
     *
     * @param id El ID del horario de mesa a buscar.
     * @return El objeto HorarioMesa correspondiente al ID proporcionado, o null
     * si no se encuentra.
     */
    public HorarioMesa horarioMesaPorId(Long id) {
        EntityManager em = this.conexion.crearConexion();
        try {
            return em.find(HorarioMesa.class, id); // Buscar el horarioMesa por ID
        } finally {
            em.close(); // Cerrar el EntityManager
        }
    }

    /**
     * Obtiene todos los horarios de mesa de la base de datos.
     *
     * @return Una lista de todos los objetos HorarioMesa.
     */
    public List<HorarioMesa> horarioMesaTodos() {
        EntityManager em = this.conexion.crearConexion();
        try {
            return em.createQuery("SELECT hm FROM HorarioMesa hm", HorarioMesa.class).getResultList(); // Obtener todos los horarios de mesa
        } finally {
            em.close(); // Cerrar el EntityManager
        }
    }

    /**
     * Busca un horario de mesa en la base de datos. Este método devuelve un
     * {@link Optional} que contiene un horario de mesa si se encuentra uno, o
     * un {@link Optional#empty()} si no hay horarios de mesa disponibles.
     *
     * @return Un Optional que contiene el primer HorarioMesa encontrado en la
     * base de datos o Optional.empty() si no se encontró ninguno.
     */
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

    /**
     * Busca un horario de mesa y devuelve uno si existe, o crea uno nuevo si
     * no.
     *
     * @return El HorarioMesa existente o uno nuevo si no se encuentra ninguno.
     */
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

    /**
     * Actualiza un horario de mesa existente en la base de datos.
     *
     * @param horarioMesa El objeto HorarioMesa a actualizar.
     */
    public void actualizarHorarioMesa(HorarioMesa horarioMesa) {
        EntityManager em = this.conexion.crearConexion();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(horarioMesa); // Actualizar el horarioMesa en la base de datos
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace(); // Manejo básico de errores
        } finally {
            em.close(); // Cerrar el EntityManager
        }
    }
}
