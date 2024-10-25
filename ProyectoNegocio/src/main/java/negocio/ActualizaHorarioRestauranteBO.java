/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import conexion.Conexion;
import conexion.IConexion;
import dao.RestauranteDAO;
import dto.RestauranteDTO;
import entidadesJPA.Restaurante;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IRestauranteDAO;
import interfaces.IActualizaHorarioRestauranteBO;

/**
 *
 * @author Chris
 */
public class ActualizaHorarioRestauranteBO implements IActualizaHorarioRestauranteBO {

    private final IConexion conexion;
    private IRestauranteDAO restdao;

    public ActualizaHorarioRestauranteBO() {
        this.conexion = new Conexion();
        this.restdao = new RestauranteDAO(conexion);
    }
    
    

    public void guardarOActualizarRestaurante(RestauranteDTO restauranteDTO) throws NegocioException {
        try {
            Restaurante restaurante = restdao.buscarRestauranteUnico();

            if (restaurante == null) {
                // Si no existe un restaurante, crear uno nuevo
                restaurante = new Restaurante();
            }

            // Actualizar los campos del restaurante
            restaurante.setFechaDia(restauranteDTO.getFechaApertura());
            restaurante.setHora_apartura(restauranteDTO.getHoraApertura());
            restaurante.setHora_cierre(restauranteDTO.getHoraCierre());
            

            // Guardar o actualizar el restaurante
            restdao.guardarOActualizarRestaurante(restaurante);

        } catch (PersistenciaException e) {
            throw new NegocioException("Error al guardar o actualizar restaurante", e);
        }
    }
}
