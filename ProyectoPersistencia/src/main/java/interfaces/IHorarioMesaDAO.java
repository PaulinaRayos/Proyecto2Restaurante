/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidadesJPA.HorarioMesa;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad
 * HorarioMesa. Proporciona métodos para realizar operaciones de creación, lectura,
 * actualización y eliminación (CRUD) de HorariosMesa en la base de datos.
 * Contribuciones de Paulina Rodríguez Rodríguez Rayos.
 * 
 * @author Cristopher Alberto Elizalde Andrade - 240005
 */
public interface IHorarioMesaDAO {

    /**
     * Actualiza un horario de mesa existente en la base de datos.
     *
     * @param horarioMesa El objeto HorarioMesa a actualizar.
     */
    void actualizarHorarioMesa(HorarioMesa horarioMesa);

    /**
     * Busca un horario de mesa en la base de datos. Este método devuelve un
     * {@link Optional} que contiene un horario de mesa si se encuentra uno, o
     * un {@link Optional#empty()} si no hay horarios de mesa disponibles.
     *
     * @return Un Optional que contiene el primer HorarioMesa encontrado en la
     * base de datos o Optional.empty() si no se encontró ninguno.
     */
    Optional<HorarioMesa> buscarHorarioMesa();

    /**
     * Crea un nuevo horario de mesa en la base de datos.
     *
     * @param horarioMesa El objeto HorarioMesa a crear.
     */
    void crearHorarioMesa(HorarioMesa horarioMesa);

    /**
     * Busca un horario de mesa por su ID.
     *
     * @param id El ID del horario de mesa a buscar.
     * @return El objeto HorarioMesa correspondiente al ID proporcionado, o null
     * si no se encuentra.
     */
    HorarioMesa horarioMesaPorId(Long id);

    /**
     * Obtiene todos los horarios de mesa de la base de datos.
     *
     * @return Una lista de todos los objetos HorarioMesa.
     */
    List<HorarioMesa> horarioMesaTodos();

    /**
     * Busca un horario de mesa y devuelve uno si existe, o crea uno nuevo si
     * no.
     *
     * @return El HorarioMesa existente o uno nuevo si no se encuentra ninguno.
     */
    HorarioMesa obtenerOcrearHorarioMesa();

    
}
