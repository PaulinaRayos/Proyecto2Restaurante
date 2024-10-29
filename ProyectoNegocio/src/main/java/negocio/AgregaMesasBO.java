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
import entidadesJPA.Horario;
import entidadesJPA.HorarioMesa;
import entidadesJPA.Mesa;
import entidadesJPA.Restaurante;
import entidadesJPA.TipoMesa;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IAgregaMesasBO;
import interfaces.IHorarioBO;
import interfaces.IHorarioMesaBO;
import interfaces.IMesaDAO;
import interfaces.IRestauranteDAO;
import interfaces.ITipoMesaDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Constructor por defecto de la clase AgregaMesasBO. Inicializa una nueva
 * instancia del gestor de mesas.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class AgregaMesasBO implements IAgregaMesasBO {

    private final IConexion conexion;
    private final IMesaDAO mesaDAO;
    private final IRestauranteDAO restdao;
    private final ITipoMesaDAO tipodao;
    private final IHorarioBO horariobo;
    private final IHorarioMesaBO horarioMesabo;

    /**
     * Constructor por defecto de la clase AgregaMesasBO. Inicializa una nueva
     * instancia del gestor de mesas.
     */
    public AgregaMesasBO() {
        this.conexion = new Conexion();
        this.mesaDAO = new MesaDAO(conexion);
        this.restdao = new RestauranteDAO(conexion);
        this.tipodao = new TipoMesaDAO(conexion);
        this.horariobo = new HorarioBO();
        this.horarioMesabo = new HorarioMesaBO();
    }

    /**
     * Agrega mesas al restaurante especificado en el objeto RestauranteDTO.
     * Valida que el restaurante exista y que el ID no sea nulo. Para cada tipo
     * de mesa y la cantidad solicitada, se generan las mesas y se persisten en
     * la base de datos.
     *
     * @param restauranteDTO Objeto que contiene la información del restaurante
     * al que se agregarán las mesas.
     * @param cantidadPorTipo Mapa que asocia nombres de tipos de mesa con la
     * cantidad solicitada para cada tipo.
     * @param ubicacion Cadena que indica la ubicación de las mesas (ej.
     * "Terraza").
     * @throws NegocioException Si ocurre un error al agregar mesas o si el
     * restaurante no se encuentra.
     */
    @Override
    public void agregarMesas(RestauranteDTO restauranteDTO, Map<String, Integer> cantidadPorTipo, String ubicacion) throws NegocioException {
        List<Long> listaIdsMesas = new ArrayList<>();
        try {
            // Validar que el restauranteDTO no sea nulo
            if (restauranteDTO == null || restauranteDTO.getId() == null) {
                throw new IllegalArgumentException("El ID del restaurante no puede ser nulo.");
            }

            // Cargar el restaurante desde la base de datos
            Restaurante restaurante = restdao.obtenerPorId(restauranteDTO.getId());
            if (restaurante == null) {
                throw new NegocioException("Restaurante no encontrado con ID: " + restauranteDTO.getId());
            }

            // Número único para las mesas
            Long numeroUnico = mesaDAO.obtenerCantidadDeMesas() + 1; // Este método debe retornar la cantidad actual de mesas
            List<Long> listaHorarios = horariobo.obtenerIdsHorariosPorIdRestaurante(restaurante.getId());
            // Iterar por cada tipo de mesa para agregar la cantidad solicitada
            for (Map.Entry<String, Integer> entry : cantidadPorTipo.entrySet()) {
                String nombreTipo = entry.getKey();
                int cantidad = entry.getValue();

                // Obtener el tipo de mesa por nombre
                TipoMesa tipoMesa = tipodao.obtenerPorNombre(nombreTipo);
                if (tipoMesa == null) {
                    throw new NegocioException("Tipo de mesa no encontrado: " + nombreTipo);
                }

                // Determinar la capacidad basada en el tipo de mesa
                int capacidadMin = 0;
                int capacidadMax = 0;
                switch (nombreTipo) {
                    case "Mesa pequeña":
                        capacidadMin = 1;
                        capacidadMax = 2;
                        break;
                    case "Mesa mediana":
                        capacidadMin = 3;
                        capacidadMax = 4;
                        break;
                    case "Mesa grande":
                        capacidadMin = 5;
                        capacidadMax = 8;
                        break;
                    default:
                        throw new NegocioException("Tipo de mesa no reconocido: " + nombreTipo);
                }

                // Generar mesas según la cantidad
                for (int i = 0; i < cantidad; i++) {
                    // Crear MesaDTO para convertirlo después en entidad Mesa
                    MesaDTO mesaDTO = new MesaDTO();

                    mesaDTO.setCapacidad(capacidadMax);
                    mesaDTO.setCodigoMesa(generarCodigoMesa(ubicacion, capacidadMax, numeroUnico));
                    mesaDTO.setUbicacion(ubicacion);
                    mesaDTO.setIdTipoMesa(tipoMesa.getId()); // Suponiendo que en el DTO el tipo es String
                    mesaDTO.setIdRestaurante(restauranteDTO.getId());

                    // Convertir el DTO en entidad
                    Mesa mesa = ConvertidorGeneral.convertidorEntidad(mesaDTO, Mesa.class);
                    mesa.setRestaurante(restaurante); // Asignar el restaurante a la mesa
                    mesa.setTipoMesa(tipoMesa);

                    // Persistir la mesa usando el DAO
                    long idMesa = mesaDAO.agregarMesa(mesa);
                    listaIdsMesas.add(idMesa);
                    // Incrementar el número único para la siguiente mesa
                    numeroUnico++;
                }
            }
            agregarMesasAHorarios(listaIdsMesas, listaHorarios);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al agregar mesas", e);
        }
    }

    /**
     * Genera un código único para una mesa basado en su ubicación, capacidad y
     * un número único.
     *
     * @param ubicacion La ubicación de la mesa (ej. "Terraza").
     * @param capacidad La capacidad de la mesa (número de personas que puede
     * acomodar).
     * @param numeroUnico Un número único que se incrementa para cada mesa
     * nueva.
     * @return Un código de mesa en el formato "LOC-CAP-NNN" donde LOC son las
     * primeras tres letras de la ubicación, CAP es la capacidad y NNN es el
     * número único formateado.
     */
    private String generarCodigoMesa(String ubicacion, int capacidad, Long numeroUnico) {
        // Tomar las tres primeras letras de la ubicación
        String ubicacionCodificada = ubicacion.length() >= 3 ? ubicacion.substring(0, 3).toUpperCase() : ubicacion.toUpperCase();

        // Formatear el número único en tres dígitos
        String numeroFormato = String.format("%03d", numeroUnico);

        // Retornar el código de mesa en el formato requerido
        return ubicacionCodificada + "-" + capacidad + "-" + numeroFormato;
    }

    /**
     * Asocia las mesas agregadas con sus horarios correspondientes en la base
     * de datos.
     *
     * @param idsMesas Lista de IDs de las mesas que se han agregado.
     * @param idsHorarios Lista de IDs de los horarios a los que se asociarán
     * las mesas.
     * @throws NegocioException Si ocurre un error al agregar mesas a horarios o
     * si alguna mesa u horario no se encuentra.
     */
    private void agregarMesasAHorarios(List<Long> idsMesas, List<Long> idsHorarios) throws NegocioException {
        try {
            for (Long idMesa : idsMesas) {
                // Obtener la mesa usando el ID
                Mesa mesa = mesaDAO.obtenerMesaPorId(idMesa);
                if (mesa == null) {
                    throw new NegocioException("Mesa no encontrada con ID: " + idMesa);
                }

                for (Long idHorario : idsHorarios) {
                    // Obtener el horario usando el ID
                    Horario horario = horariobo.obtenerHorarioPorIdHorario(idHorario);
                    if (horario == null) {
                        throw new NegocioException("Horario no encontrado con ID: " + idHorario);
                    }

                    // Crear la instancia de HorarioMesa
                    HorarioMesa horarioMesa = new HorarioMesa();
                    horarioMesa.setMesa(mesa);
                    horarioMesa.setHorario(horario);

                    // Persistir la relación
                    horarioMesabo.crearHorarioMesa(horarioMesa);
                }
            }
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al agregar mesas a horarios: " + e.getMessage(), e);
        }
    }

}
