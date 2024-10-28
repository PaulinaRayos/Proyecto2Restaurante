/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import conexion.Conexion;
import conexion.IConexion;
import dao.HorarioDAO;
import dto.HorarioDTO;
import entidadesJPA.Horario;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IHorarioBO;
import interfaces.IHorarioDAO;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa la lógica de negocio para la gestión de horarios de los
 * restaurantes. Se encarga de obtener los horarios asociados a un restaurante
 * específico.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class HorarioBO implements IHorarioBO {

    private final IConexion conexion; // Interfaz para la conexión a la base de datos
    private final IHorarioDAO horariodao; // Interfaz para las operaciones relacionadas con horarios

    /**
     * Constructor de la clase HorarioBO. Inicializa las interfaces necesarias
     * para la conexión y el acceso a los datos.
     */
    public HorarioBO() {
        this.conexion = new Conexion(); // Crea una nueva conexión a la base de datos
        this.horariodao = new HorarioDAO(conexion); // Inicializa el DAO para gestionar horarios
    }

    /**
     * Método para obtener el horario de un restaurante por su ID. Valida que el
     * ID no sea nulo y devuelve un objeto HorarioDTO que representa el horario
     * del restaurante.
     *
     * @param idRestaurante El ID del restaurante para el cual se desea obtener
     * el horario.
     * @return Un objeto HorarioDTO que contiene la información del horario, o
     * null si el restaurante no tiene horario o si el ID es nulo.
     * @throws NegocioException Si ocurre un error en la capa de persistencia.
     */
    @Override
    public HorarioDTO obtenerHorarioPorId(Long idRestaurante) throws NegocioException {
        if (idRestaurante == null) {
            System.out.println("El ID del restaurante no ha sido seleccionado.");
            return null;
        }

        try {
            Horario horario = horariodao.obtenerHorarioPorIdRestaurante(idRestaurante);

            if (horario == null) {
                System.out.println("Horario no encontrado para el restaurante con ID: " + idRestaurante);
                return null; // Si no se encontró el horario, retorna null
            }

            // Convertir la entidad Horario en un HorarioDTO
            HorarioDTO horarioDTO = new HorarioDTO();
            horarioDTO.setIdHorario(horario.getId());
            horarioDTO.setDiaSemana(horario.getDiaSemana());
            horarioDTO.setHoraApertura(horario.getHoraApertura());
            horarioDTO.setHoraCierre(horario.getHoraCierre());
            horarioDTO.setIdRestaurante(horario.getRestaurante().getId());

            return horarioDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener el horario del restaurante.", e);
        }
    }

    /**
     * Método para obtener la lista de IDs de horarios asociados a un
     * restaurante. Llama al DAO correspondiente y retorna la lista de IDs.
     *
     * @param idRestaurante El ID del restaurante para el cual se desean obtener
     * los IDs de horarios.
     * @return Una lista de Long que contiene los IDs de los horarios del
     * restaurante.
     * @throws NegocioException Si ocurre un error en la capa de persistencia.
     */
    @Override
    public List<Long> obtenerIdsHorariosPorIdRestaurante(Long idRestaurante) throws NegocioException {
        try {
            List<Long> listaIdsHorarios = horariodao.obtenerIdsHorariosPorIdRestaurante(idRestaurante);
            return listaIdsHorarios;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener el horario del restaurante.", e);
        }
    }

    /**
     * Método para obtener una lista de horarios asignados a un restaurante dado
     * su ID. Convierte cada entidad Horario en un objeto HorarioDTO y lo agrega
     * a una lista.
     *
     * @param restauranteId El ID del restaurante para el cual se desean obtener
     * los días asignados.
     * @return Una lista de objetos HorarioDTO que contienen la información de
     * los horarios asignados al restaurante.
     */
    @Override
    public List<HorarioDTO> obtenerDiasAsignadosParaRestaurante(Long restauranteId) {
        List<Horario> horarios = horariodao.obtenerHorariosPorRestaurante(restauranteId);
        List<HorarioDTO> horariosDTO = new ArrayList<>();

        for (Horario horario : horarios) {
            HorarioDTO dto = new HorarioDTO();
            dto.setIdHorario(horario.getId()); // Asumiendo que 'Horario' tiene este método
            dto.setDiaSemana(horario.getDiaSemana()); // Asumiendo que 'Horario' tiene este método
            dto.setHoraApertura(horario.getHoraApertura()); // Asumiendo que 'Horario' tiene este método
            dto.setHoraCierre(horario.getHoraCierre()); // Asumiendo que 'Horario' tiene este método
            dto.setIdRestaurante(horario.getRestaurante().getId()); // Asumiendo que 'Horario' tiene este método

            horariosDTO.add(dto);
        }

        return horariosDTO;
    }

    /**
     * Método para obtener un horario específico a partir de su ID. Si no se
     * encuentra el horario, retorna null.
     *
     * @param idHorario El ID del horario que se desea obtener.
     * @return Un objeto Horario que representa el horario correspondiente al
     * ID, o null si no se encuentra.
     * @throws NegocioException Si ocurre un error en la capa de persistencia.
     */
    @Override
    public Horario obtenerHorarioPorIdHorario(Long idHorario) throws NegocioException {
        try {
            Horario horario = horariodao.obtenerHorarioPorId(idHorario);

            if (horario == null) {
                System.out.println("Horario no encontrado con ID: " + idHorario);
                return null; // Si no se encontró el horario, retorna null
            }
            return horario;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener el horario del restaurante.", e);
        }
    }

}
