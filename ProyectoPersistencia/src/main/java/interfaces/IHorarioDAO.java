/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidadesJPA.Horario;
import excepciones.PersistenciaException;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad
 * Horario. Proporciona métodos para realizar operaciones de creación, lectura,
 * actualización y eliminación (CRUD) de horarios en la base de datos.
 * Contribuciones de Paulina Rodríguez Rodríguez Rayos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 */
public interface IHorarioDAO {

    /**
     * Busca un horario por su ID.
     *
     * @param id El ID del horario a buscar.
     * @return El objeto Horario correspondiente al ID proporcionado, o null si
     * no se encuentra.
     */
    Horario HorarioPorId(Long id);

    /**
     * Obtiene todos los horarios de la base de datos.
     *
     * @return Una lista de todos los objetos Horario.
     */
    List<Horario> HorarioTodos();

    /**
     * Actualiza un horario existente en la base de datos.
     *
     * @param horario El objeto Horario a actualizar.
     */
    void actualizarHorario(Horario horario);

    /**
     * Busca un horario por día de la semana.
     *
     * @param diaSemana El día de la semana para buscar el horario.
     * @return Un objeto Optional que contiene el horario si se encuentra, o
     * vacío si no se encuentra.
     */
    Optional<Horario> buscarPorDiaSemana(String diaSemana);

    /**
     * Crea un nuevo horario en la base de datos.
     *
     * @param horario El objeto Horario a crear.
     * @throws PersistenciaException Si el horario es nulo o si ocurre un error
     * al persistirlo en la base de datos.
     */
    void crearHorario(Horario horario) throws PersistenciaException;

    Horario obtenerHorarioPorIdRestaurante(Long idRestaurante) throws PersistenciaException;

    List<Horario> obtenerHorariosPorRestaurante(Long restauranteId);

    List<Horario> buscarPorDiaYRestaurante(String diaSemana, Long idRestaurante);

    List<Long> obtenerIdsHorariosPorIdRestaurante(Long idRestaurante) throws PersistenciaException;

    Horario obtenerHorarioPorId(Long idHorario) throws PersistenciaException;

}
