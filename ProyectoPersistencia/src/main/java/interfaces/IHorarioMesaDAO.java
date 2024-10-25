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
    void create(HorarioMesa horarioMesa);

    // Método para obtener todos los HorarioMesa
    List<HorarioMesa> findAll();

    // Método para buscar un HorarioMesa por su ID
    HorarioMesa findById(Long id);
    
}
