/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import conexion.Conexion;
import conexion.IConexion;
import conversiones.ConvertidorGeneral;
import dao.MesaDAO;
import dao.TipoMesaDAO;
import dto.MesaDTO;
import dto.TipoMesaDTO;
import entidadesJPA.Mesa;
import entidadesJPA.TipoMesa;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IMesaBO;
import interfaces.IMesaDAO;
import interfaces.ITipoMesaDAO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa la lógica de negocio para la gestión de mesas en un
 * restaurante. Proporciona métodos para obtener, crear y gestionar tipos de
 * mesas, así como para calcular costos y mapear entidades entre la base de
 * datos y los DTOs.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class MesaBO implements IMesaBO {

    private final IConexion conexion; // Interfaz para la conexión a la base de datos
    private final IMesaDAO mesadao; // Interfaz para las operaciones relacionadas con mesas
    private final ITipoMesaDAO tipodao; // Interfaz para las operaciones relacionadas con tipos de mesa

    /**
     * Constructor de la clase MesaBO. Inicializa las interfaces necesarias para
     * la conexión y el acceso a los datos de mesas y tipos de mesas.
     */
    public MesaBO() {
        this.conexion = new Conexion();
        this.mesadao = new MesaDAO(conexion);
        this.tipodao = new TipoMesaDAO(conexion);
    }

    /**
     * Método para obtener todas las mesas registradas en la base de datos.
     *
     * @return Una lista de objetos MesaDTO que representan todas las mesas.
     * @throws NegocioException Si ocurre un error en la capa de negocio o
     * persistencia.
     */
    @Override
    public List<MesaDTO> obtenerTodasLasMesas() throws NegocioException {
        try {
            // Obtener todas las mesas desde el DAO
            List<Mesa> mesas = mesadao.obtenerTodasLasMesas();
            List<MesaDTO> mesasDTO = new ArrayList<>();

            // Iterar sobre las mesas para convertirlas a DTOs
            for (Mesa mesa : mesas) {
                MesaDTO mesaDTO = new MesaDTO();
                mesaDTO.setIdMesa(mesa.getId());
                mesaDTO.setCodigoMesa(mesa.getCodigoMesa());
                mesaDTO.setUbicacion(mesa.getUbicacion());
                mesaDTO.setCapacidad(mesa.getCapacidad());
                mesaDTO.setIdRestaurante(mesa.getRestaurante().getId()); // Guardar el ID del restaurante

                mesasDTO.add(mesaDTO);
            }

            return mesasDTO; // Retorna la lista de MesaDTO.
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudieron consultar las mesas registradas.");
        }
    }

    /**
     * Método para obtener una mesa específica por su ID.
     *
     * @param idMesa El ID de la mesa a buscar.
     * @return Un objeto MesaDTO que representa la mesa encontrada.
     * @throws NegocioException Si ocurre un error en la capa de negocio o
     * persistencia.
     */
    public MesaDTO obtenerMesaPorId(Long idMesa) throws NegocioException {
        try {
            Mesa mesa = mesadao.obtenerMesaPorId(idMesa);
            return mapearMesaAMesaDTO(mesa);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo encontrar la mesa registrada." + idMesa);
        }
    }

    /**
     * Método para obtener el costo de reserva de una mesa por su ID.
     *
     * @param idMesa El ID de la mesa para la cual se desea obtener el costo.
     * @return Un BigDecimal que representa el costo de reserva de la mesa.
     * @throws NegocioException Si ocurre un error en la capa de negocio o si no
     * se encuentra el costo.
     */
    @Override
    public BigDecimal obtenerCostoPorIdMesa(Long idMesa) throws NegocioException {
        try {
            BigDecimal precioReserva = mesadao.obtenerCostoPorIdMesa(idMesa);
            if (precioReserva == null) {
                throw new NegocioException("No se encontró el precio de la reserva para la mesa con ID: " + idMesa);
            }
            return precioReserva;
        } catch (Exception e) {
            throw new NegocioException("Error al obtener el costo de la mesa.", e);
        }
    }

    /**
     * Método para inicializar los tipos de mesa predeterminados en la base de
     * datos.
     *
     * @throws NegocioException Si ocurre un error en la capa de negocio o
     * persistencia.
     */
    public void inicializarTiposMesaPredeterminados() throws NegocioException {
        try {
            tipodao.insertarTiposMesaPredeterminados();
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al inicializar los tipos de mesa predeterminados", e);
        }
    }

    /**
     * Método para obtener todos los tipos de mesa en formato DTO.
     *
     * @return Una lista de objetos TipoMesaDTO que representan los tipos de
     * mesa.
     * @throws NegocioException Si ocurre un error en la capa de negocio o
     * persistencia.
     */
    // Método para obtener los tipos de mesa predeterminados en formato DTO
    public List<TipoMesaDTO> obtenerTiposMesa() throws NegocioException {
        try {
            // Obtener la lista de tipos de mesa desde la base de datos (capa de persistencia)
            List<TipoMesa> tiposMesa = tipodao.obtenerTodosLosTipos();

            // Convertir a DTOs
            List<TipoMesaDTO> tiposMesaDTO = new ArrayList<>();
            for (TipoMesa tipo : tiposMesa) {
                TipoMesaDTO dto = ConvertidorGeneral.convertidoraDTO(tipo, TipoMesaDTO.class);
                tiposMesaDTO.add(dto);
            }

            return tiposMesaDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener los tipos de mesa", e);
        }
    }

    /**
     * Método para obtener el ID del restaurante asociado a una mesa dada su ID.
     *
     * @param idMesa El ID de la mesa para la cual se desea obtener el ID del
     * restaurante.
     * @return El ID del restaurante asociado a la mesa.
     * @throws NegocioException Si ocurre un error en la capa de negocio o
     * persistencia.
     */
    public Long obtenerIdRestaurantePorIdMesa(Long idMesa) throws NegocioException {
        try {
            Mesa mesa = mesadao.obtenerMesaPorId(idMesa); // Llama al DAO
            return mesa.getRestaurante().getId(); // Retorna el ID del restaurante
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener el ID del restaurante por ID de mesa: " + e.getMessage(), e);
        }
    }

    /**
     * Método para obtener un tipo de mesa por su ID.
     *
     * @param id El ID del tipo de mesa a buscar.
     * @return El objeto TipoMesa correspondiente al ID proporcionado.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    public TipoMesa obtenerTipoMesaPorId(Long id) throws NegocioException {
        try {
            return tipodao.obtenerTipoMesaPorId(id);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener el tipo de mesa: " + e.getMessage(), e);
        }
    }

    /**
     * Método para mapear un objeto Mesa a un objeto MesaDTO.
     *
     * @param mesa El objeto Mesa a mapear.
     * @return El objeto MesaDTO mapeado o null si el objeto Mesa es null.
     */
    public MesaDTO mapearMesaAMesaDTO(Mesa mesa) {
        if (mesa == null) {
            return null; // Retorna null si la mesa es nula
        }

        MesaDTO mesaDTO = new MesaDTO();
        mesaDTO.setIdMesa(mesa.getId()); // Mapea el ID
        mesaDTO.setCodigoMesa(mesa.getCodigoMesa()); // Mapea el código de mesa
        mesaDTO.setUbicacion(mesa.getUbicacion()); // Mapea la ubicación
        mesaDTO.setCapacidad(mesa.getCapacidad()); // Mapea la capacidad

        // Mapea el ID del tipo de mesa
        if (mesa.getTipoMesa() != null) {
            mesaDTO.setIdTipoMesa(mesa.getTipoMesa().getId()); // Mapea el ID del tipo de mesa
        }

        // Mapea el ID del restaurante
        if (mesa.getRestaurante() != null) {
            mesaDTO.setIdRestaurante(mesa.getRestaurante().getId()); // Mapea el ID del restaurante
        }

        return mesaDTO; // Retorna el objeto mapeado
    }

    /**
     * Método para obtener un tipo de mesa DTO por su ID.
     *
     * @param id El ID del tipo de mesa a buscar.
     * @return Un objeto TipoMesaDTO que representa el tipo de mesa encontrado.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    @Override
    public TipoMesaDTO obtenerTipoMesaaPorId(Long id) throws NegocioException {
        try {
            TipoMesa tipo = tipodao.obtenerTipoMesaPorId(id);

            TipoMesaDTO tipodto = new TipoMesaDTO();
            tipodto.setIdTipoMesa(id);
            tipodto.setNombreTipo(tipo.getNombreTipo());
            tipodto.setPrecioReserva(tipo.getPrecioReserva());

            return tipodto;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener el tipo de mesa con id: " + id);
        }
    }
}
