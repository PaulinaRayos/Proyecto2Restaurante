/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.NegocioException;

/**
 *
 * @author pauli
 */
public interface IConsultarTipoMesaBO {

    String obtenerNombreTipoMesaPorIdMesa(Long idMesa) throws NegocioException;
    
}
