/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import conexion.Conexion;
import conexion.IConexion;
import dao.MesaDAO;
import dao.TipoMesaDAO;
import dto.MesaDTO;
import dto.TipoMesaDTO;
import entidadesJPA.Mesa;
import entidadesJPA.TipoMesa;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IConsultarTipoMesaBO;
import interfaces.IMesaDAO;
import interfaces.ITipoMesaDAO;

/**
 *
 * @author pauli
 */
public class ConsultarTipoMesaBO implements IConsultarTipoMesaBO{

    private final IConexion conexion;
    private ITipoMesaDAO tipodao;
    private IMesaDAO mesadao;

    public ConsultarTipoMesaBO() {
        this.conexion = new Conexion();
        this.mesadao = new MesaDAO(conexion);
        this.tipodao = new TipoMesaDAO(conexion);
    }

    public String obtenerNombreTipoMesaPorIdMesa(Long idMesa) throws NegocioException {
        try {
            // Obtén la mesa usando su ID
            Mesa mesa = mesadao.obtenerMesaPorId(idMesa);

            // Verifica si la mesa existe
            if (mesa != null) {
                // Obtiene el tipo de mesa usando el ID del tipo de mesa de la mesa
                TipoMesa tipoMesa = tipodao.obtenerTipoMesaPorId(mesa.getTipoMesa().getId()); 
                // Verifica si el tipo de mesa existe y retorna su nombre
                if (tipoMesa != null) {
                    return tipoMesa.getNombreTipo();
                }
            }
            return null; // Retorna null si no se encuentra la mesa o el tipo
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener el nombre del tipo de mesa: " + e.getMessage(), e);
        }
    }

}
