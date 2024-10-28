
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import conexion.Conexion;
import conexion.IConexion;
import dao.ClienteDAO;
import dao.MesaDAO;
import dao.ReservaDAO;
import dto.ReservaDTO;
import entidadesJPA.Cliente;
import entidadesJPA.Mesa;
import entidadesJPA.Reserva;
import interfaces.IMesaDAO;
import interfaces.IClienteDAO;
import interfaces.IReservaDAO;
import interfaces.IAgregarReservaBO;
import java.util.Date;

/**
 * Clase que implementa la lógica de negocio para la gestión de reservas en un
 * restaurante. Se encarga de agregar nuevas reservas a la base de datos y
 * validar la información proporcionada.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class AgregarReservaBO implements IAgregarReservaBO {

    private final IConexion conexion; // Interfaz para la conexión a la base de datos
    private final IReservaDAO reservaDAO; // Interfaz para las operaciones relacionadas con reservas
    private final IMesaDAO mesaDAO; // Interfaz para las operaciones relacionadas con mesas
    private final IClienteDAO clienteDAO; // Interfaz para las operaciones relacionadas con clientes

    /**
     * Constructor de la clase AgregarReservaBO. Inicializa las interfaces
     * necesarias para la conexión y el acceso a los datos.
     */
    public AgregarReservaBO() {
        this.conexion = new Conexion();
        this.reservaDAO = new ReservaDAO(conexion);
        this.mesaDAO = new MesaDAO(conexion);
        this.clienteDAO = new ClienteDAO(conexion);
    }

    /**
     * Método para agregar una nueva reserva a la base de datos. Valida que los
     * IDs del cliente y la mesa no sean nulos, carga la información del cliente
     * y la mesa desde la base de datos, y persiste la nueva reserva.
     *
     * @param reservaDTO Objeto que contiene la información de la reserva a
     * agregar.
     * @throws Exception Si ocurre un error al agregar la reserva o si el
     * cliente o mesa no se encuentran.
     */
    @Override
    public void agregarReserva(ReservaDTO reservaDTO) throws Exception {

        if (reservaDTO.getIdCliente() == null || reservaDTO.getIdMesa() == null) {
            throw new IllegalArgumentException("El ID del cliente y la mesa no pueden ser nulos.");
        }

        // Crear objeto de reserva a partir de DTO
        Reserva reserva = new Reserva();
        reserva.setFechaHora(reservaDTO.getFechaHora());
        reserva.setNumPersonas(reservaDTO.getNumeroPersonas());
        reserva.setCosto(reservaDTO.getCosto()); // Suponiendo que tienes un costo calculado
        reserva.setEstado(reservaDTO.getEstado()); // Estado inicial de la reserva

        Date fechaCreada = new Date();
        reserva.setFechaHoraCreada(fechaCreada);

        // Cargar el cliente desde la base de datos
        Cliente cliente = clienteDAO.obtenerClientePorId(reservaDTO.getIdCliente());
        if (cliente == null) {
            throw new Exception("Cliente no encontrado con ID: " + reservaDTO.getIdCliente());
        }
        reserva.setCliente(cliente); // Asignar el cliente cargado a la reserva

        // Cargar la mesa desde la base de datos
        Mesa mesa = mesaDAO.obtenerMesaPorId(reservaDTO.getIdMesa());
        if (mesa == null) {
            throw new Exception("Mesa no encontrada con ID: " + reservaDTO.getIdMesa());
        }
        reserva.setMesa(mesa); // ID de la mesa

        try {
            // Persistir la reserva usando el DAO
            reservaDAO.agregarReserva(reserva);
        } catch (Exception e) {
            // Manejo de la excepción (puedes propagarla o manejarla según tu lógica)
            System.out.println("Error al crear la reserva: " + e.getMessage());
            throw new Exception("No se pudo crear la reserva.", e);
        }

    }

}
