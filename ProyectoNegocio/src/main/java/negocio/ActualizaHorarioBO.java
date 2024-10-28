/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import conexion.Conexion;
import conexion.IConexion;
import dao.HorarioDAO;
import dao.RestauranteDAO;
import dto.HorarioDTO;
import entidadesJPA.Horario;
import entidadesJPA.Restaurante;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IRestauranteDAO;
import interfaces.IHorarioDAO;
import interfaces.IActualizaHorarioBO;
import java.util.List;

/**
 * Clase que implementa la lógica de negocio para la actualización de horarios
 * de restaurantes. Se encarga de guardar y actualizar la información de
 * horarios en la base de datos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class ActualizaHorarioBO implements IActualizaHorarioBO {

    private final IConexion conexion; // Interfaz para la conexión a la base de datos
    private final IRestauranteDAO restdao; // Interfaz para las operaciones de restaurante
    private final IHorarioDAO horariodao; // Interfaz para las operaciones de horario

    /**
     * Constructor de la clase ActualizaHorarioBO. Inicializa las interfaces
     * necesarias para la conexión y el acceso a los datos.
     */
    public ActualizaHorarioBO() {
        this.conexion = new Conexion();
        this.restdao = new RestauranteDAO(conexion);
        this.horariodao = new HorarioDAO(conexion);
    }

    /**
     * Método para guardar un horario en la base de datos. Si ya existe un
     * horario para el día de la semana específico, se actualiza. Si no existe,
     * se crea un nuevo horario.
     *
     * @param horarioDTO Objeto que contiene la información del horario a
     * guardar.
     * @throws NegocioException Si ocurre un error al guardar o actualizar el
     * horario.
     */
    @Override
    public void guardarHorario(HorarioDTO horarioDTO) throws NegocioException {
        try {

            Restaurante restaurante = restdao.obtenerPorId(horarioDTO.getIdRestaurante());

            List<Horario> horariosExistentes = horariodao.buscarPorDiaYRestaurante(horarioDTO.getDiaSemana(), horarioDTO.getIdRestaurante());

            if (!horariosExistentes.isEmpty()) {
                // Si existen, actualizar las horas de apertura y cierre del primer horario encontrado
                Horario horarioActualizar = horariosExistentes.get(0); // O puedes decidir cómo manejar múltiples horarios
                horarioActualizar.setHoraApartura(horarioDTO.getHoraApertura());
                horarioActualizar.setHoraCierre(horarioDTO.getHoraCierre());
                horariodao.actualizarHorario(horarioActualizar);
            } else {
                // Si no existen, crear un nuevo horario
                Horario horario = convertidorEntidad(horarioDTO);
                horariodao.crearHorario(horario);
            }
        } catch (Exception e) {
            throw new NegocioException("Error al guardar o actualizar el horario: " + e.getMessage(), e);
        }
    }

    /**
     * Método para convertir un objeto HorarioDTO en un objeto Horario.
     *
     * @param horarioDTO Objeto que contiene la información del horario.
     * @return Un objeto Horario correspondiente al horarioDTO.
     * @throws PersistenciaException Si ocurre un error al acceder a los datos.
     */
    public Horario convertidorEntidad(HorarioDTO horarioDTO) throws PersistenciaException {
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
