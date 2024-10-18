/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
/**
 *  * @author Sebastian
 * Excepción personalizada para errores relacionados con los servicios.
 * Esta excepción se lanza cuando se produce un error en la creación o manejo de un servicio.
 */
public class ServicioException extends RuntimeException {
    
    /**
     * Constructor de la excepción que acepta un mensaje personalizado.
     * 
     * @param mensaje El mensaje de error asociado a la excepción.
     */
    public ServicioException(String mensaje) {
        super(mensaje);
    }
}
