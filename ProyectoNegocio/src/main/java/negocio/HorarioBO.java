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
            horarioDTO.setHoraApertura(horario.getHoraApertura());
            horarioDTO.setHoraCierre(horario.getHoraCierre());

            return horarioDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener el horario del restaurante.", e);
        }
    }

}
