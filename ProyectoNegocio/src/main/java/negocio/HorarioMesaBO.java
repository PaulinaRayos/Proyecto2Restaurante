/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import conexion.Conexion;
import conexion.IConexion;
import dao.HorarioMesaDAO;
import entidadesJPA.HorarioMesa;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IHorarioMesaBO;
import interfaces.IHorarioMesaDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa la lógica de negocio para la gestión de los horarios
 * asociados a las mesas en un restaurante. Permite crear horarios de mesa y
 * obtener los horarios asociados a una mesa específica.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class HorarioMesaBO implements IHorarioMesaBO {

    private final IConexion conexion; // Interfaz para la conexión a la base de datos
    private final IHorarioMesaDAO horarioMesaDao; // Interfaz para las operaciones relacionadas con horarios de mesa

    /**
     * Constructor de la clase HorarioMesaBO. Inicializa las interfaces
     * necesarias para la conexión y el acceso a los datos de horarios de mesa.
     */
    public HorarioMesaBO() {
        this.conexion = new Conexion();
        this.horarioMesaDao = new HorarioMesaDAO(conexion);
    }

    /**
     * Método para crear un nuevo horario de mesa en la base de datos. Llama al
     * método correspondiente en el DAO para persistir el horario.
     *
     * @param horarioMesa El objeto HorarioMesa que contiene la información del
     * horario a crear.
     * @throws NegocioException Si ocurre un error en la capa de negocio.
     */
    @Override
    public void crearHorarioMesa(HorarioMesa horarioMesa) throws NegocioException {

        this.horarioMesaDao.crearHorarioMesa(horarioMesa);
    }

    /**
     * Método para obtener una lista de horarios asociados a una mesa dada su
     * ID. Llama al DAO correspondiente para recuperar la información de los
     * horarios.
     *
     * @param idMesa El ID de la mesa para la cual se desean obtener los
     * horarios.
     * @return Una lista de objetos HorarioMesa que representan los horarios de
     * la mesa, o null si ocurre un error en la capa de persistencia.
     */
    @Override
    public List<HorarioMesa> obtenerHorariosPorMesa(Long idMesa) {
        try {
            return this.horarioMesaDao.obtenerHorariosPorMesa(idMesa);
        } catch (PersistenciaException ex) {
            Logger.getLogger(HorarioMesaBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
