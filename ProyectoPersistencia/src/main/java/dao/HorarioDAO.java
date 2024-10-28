/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.IConexion;
import entidadesJPA.Horario;
import excepciones.PersistenciaException;
import interfaces.IHorarioDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * Implementación de la interfaz IHorarioDAO que proporciona métodos para el
 * acceso a datos de la entidad Horario. Esta clase permite realizar operaciones
 * de creación, búsqueda, actualización y obtención de horarios en la base de
 * datos. Contribuciones de Paulina Rodríguez Rodríguez Rayos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 */
public class HorarioDAO implements IHorarioDAO {

    private final IConexion conexion;

    /**
     * Constructor de la clase HorarioDAO.
     *
     * @param conexion Objeto que proporciona la conexión a la base de datos.
     */
    public HorarioDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Crea un nuevo horario en la base de datos.
     *
     * @param horario El objeto Horario a crear.
     * @throws PersistenciaException Si el horario es nulo o si ocurre un error
     * al persistirlo en la base de datos.
     */
    @Override
    public void crearHorario(Horario horario) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            em.getTransaction().begin();

            // Validar el horario antes de persistir
            if (horario == null || horario.getHoraApertura() == null || horario.getHoraCierre() == null) {
                throw new PersistenciaException("El horario no puede ser nulo y debe contener horas de apertura y cierre válidas.");
            }

            // Persistir el horario en la base de datos
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

    /**
     * Obtiene los id de los horarios por medio de el id del restaurante
     *
     * @param idRestaurante el id del restaurante
     * @return la lista de ids de los horarios
     * @throws PersistenciaException
     */
    @Override
    public List<Long> obtenerIdsHorariosPorIdRestaurante(Long idRestaurante) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        List<Long> listaIdsHorarios = new ArrayList<>();

        try {
            // Consulta para obtener los horarios del restaurante
            TypedQuery<Horario> query = em.createQuery("SELECT h FROM Horario h WHERE h.restaurante.id = :idRestaurante", Horario.class);
            query.setParameter("idRestaurante", idRestaurante);
            List<Horario> horarios = query.getResultList();

            // Obtener los IDs de los horarios
            for (Horario horario : horarios) {
                listaIdsHorarios.add(horario.getId());
            }

            return listaIdsHorarios; // Retornar la lista de IDs
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener los IDs de los horarios por ID de restaurante: " + e.getMessage(), e);
        } finally {
            em.close(); // Asegurarse de cerrar el EntityManager
        }
    }

    /**
     * Obtiene un horario por su ID.
     *
     * @param idHorario el ID del horario a buscar
     * @return el objeto Horario correspondiente al ID proporcionado
     * @throws PersistenciaException si ocurre un error al obtener el horario
     */
    @Override
    public Horario obtenerHorarioPorId(Long idHorario) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            return em.find(Horario.class, idHorario); // Busca el horario por su ID
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo obtener el horario con ID: " + idHorario, e);
        } finally {
            em.close();
        }
    }

    /**
     * Busca un horario por su ID.
     *
     * @param id El ID del horario a buscar.
     * @return El objeto Horario correspondiente al ID proporcionado, o null si
     * no se encuentra.
     */
    @Override
    public Horario HorarioPorId(Long id) {
        EntityManager em = this.conexion.crearConexion();
        try {
            return em.find(Horario.class, id); // Buscar el horario por ID
        } finally {
            em.close();
        }
    }

    /**
     * Busca un horario por día de la semana.
     *
     * @param diaSemana El día de la semana para buscar el horario.
     * @return Un objeto Optional que contiene el horario si se encuentra, o
     * vacío si no se encuentra.
     */
    @Override
    public Optional<Horario> buscarPorDiaSemana(String diaSemana) {
        EntityManager em = this.conexion.crearConexion();
        try {
            Horario horario = em.createQuery("SELECT h FROM Horario h WHERE h.diaSemana = :diaSemana", Horario.class)
                    .setParameter("diaSemana", diaSemana)
                    .getSingleResult();
            return Optional.of(horario);
        } catch (Exception e) {
            return Optional.empty();
        } finally {
            em.close();
        }
    }

    /**
     * Busca los horarios de un restaurante en un día específico de la semana.
     *
     * @param diaSemana el día de la semana para buscar los horarios
     * @param idRestaurante el ID del restaurante cuyas horas se buscan
     * @return una lista de objetos Horario que coinciden con el día y el
     * restaurante
     */
    @Override
    public List<Horario> buscarPorDiaYRestaurante(String diaSemana, Long idRestaurante) {
        EntityManager em = this.conexion.crearConexion();
        try {
            return em.createQuery("SELECT h FROM Horario h WHERE h.diaSemana = :diaSemana AND h.restaurante.id = :idRestaurante", Horario.class)
                    .setParameter("diaSemana", diaSemana)
                    .setParameter("idRestaurante", idRestaurante)
                    .getResultList();
        } catch (Exception e) {
            // Manejo de excepciones si es necesario
            return Collections.emptyList();
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene todos los horarios de la base de datos.
     *
     * @return Una lista de todos los objetos Horario.
     */
    @Override
    public List<Horario> HorarioTodos() {
        EntityManager em = this.conexion.crearConexion();
        try {
            return em.createQuery("FROM Horario", Horario.class).getResultList(); // Obtener todos los horarios
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene un horario por medio del id del restaurante.
     *
     * @param idRestaurante
     * @return Un objeto horario con sus atributos.
     * @throws PersistenciaException
     */
    @Override
    public Horario obtenerHorarioPorIdRestaurante(Long idRestaurante) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        Horario horario = null;

        try {
            String jpql = "SELECT h FROM Horario h WHERE h.restaurante.id = :idRestaurante";
            TypedQuery<Horario> query = em.createQuery(jpql, Horario.class);
            query.setParameter("idRestaurante", idRestaurante);
            horario = query.getSingleResult();

        } catch (NoResultException e) {
            // Retornar null si no se encuentra un horario
            System.out.println("No se encontró un horario para el restaurante con ID: " + idRestaurante);
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener el horario del restaurante.", e);
        } finally {
            em.close();
        }

        return horario;
    }

    /**
     * Obtiene una lista de horarios asociados a un restaurante específico.
     *
     * @param restauranteId el ID del restaurante cuyas horas se desean obtener
     * @return una lista de objetos Horario que pertenecen al restaurante
     * especificado
     */
    @Override
    public List<Horario> obtenerHorariosPorRestaurante(Long restauranteId) {
        EntityManager em = this.conexion.crearConexion();
        String query = "SELECT h FROM Horario h WHERE h.restaurante.id = :restauranteId";
        return em.createQuery(query, Horario.class)
                .setParameter("restauranteId", restauranteId)
                .getResultList();
    }

    /**
     * Actualiza un horario existente en la base de datos.
     *
     * @param horario El objeto Horario a actualizar.
     */
    @Override
    public void actualizarHorario(Horario horario) {
        EntityManager em = this.conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.merge(horario); // Actualizar el horario en la base de datos
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            // Manejar excepciones de actualización si es necesario
        } finally {
            em.close();
        }
    }

}
