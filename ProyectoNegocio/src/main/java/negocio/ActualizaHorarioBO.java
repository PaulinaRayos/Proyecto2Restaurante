/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import conexion.Conexion;
import conexion.IConexion;
import conversiones.ConvertidorGeneral;
import dao.HorarioDAO;
import dao.HorarioMesaDAO;
import dao.RestauranteDAO;
import dto.HorarioDTO;
import entidadesJPA.Horario;
import entidadesJPA.HorarioMesa;
import entidadesJPA.Restaurante;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IRestauranteDAO;
import interfaces.IHorarioDAO;
import java.util.Optional;
import interfaces.IActualizaHorarioBO;
import interfaces.IHorarioMesaDAO;

/**
 *
 * @author Chris
 */
public class ActualizaHorarioBO implements IActualizaHorarioBO {

    private final IConexion conexion;
    private IRestauranteDAO restdao;
    private IHorarioDAO horariodao;
    private IHorarioMesaDAO horariomesadao;

    public ActualizaHorarioBO() {
        this.conexion = new Conexion();
        this.restdao = new RestauranteDAO(conexion);
        this.horariodao = new HorarioDAO(conexion);
        this.horariomesadao = new HorarioMesaDAO(conexion);
    }

    @Override
    public void guardarHorario(HorarioDTO horarioDTO) throws NegocioException {
        try {

            Restaurante restaurante = restdao.obtenerPorId(horarioDTO.getIdRestaurante());
            // Buscar si existe un horario para el día de la semana específico
            Optional<Horario> horarioExistente = horariodao.buscarPorDiaSemana(horarioDTO.getDiaSemana());

            if (horarioExistente.isPresent()) {
                // Si existe, actualizar las horas de apertura y cierre
                Horario horarioActualizar = horarioExistente.get();
                horarioActualizar.setRestaurante(restaurante);
                horarioActualizar.setDiaSemana(horarioDTO.getDiaSemana());
                horarioActualizar.setHoraApartura(horarioDTO.getHoraApertura());
                horarioActualizar.setHoraCierre(horarioDTO.getHoraCierre());
                horarioActualizar.setRestaurante(restaurante);
                horariodao.actualizarHorario(horarioActualizar);
            } else {
                
               Horario horario =convertidorEntidad(horarioDTO);
                horariodao.crearHorario(horario);

            }
        } catch (Exception e) {
            throw new NegocioException("Error al guardar o actualizar el horario: " + e.getMessage(), e);
        }
    }
    public  Horario convertidorEntidad(HorarioDTO horarioDTO) throws PersistenciaException {
        if (horarioDTO == null) {
            return null;
        }

        Horario horario = new Horario();
        horario.setId(horarioDTO.getIdHorario());
        horario.setDiaSemana(horarioDTO.getDiaSemana());
        horario.setHoraApartura(horarioDTO.getHoraApertura());
        horario.setHoraCierre(horarioDTO.getHoraCierre());

        // Convertir idRestaurante a objeto Restaurante
        Restaurante restaurante = restdao.obtenerPorId(horarioDTO.getIdRestaurante());
        horario.setRestaurante(restaurante);

        return horario;
    }

}
