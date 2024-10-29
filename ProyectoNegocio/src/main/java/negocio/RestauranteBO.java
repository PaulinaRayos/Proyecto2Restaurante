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
import java.util.Date;
import java.util.List;

/**
 * Clase que implementa la lógica de negocio para la gestión de restaurantes.
 * Proporciona métodos para guardar restaurantes, obtener horarios y manejar la
 * información relacionada con ellos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class RestauranteBO implements IRestauranteBO {

    private final IConexion conexion;
    private final IRestauranteDAO restdao;

    /**
     * Constructor que inicializa las dependencias necesarias para la gestión de
     * restaurantes. Se establece la conexión a la base de datos y se inicializa
     * el DAO correspondiente.
     */
    public RestauranteBO() {
        this.conexion = new Conexion();
        this.restdao = new RestauranteDAO(conexion);
    }

    /**
     * Guarda un nuevo restaurante en la base de datos.
     *
     * @param restauranteDTO Objeto que contiene los datos del restaurante a
     * guardar.
     * @throws NegocioException Si ocurre un error al guardar el restaurante.
     */
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

    /**
     * Obtiene una lista de ciudades y direcciones de restaurantes formateadas.
     *
     * @return Lista de cadenas que representan las ciudades y direcciones de
     * restaurantes.
     * @throws NegocioException Si ocurre un error al obtener los restaurantes.
     */
    @Override
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

    /**
     * Obtiene una lista de todos los restaurantes en formato DTO.
     *
     * @return Lista de objetos RestauranteDTO que representan todos los
     * restaurantes.
     * @throws NegocioException Si ocurre un error al obtener los restaurantes.
     */
    @Override
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

    /**
     * Obtiene la hora de apaertura del restaurante.
     *
     * @param idRestaurante el id del restaurante al que le pertenece el horario
     * apertura
     * @param diaSemana el dia de la semana
     * @return la hora de apertura.
     * @throws NegocioException Si ocurre un error al buscar la hora de apertura
     * del restaurante
     */
    @Override
    public Date obtenerHoraApertura(Long idRestaurante, String diaSemana) throws NegocioException {
        try {
            Date horaApertura = restdao.obtenerHoraApertura(idRestaurante, diaSemana);
            if (horaApertura == null) {
                throw new NegocioException("No se encontró la hora de apertura para el restaurante seleccionado.");
            }
            return horaApertura;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al obtener la hora de apertura");
        }
    }

    /**
     * Obtiene la hora de cierre del restaurante.
     *
     * @param idRestaurante el id del restaurante al que le pertenece el horario
     * cierre
     * @param diaSemana el dia de la semana
     * @return la hora de cirre.
     * @throws NegocioException Si ocurre un error al buscar la hora de cierre
     * del restaurante
     */
    @Override
    public Date obtenerHoraCierre(Long idRestaurante, String diaSemana) throws NegocioException {
        try {
            Date horaCierre = restdao.obtenerHoraCierre(idRestaurante, diaSemana);
            if (horaCierre == null) {
                throw new NegocioException("No se encontró la hora de cierre para el restaurante seleccionado.");
            }
            return horaCierre;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al obtener la hora de cierre");
        }
    }

    /**
     * Obtiene un restaurante por su ID.
     *
     * @param idRestaurante el ID del restaurante a buscar.
     * @return RestauranteDTO que representa el restaurante encontrado.
     * @throws NegocioException Si ocurre un error al obtener el restaurante.
     */
    @Override
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

    /**
     * Convierte una lista de mesas a su representación en formato DTO.
     *
     * @param mesas Lista de objetos Mesa a convertir.
     * @return Lista de objetos MesaDTO que representan las mesas.
     */
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
