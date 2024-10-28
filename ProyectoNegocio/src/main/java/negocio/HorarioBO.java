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
 *
 * @author Chris
 */
public class HorarioBO implements IHorarioBO {

    private final IConexion conexion;
    private final IHorarioDAO horariodao;

    public HorarioBO() {
        this.conexion = new Conexion();
        this.horariodao = new HorarioDAO(conexion);

    }

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
    public List<Long> obtenerIdsHorariosPorIdRestaurante(Long idRestaurante) throws NegocioException{
         try {
            List<Long> listaIdsHorarios =horariodao.obtenerIdsHorariosPorIdRestaurante(idRestaurante);
            return listaIdsHorarios;
         } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener el horario del restaurante.", e);
        }
    }
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
