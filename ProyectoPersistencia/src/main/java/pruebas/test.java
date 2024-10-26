/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import conexion.Conexion;
import conexion.IConexion;
import dao.ClienteDAO;
import dao.RestauranteDAO;
import entidadesJPA.Cliente;
import excepciones.PersistenciaException;
import java.util.List;
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

        IConexion i = new Conexion();

        // Crea una instancia del DAO
        RestauranteDAO restauranteDAO = new RestauranteDAO(i);

        try {
            // Llama al método que quieres probar
            List<Object[]> resultados = restauranteDAO.buscarCiudadesYDireccionesRestaurantes();

            // Imprime los resultados
            if (resultados.isEmpty()) {
                System.out.println("No se encontraron restaurantes.");
            } else {
                System.out.println("Restaurantes encontrados:");
                for (Object[] resultado : resultados) {
                    String ciudad = (String) resultado[0];
                    String direccion = (String) resultado[1];
                    System.out.println("Ciudad: " + ciudad + ", Dirección: " + direccion);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

    }

}
