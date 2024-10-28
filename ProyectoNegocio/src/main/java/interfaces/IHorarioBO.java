/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.HorarioDTO;
import entidadesJPA.Horario;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Chris
 */
public interface IHorarioBO {
    
    HorarioDTO obtenerHorarioPorId(Long idRestaurante) throws NegocioException;
    
    List<HorarioDTO> obtenerDiasAsignadosParaRestaurante(Long restauranteId);

    List<Long> obtenerIdsHorariosPorIdRestaurante(Long idRestaurante) throws NegocioException;

    Horario obtenerHorarioPorIdHorario(Long idHorario) throws NegocioException;
}
