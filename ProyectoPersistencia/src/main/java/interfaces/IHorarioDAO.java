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

    /**
     * Obtiene los id de los horarios por medio de el id del restaurante
     *
     * @param idRestaurante el id del restaurante
     * @return la lista de ids de los horarios
     * @throws PersistenciaException
     */
    Horario obtenerHorarioPorIdRestaurante(Long idRestaurante) throws PersistenciaException;

    /**
     * Obtiene una lista de horarios asociados a un restaurante específico.
     *
     * @param restauranteId el ID del restaurante cuyas horas se desean obtener
     * @return una lista de objetos Horario que pertenecen al restaurante
     * especificado
     */
    List<Horario> obtenerHorariosPorRestaurante(Long restauranteId);

    /**
     * Busca los horarios de un restaurante en un día específico de la semana.
     *
     * @param diaSemana el día de la semana para buscar los horarios
     * @param idRestaurante el ID del restaurante cuyas horas se buscan
     * @return una lista de objetos Horario que coinciden con el día y el
     * restaurante
     */
    List<Horario> buscarPorDiaYRestaurante(String diaSemana, Long idRestaurante);

    /**
     * Obtiene los id de los horarios por medio de el id del restaurante
     *
     * @param idRestaurante el id del restaurante
     * @return la lista de ids de los horarios
     * @throws PersistenciaException
     */
    List<Long> obtenerIdsHorariosPorIdRestaurante(Long idRestaurante) throws PersistenciaException;

    /**
     * Obtiene un horario por su ID.
     *
     * @param idHorario el ID del horario a buscar
     * @return el objeto Horario correspondiente al ID proporcionado
     * @throws PersistenciaException si ocurre un error al obtener el horario
     */
    Horario obtenerHorarioPorId(Long idHorario) throws PersistenciaException;

}
