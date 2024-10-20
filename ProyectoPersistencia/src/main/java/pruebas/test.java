/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import dao.ClienteDAO;
import entidadesJPA.Cliente;

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

        ClienteDAO cdao = new ClienteDAO();

        cdao.insercionMasiva();
    }

}
