/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 * Clase que representa una excepción específica para manejar errores
 * relacionados con la persistencia de datos en la aplicación.
 * 
 * Esta excepción puede ser lanzada durante operaciones que implican
 * la interacción con la base de datos, como crear, leer, actualizar o
 * eliminar entidades. Proporciona varios constructores que permiten
 * especificar mensajes y causas para una mayor claridad en la gestión
 * de errores.
 * Contribuciones de Paulina Rodríguez Rodríguez Rayos.
 * 
 * @author Cristopher Alberto Elizalde Andrade - 240005
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor vacío.
     */
    public PersistenciaException() {
    }

    /**
     * Constructor que establece el mensaje de la excepción.
     *
     * @param message de la excepción.
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Constructor que establece el mensaje y la causa de la excepción.
     *
     * @param message de la excepción.
     * @param cause de la excepción.
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor que establece la causa de la excepción.
     *
     * @param cause de la excepción
     */
    public PersistenciaException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor que establece el mensaje, la causa, y otros atributos de la
     * excepción.
     *
     * @param message El mensaje descriptivo de la excepción.
     * @param cause La causa de la excepción.
     * @param enableSuppression Indica si la supresión de excepciones está
     * habilitada o no.
     * @param writableStackTrace Indica si se debe escribir el stack trace en la
     * salida estándar de error.
     */
    public PersistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
