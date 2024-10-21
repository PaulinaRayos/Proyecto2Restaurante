/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import conexion.Conexion;
import conexion.IConexion;
import dao.ClienteDAO;
import entidadesJPA.Cliente;
import excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chris
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente c = new Cliente();

        IConexion i = new Conexion();

        ClienteDAO cdao = new ClienteDAO(i);

        try {
            cdao.insercionMasiva();
        } catch (PersistenciaException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
