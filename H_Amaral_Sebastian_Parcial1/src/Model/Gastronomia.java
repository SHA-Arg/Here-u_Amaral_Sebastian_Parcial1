/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Sebastian
 * 
 * Clase Gastronomia que extiende de Servicio.
 * Representa un servicio de gastronomía y contiene información específica sobre descuentos y promociones.
 */
public class Gastronomia extends Servicio{
     // Atributos específicos de Gastronomia 
    private String gastronomia;
    private double precio;
    private int diaSemDesc;
    /**
     * Constructor de la clase Gastronomia.
     * Verifica que el codServicio sea válido antes de asignarlo.
     * 
     * @param codServicio Código único del servicio.
     * @param gastronomia Nombre del servicio de gastronomía.
     * @param precio Precio del servicio.
     * @param diaSemDesc Día de la semana para el descuento.
     * @param porcentajeDescuento Porcentaje de descuento aplicado.
     * @param enPromocion Indica si el servicio está en promoción.
     * @throws ServicioException Si el codServicio no es válido.
     */
   public Gastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws Exception {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
    }

   @Override
    public double calcularPrecioFinal(java.time.LocalDate dia) {
        // Aplicar descuento si está en promoción y es el día especificado
        if (estaEnPromocion() && dia.getDayOfWeek().getValue() == diaSemDesc) {
            return precio - (precio * getPorcentajeDescuento() / 100);
        }
        return precio;
    }

    // Getters y Setters
    public String getGastronomia() {
        return gastronomia;
    }

    public double getPrecio() {
        return precio;
    }

    private double getPorcentajeDescuento() {
       return porcentajeDescuento;
    }

    public double calcularPrecioFinal(int i) {
       return precio;
    }
 
}
