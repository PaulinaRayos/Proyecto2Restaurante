/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidadesJPA.HorarioMesa;
import java.util.List;

/**
 *
 * @author pauli
 */
public interface IHorarioMesaDAO {

    // Método para crear un nuevo HorarioMesa
    void crearHorarioMesa(HorarioMesa horarioMesa);

    // Método para obtener todos los HorarioMesa
    List<HorarioMesa> horarioMesaTodos();

    // Método para buscar un HorarioMesa por su ID
    HorarioMesa horarioMesaPorId(Long id);

    // Método para actualizar un HorarioMesa
    void actualizarHorarioMesa(HorarioMesa horarioMesa);
    
}
