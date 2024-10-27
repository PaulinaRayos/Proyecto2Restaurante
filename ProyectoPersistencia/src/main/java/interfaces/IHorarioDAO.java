/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidadesJPA.Horario;
import excepciones.PersistenciaException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author pauli
 */
public interface IHorarioDAO {

    // Método para obtener todos los HorarioMesa
    List<Horario> HorarioTodos();

    // Método para buscar un HorarioMesa por su ID
    Horario HorarioPorId(Long id);

    // Método para crear un nuevo Horario
    void crearHorario(Horario horario)throws PersistenciaException;

    // Método para actualizar un Horario
    void actualizarHorario(Horario horario);

    Optional<Horario> buscarPorDiaSemana(String diaSemana);
    
    Horario obtenerHorarioPorIdRestaurante(Long idRestaurante) throws PersistenciaException;

}
