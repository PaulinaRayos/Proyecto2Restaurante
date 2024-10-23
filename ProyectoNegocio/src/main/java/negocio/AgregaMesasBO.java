/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import conexion.Conexion;
import conexion.IConexion;
import dao.MesaDAO;
import dto.MesaDTO;
import dto.RestauranteDTO;
import entidadesJPA.Mesa;
import entidadesJPA.TipoMesa;
import excepciones.NegocioException;
import interfaces.IMesaDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chris
 */
public class AgregaMesasBO {

    private final IConexion conexion;
    private IMesaDAO mesaDAO;

    public AgregaMesasBO() {
        this.conexion = new Conexion();
        this.mesaDAO = new MesaDAO(conexion);
    }

    public void insertarMesas(List<MesaDTO> mesasDTO) throws NegocioException {
        List<Mesa> mesas = new ArrayList<>();

        try {
            // Convertir cada MesaDTO en una entidad Mesa
            for (MesaDTO mesaDTO : mesasDTO) {
                Mesa mesa = new Mesa();
                mesa.setCodigoMesa(mesaDTO.getCodigoMesa());
                mesa.setUbicacion(mesaDTO.getUbicacion());
                mesa.setCapacidad(mesaDTO.getCapacidad());

                // Convertir el TipoMesaDTO a TipoMesa entidad
//                TipoMesa tipoMesa = obtenerTipoMesaPorNombre(mesaDTO.getIdTipoMesa().getNombreTipo());
//                mesa.setTipoMesa(tipoMesa);

//                Restaurante restaurante = obtenerRestaurantePorId(mesaDTO.getIdRestaurante());
//                mesa.setRestaurante(restaurante);

                // Agregar la entidad Mesa a la lista de entidades
                mesas.add(mesa);
            }

            // Llamar a la capa de persistencia para insertar las mesas
            mesaDAO.insertarMesas(mesas);

        } catch (Exception e) {
            throw new NegocioException("Error al insertar mesas", e);
        }
    }
}
