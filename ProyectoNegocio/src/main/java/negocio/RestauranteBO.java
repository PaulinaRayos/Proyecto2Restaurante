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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public void guardarRestaurante(RestauranteDTO restauranteDTO) throws NegocioException {
        try {
            Restaurante restaurante = new Restaurante();

            restaurante.setCiudad(restauranteDTO.getCiudad());
            restaurante.setDirrecion(restauranteDTO.getDireccion());
            restdao.guardarRestaurante(restaurante);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al guardar el restaurante!");
        }
    }

    public List<String> obtenerCiudadesYDirecciones() throws NegocioException {
        try {
            List<Object[]> resultados = restdao.buscarCiudadesYDireccionesRestaurantes();
            List<String> listaFormateada = new ArrayList<>();

            for (Object[] resultado : resultados) {
                String ciudad = (String) resultado[0];
                String direccion = (String) resultado[1];
                listaFormateada.add(ciudad + " - " + direccion);
            }

            return listaFormateada;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al obtener los restaurantes.");
        }
    }

    @Override
    public RestauranteDTO obtenerRestaurantePorId(Long idRestaurante) throws NegocioException {
//        try {
//            // Verifica que la consulta o el mapeo estén obteniendo los campos correctos
//            Restaurante restaurante = restdao.obtenerPorId(idRestaurante);
//            if (restaurante != null) {
//                return new RestauranteDTO(restaurante.getId(),
//                        restaurante.getHora_apartura(), restaurante.getHora_cierre());
//            }
        return null;
//        } catch (PersistenciaException e) {
//            throw new NegocioException("Error al obtener restaurante por ID", e);
//        }
    }

}
