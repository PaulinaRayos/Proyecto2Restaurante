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

    public void guardarOActualizarHorario(HorarioDTO horarioDTO) throws NegocioException {
        try {
            HorarioMesa horarioMesa = horariomesadao.obtenerOcrearHorarioMesa();

            // Buscar si existe un horario para el día de la semana específico
            Optional<Horario> horarioExistente = horariodao.buscarPorDiaSemana(horarioDTO.getDiaSemana());

            if (horarioExistente.isPresent()) {
                // Si existe, actualizar las horas de apertura y cierre
                Horario horarioActualizar = horarioExistente.get();
                horarioActualizar.setHoraApartura(horarioDTO.getHoraApertura());
                horarioActualizar.setHoraCierre(horarioDTO.getHoraCierre());
                horarioActualizar.setHorarioMesa(horarioMesa);
                horariodao.actualizarHorario(horarioActualizar);
            } else {
                // Si no existe, crear un nuevo horario
                horarioDTO.setIdHorarioMesa(horarioMesa.getId());
                horariodao.crearHorario(ConvertidorGeneral.convertidorEntidad(horarioDTO, Horario.class));
                
            }
        } catch (Exception e) {
            throw new NegocioException("Error al guardar o actualizar el horario: " + e.getMessage(), e);
        }
    }

}
