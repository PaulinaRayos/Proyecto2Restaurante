/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import conexion.Conexion;
import conexion.IConexion;
import dao.RestauranteDAO;
import dto.MesaDTO;
import dto.RestauranteDTO;
import entidadesJPA.Mesa;
import entidadesJPA.Restaurante;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IRestauranteBO;
import interfaces.IRestauranteDAO;
import java.util.ArrayList;
import java.util.List;

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

    public List<RestauranteDTO> obtenerRestaurantes() throws NegocioException {
        try {
            List<Restaurante> restaurantes = restdao.obtenerTodosLosRestaurantes(); // Método que obtiene todos los restaurantes
            List<RestauranteDTO> restaurantesDTO = new ArrayList<>();

            for (Restaurante restaurante : restaurantes) {
                RestauranteDTO dto = new RestauranteDTO();
                dto.setId(restaurante.getId());
                dto.setCiudad(restaurante.getCiudad());
                dto.setDireccion(restaurante.getDirrecion());
                restaurantesDTO.add(dto);
            }

            return restaurantesDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener los restaurantes.", e);
        }
    }

    public RestauranteDTO obtenerRestaurantePorId(Long idRestaurante) throws NegocioException {
        try {
            // Verifica que la consulta o el mapeo estén obteniendo los campos correctos
            Restaurante restaurante = restdao.obtenerPorId(idRestaurante);
            if (restaurante != null) {
                // Convertir el objeto Restaurante a RestauranteDTO
                return new RestauranteDTO(
                        restaurante.getId(),
                        restaurante.getCiudad(),
                        restaurante.getDirrecion(),
                        convertirMesasAListaDTO(restaurante.getMesas())
                );
            }
            return null;
        } catch (PersistenciaException e) {
            throw new NegocioException("Favor de seleccionar Restaurante", e);
        }
    }

    private List<MesaDTO> convertirMesasAListaDTO(List<Mesa> mesas) {
        List<MesaDTO> mesasDTO = new ArrayList<>();
        for (Mesa mesa : mesas) {
            MesaDTO mesaDTO = new MesaDTO();
            mesaDTO.setIdMesa(mesa.getId());
            mesaDTO.setCapacidad(mesa.getCapacidad());
            mesaDTO.setCodigoMesa(mesa.getCodigoMesa());
            mesaDTO.setUbicacion(mesa.getUbicacion());
            mesaDTO.setIdTipoMesa(mesa.getTipoMesa().getId());
            mesaDTO.setIdRestaurante(mesa.getRestaurante().getId());
            mesasDTO.add(mesaDTO);
        }
        return mesasDTO;
    }

}
