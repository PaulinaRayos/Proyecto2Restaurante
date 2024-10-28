/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 * Clase que representa un Data Transfer Object (DTO) para la entidad Cliente.
 * Se utiliza para transferir datos de clientes entre la capa de presentación y
 * la capa de negocio.
 *
 * Esta clase incluye atributos para almacenar la información del cliente, así
 * como constructores, getters y setters para acceder y modificar los datos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class ClienteDTO {

    private Long idCliente; // Identificador único del cliente
    private String nombre; // Nombre del cliente
    private String apellidoPaterno; // Apellido paterno del cliente
    private String apellidoMaterno; // Apellido materno del cliente
    private String telefono; // Número de teléfono del cliente

    /**
     * Constructor vacío para crear un objeto ClienteDTO sin parámetros
     * iniciales. Se utiliza cuando los datos del cliente aún no están
     * disponibles.
     */
    public ClienteDTO() {
    }

    /**
     * Constructor con parámetros para crear un objeto ClienteDTO. Se utiliza
     * cuando se tiene la información del cliente.
     *
     * @param idCliente Identificador único del cliente.
     * @param nombre Nombre del cliente.
     * @param apellidoPaterno Apellido paterno del cliente.
     * @param apellidoMaterno Apellido materno del cliente.
     * @param telefono Número de teléfono del cliente.
     */
    public ClienteDTO(Long idCliente, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
    }

    /**
     * Obtiene el identificador único del cliente.
     *
     * @return El id del cliente.
     */
    public Long getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el identificador único del cliente.
     *
     * @param idCliente El nuevo id del cliente.
     */
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre El nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del cliente.
     *
     * @return El apellido paterno del cliente.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del cliente.
     *
     * @param apellidoPaterno El nuevo apellido paterno del cliente.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del cliente.
     *
     * @return El apellido materno del cliente.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del cliente.
     *
     * @param apellidoMaterno El nuevo apellido materno del cliente.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene el número de teléfono del cliente.
     *
     * @return El número de teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del cliente.
     *
     * @param telefono El nuevo número de teléfono del cliente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
