/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import conexion.Conexion;
import conexion.IConexion;
import conversiones.ConvertidorGeneral;
import dao.MesaDAO;
import dao.RestauranteDAO;
import dao.TipoMesaDAO;
import dto.MesaDTO;
import dto.RestauranteDTO;
import entidadesJPA.Mesa;
import entidadesJPA.Restaurante;
import entidadesJPA.TipoMesa;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IAgregaMesasBO;
import interfaces.IMesaDAO;
import interfaces.IRestauranteBO;
import interfaces.IRestauranteDAO;
import interfaces.ITipoMesaDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author Chris
 */
public class AgregaMesasBO implements IAgregaMesasBO {

    private final IConexion conexion;
    private IMesaDAO mesaDAO;
    private IRestauranteDAO restdao;
    private ITipoMesaDAO tipodao;
    private IRestauranteBO restbo;

    public AgregaMesasBO() {
        this.conexion = new Conexion();
        this.mesaDAO = new MesaDAO(conexion);
        this.restdao = new RestauranteDAO(conexion);
        this.tipodao = new TipoMesaDAO(conexion);
        this.restbo = new RestauranteBO();
    }

    public void agregarMesas(RestauranteDTO restauranteDTO, Map<String, Integer> cantidadPorTipo, String ubicacion) throws NegocioException {
        try {
            // Buscar el restaurante actual
            Restaurante restaurante = restdao.obtenerPorId(restauranteDTO.getId());

            // Número único para las mesas
            Long numeroUnico = mesaDAO.obtenerCantidadDeMesas() + 1; // Este método debe retornar la cantidad actual de mesas

            // Iterar por cada tipo de mesa
            for (Map.Entry<String, Integer> entry : cantidadPorTipo.entrySet()) {
                String nombreTipo = entry.getKey();
                int cantidad = entry.getValue();

                // Obtener el tipo de mesa por nombre
                TipoMesa tipoMesa = tipodao.obtenerPorNombre(nombreTipo);

                // Determinar la capacidad basada en el tipo de mesa
                int capacidadMesa;
                switch (nombreTipo) {
                    case "Mesa pequeña":
                        capacidadMesa = 2;
                        break;
                    case "Mesa mediana":
                        capacidadMesa = 4;
                        break;
                    case "Mesa grande":
                        capacidadMesa = 8;
                        break;
                    default:
                        throw new NegocioException("Tipo de mesa no reconocido: " + nombreTipo);
                }

                // Generar mesas según la cantidad
                for (int i = 0; i < cantidad; i++) {
                    Mesa mesa = new Mesa();

                    // Generar el código de la mesa usando la capacidad y un número único
                    String codigoMesa = generarCodigoMesa(ubicacion, capacidadMesa, numeroUnico);
                    mesa.setCapacidad(capacidadMesa);
                    mesa.setCodigoMesa(codigoMesa);
                    mesa.setUbicacion(ubicacion);
                    mesa.setTipoMesa(tipoMesa);
                    mesa.setRestaurante(restaurante);

                    // Guardar la mesa
                    mesaDAO.agregarMesa(mesa);

                    // Incrementar el número único para la siguiente mesa
                    numeroUnico++;
                }
            }
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al agregar mesas", e);
        }
    }

    private String generarCodigoMesa(String ubicacion, int capacidad, Long numeroUnico) {
        // Tomar las tres primeras letras de la ubicación
        String ubicacionCodificada = ubicacion.length() >= 3 ? ubicacion.substring(0, 3).toUpperCase() : ubicacion.toUpperCase();

        // Formatear el número único en tres dígitos
        String numeroFormato = String.format("%03d", numeroUnico);

        // Retornar el código de mesa en el formato requerido
        return ubicacionCodificada + "-" + capacidad + "-" + numeroFormato;
    }

}
