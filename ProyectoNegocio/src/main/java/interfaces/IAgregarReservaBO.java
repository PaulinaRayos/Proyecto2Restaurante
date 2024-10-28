/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.ReservaDTO;

/**
 * Interfaz que define la lógica de negocio para la gestión de reservas en un
 * restaurante. Esta interfaz proporciona el contrato para la implementación de
 * métodos que permiten agregar nuevas reservas a la base de datos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public interface IAgregarReservaBO {

    /**
     * Método para agregar una nueva reserva a la base de datos. Valida que los
     * IDs del cliente y la mesa no sean nulos, carga la información del cliente
     * y la mesa desde la base de datos, y persiste la nueva reserva.
     *
     * @param reservaDTO Objeto que contiene la información de la reserva a
     * agregar.
     * @throws Exception Si ocurre un error al agregar la reserva o si el
     * cliente o mesa no se encuentran.
     */
    void agregarReserva(ReservaDTO reservaDTO) throws Exception;

}
