/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.MesaDTO;
import dto.TipoMesaDTO;
import excepciones.NegocioException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Chris
 */
public interface IMesaBO {

    List<MesaDTO> obtenerTodasLasMesas() throws NegocioException;

    BigDecimal obtenerCostoPorIdMesa(Long idMesa) throws NegocioException;

    void inicializarTiposMesaPredeterminados() throws NegocioException;

    List<TipoMesaDTO> obtenerTiposMesa() throws NegocioException;

    MesaDTO obtenerMesaPorId(Long idMesa) throws NegocioException;
}
