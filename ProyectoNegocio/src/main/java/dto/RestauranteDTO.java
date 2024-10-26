/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pauli
 */
public class RestauranteDTO {

    private Long id;
    private String ciudad;
    private String direccion;
    private List<MesaDTO> mesas;

    public RestauranteDTO() {
        this.mesas = new ArrayList();
    }

    public RestauranteDTO(Long id, String ciudad, String direccion, List<MesaDTO> mesas) {
        this.id = id;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.mesas = mesas;
    }

    public RestauranteDTO(String ciudad, String direccion, List<MesaDTO> mesas) {
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.mesas = mesas;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<MesaDTO> getMesas() {
        return mesas;
    }

    public void setMesas(List<MesaDTO> mesas) {
        this.mesas = mesas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RestauranteDTO{");
        sb.append("id=").append(id);
        sb.append(", ciudad=").append(ciudad);
        sb.append(", direccion=").append(direccion);
        sb.append(", mesas=").append(mesas);
        sb.append('}');
        return sb.toString();
    }

}
