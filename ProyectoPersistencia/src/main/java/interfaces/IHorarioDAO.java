/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidadesJPA.Horario;
import java.util.List;

/**
 *
 * @author pauli
 */
public interface IHorarioDAO {

    // Método para obtener todos los HorarioMesa
    List<Horario> findAll();

    // Método para buscar un HorarioMesa por su ID
    Horario findById(Long id);

    // Método para crear un nuevo Horario
    void save(Horario horario);
    
}
