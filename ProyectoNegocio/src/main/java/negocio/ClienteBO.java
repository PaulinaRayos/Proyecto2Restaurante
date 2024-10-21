/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import conexion.Conexion;
import conexion.IConexion;
import dao.ClienteDAO;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IClienteBO;
import interfaces.IClienteDAO;

/**
 *
 * @author Chris
 */
public class ClienteBO implements IClienteBO {

    private final IConexion conexion;
    private IClienteDAO cdao;

    public ClienteBO() {
        this.conexion = new Conexion();
        this.cdao = new ClienteDAO(conexion);
    }

    @Override
    public void insercionMasiva() throws NegocioException {
        try {
            this.cdao.insercionMasiva();
        } catch (PersistenciaException e) {
            throw new NegocioException("No se ha podido realizar la insercion masiva.");
        }
    }

}
