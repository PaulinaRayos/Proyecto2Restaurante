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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chris
 */
public class MesaBO implements IMesaBO {

    private final IConexion conexion;
    private IMesaDAO mesadao;
    private ITipoMesaDAO tipodao;

    public MesaBO() {
        this.conexion = new Conexion();
        this.mesadao = new MesaDAO(conexion);
        this.tipodao = new TipoMesaDAO(conexion);
    }

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

    public MesaDTO obtenerMesaPorId(Long idMesa) throws NegocioException {
        try {
            Mesa mesa = mesadao.obtenerMesaPorId(idMesa);
            return mapearMesaAMesaDTO(mesa);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo encontrar la mesa registrada." + idMesa);
        }
    }

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

    public void inicializarTiposMesaPredeterminados() throws NegocioException {
        try {
            tipodao.insertarTiposMesaPredeterminados();
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al inicializar los tipos de mesa predeterminados", e);
        }
    }

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

    public Long obtenerIdRestaurantePorIdMesa(Long idMesa) throws NegocioException {
        try {
            Mesa mesa = mesadao.obtenerMesaPorId(idMesa); // Llama al DAO
            return mesa.getRestaurante().getId(); // Retorna el ID del restaurante
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener el ID del restaurante por ID de mesa: " + e.getMessage(), e);
        }
    }
    
    /**
     * Obtiene un tipo de mesa por su ID.
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
}

