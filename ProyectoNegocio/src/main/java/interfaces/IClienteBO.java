/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.ClienteDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Chris
 */
public interface IClienteBO {

    void insercionMasiva() throws NegocioException;
    
    List<Object[]> obtenerNombresYTelefonosDeClientes() throws NegocioException;
    
    Long obtenerIdClientePorNombre(String nombreCompleto) throws NegocioException;
    
    ClienteDTO obtenerClientePorNombre(String nombreCompleto);
    
    ClienteDTO obtenerClientePorId(Long id) throws NegocioException;

    List<String> obtenerTelefonosDesencriptados() throws NegocioException;

    List<ClienteDTO> obtenerTodosLosClientes() throws NegocioException;

    List<ClienteDTO> obtenerTodosLosClientesConTelefonoDesencriptado() throws NegocioException;
}
