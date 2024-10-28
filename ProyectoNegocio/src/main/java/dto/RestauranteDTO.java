/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un Data Transfer Object (DTO) para un restaurante. Se
 * utiliza para transferir datos sobre los restaurantes, incluyendo su
 * identificación, ciudad, dirección y mesas asociadas.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class RestauranteDTO {

    private Long id; // Identificador único del restaurante
    private String ciudad; // Ciudad donde se ubica el restaurante
    private String direccion; // Dirección del restaurante
    private List<MesaDTO> mesas; // Lista de mesas asociadas al restaurante

    /**
     * Constructor vacío para crear un objeto RestauranteDTO sin parámetros
     * iniciales. Inicializa la lista de mesas como una nueva ArrayList.
     */
    public RestauranteDTO() {
        this.mesas = new ArrayList<>();
    }

    /**
     * Constructor con parámetros para crear un objeto RestauranteDTO. Se
     * utiliza cuando se tiene la información completa del restaurante.
     *
     * @param id Identificador único del restaurante.
     * @param ciudad Ciudad donde se ubica el restaurante.
     * @param direccion Dirección del restaurante.
     * @param mesas Lista de mesas asociadas al restaurante.
     */
    public RestauranteDTO(Long id, String ciudad, String direccion, List<MesaDTO> mesas) {
        this.id = id;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.mesas = mesas;
    }

    /**
     * Constructor con parámetros para crear un objeto RestauranteDTO sin un
     * identificador específico.
     *
     * @param ciudad Ciudad donde se ubica el restaurante.
     * @param direccion Dirección del restaurante.
     * @param mesas Lista de mesas asociadas al restaurante.
     */
    public RestauranteDTO(String ciudad, String direccion, List<MesaDTO> mesas) {
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.mesas = mesas;
    }

    // Getters y Setters
    /**
     * Obtiene el identificador único del restaurante.
     *
     * @return El identificador del restaurante.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del restaurante.
     *
     * @param id Identificador único del restaurante.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la ciudad donde se ubica el restaurante.
     *
     * @return La ciudad del restaurante.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad donde se ubica el restaurante.
     *
     * @param ciudad Ciudad donde se ubica el restaurante.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene la dirección del restaurante.
     *
     * @return La dirección del restaurante.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del restaurante.
     *
     * @param direccion Dirección del restaurante.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene la lista de mesas asociadas al restaurante.
     *
     * @return Lista de mesas del restaurante.
     */
    public List<MesaDTO> getMesas() {
        return mesas;
    }

    /**
     * Establece la lista de mesas asociadas al restaurante.
     *
     * @param mesas Lista de mesas asociadas al restaurante.
     */
    public void setMesas(List<MesaDTO> mesas) {
        this.mesas = mesas;
    }

    /**
     * Representación en forma de cadena del restaurante, utilizada para mostrar
     * en componentes de interfaz gráfica.
     *
     * @return Una representación más legible del restaurante.
     */
    @Override
    public String toString() {
        return ciudad + " - " + direccion; // Representación más legible para el ComboBox
    }
}
