/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import conexion.Conexion;
import conexion.IConexion;
import dao.MesaDAO;
import dao.TipoMesaDAO;
import entidadesJPA.Mesa;
import entidadesJPA.TipoMesa;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IConsultarTipoMesaBO;
import interfaces.IMesaDAO;
import interfaces.ITipoMesaDAO;

/**
 * Clase que implementa la lógica de negocio para consultar información sobre
 * tipos de mesa en el sistema.
 *
 * @author pauli
 */
public class ConsultarTipoMesaBO implements IConsultarTipoMesaBO {

    private final IConexion conexion; // Interfaz para la conexión a la base de datos
    private final ITipoMesaDAO tipodao; // DAO para operaciones con tipos de mesa
    private final IMesaDAO mesadao; // DAO para operaciones con mesas

    /**
     * Constructor que inicializa las conexiones y DAOs necesarios.
     */
    public ConsultarTipoMesaBO() {
        this.conexion = new Conexion(); // Inicializa la conexión a la base de datos
        this.mesadao = new MesaDAO(conexion); // Inicializa el DAO de mesas
        this.tipodao = new TipoMesaDAO(conexion); // Inicializa el DAO de tipos de mesa
    }

    /**
     * Método para obtener el nombre del tipo de mesa asociado a una mesa dada
     * su ID.
     *
     * @param idMesa El ID de la mesa para la que se desea obtener el nombre del
     * tipo de mesa.
     * @return El nombre del tipo de mesa si se encuentra, o null si no se
     * encuentra la mesa o el tipo de mesa.
     * @throws NegocioException Si ocurre un error en la capa de persistencia.
     */
    @Override
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
