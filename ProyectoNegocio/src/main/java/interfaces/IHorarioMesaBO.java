/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidadesJPA.HorarioMesa;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author pauli
 */
public interface IHorarioMesaBO {

    void crearHorarioMesa(HorarioMesa horarioMesa) throws NegocioException;

    List<HorarioMesa> obtenerHorariosPorMesa(Long idMesa);
    
}
