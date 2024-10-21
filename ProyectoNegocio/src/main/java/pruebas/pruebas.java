/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

/**
 *
 * @author pauli
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        pruebaReservaBO prueba = new pruebaReservaBO();

        try {
            prueba.setUp(); // Inicializa los DAOs y el ReservaBO
            prueba.testAgregarReserva();
        } catch (Exception e) {
        }
//        
//        try {
//            prueba.setUp(); // Inicializa los DAOs y el ReservaBO
//            prueba.testActualizarReserva(); // Ejecuta la prueba de agregar reserva
//        } catch (Exception e) {
//            System.err.println("Error durante la prueba: " + e.getMessage());
//            e.printStackTrace();
//        }
    }

}
