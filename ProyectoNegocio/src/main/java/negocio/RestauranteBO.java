/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import conexion.Conexion;
import conexion.IConexion;
import conversiones.ConvertidorGeneral;
import dao.RestauranteDAO;
import dto.RestauranteDTO;
import entidadesJPA.Restaurante;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IRestauranteBO;
import interfaces.IRestauranteDAO;

/**
 *
 * @author Chris
 */
public class RestauranteBO implements IRestauranteBO {

    private final IConexion conexion;
    private IRestauranteDAO restdao;

    public RestauranteBO() {
        this.conexion = new Conexion();
        this.restdao = new RestauranteDAO(conexion);
    }

    @Override
    public RestauranteDTO obtenerRestaurantePorId(Long idRestaurante) throws NegocioException {
        try {
            // Verifica que la consulta o el mapeo estén obteniendo los campos correctos
            Restaurante restaurante = restdao.obtenerPorId(idRestaurante);
            if (restaurante != null) {
                return new RestauranteDTO(restaurante.getId(),
                        restaurante.getHora_apartura(), restaurante.getHora_cierre());
            }
            return null;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener restaurante por ID", e);
        }
    }

    public RestauranteDTO buscarRestauranteUnico() throws NegocioException {
        try {
            Restaurante restaurante = restdao.buscarRestauranteUnico();
            return ConvertidorGeneral.convertidoraDTO(restaurante, RestauranteDTO.class);
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo obtener el Restaurante.");
        }
    }
}
