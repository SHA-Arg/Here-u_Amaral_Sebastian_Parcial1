/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Sebastian
 * 
 * Clase Hospedaje que extiende de Servicio.
 * Representa un servicio de hospedaje y contiene atributos específicos como el precio por noche y descuentos.
 */
public class Hospedaje extends Servicio {
    // Atributos específicos de Hospedaje
    private String hospedaje;
    private String nombreHospedaje;
    private double precioPorNoche;

     /**
     * Constructor de la clase Hospedaje.
     * Verifica que el codServicio sea válido antes de asignarlo.
     * 
     * @param codServicio Código único del servicio.
     * @param nombreHospedaje Nombre del servicio de hospedaje.
     * @param precioPorNoche Precio por noche del servicio.
     * @param porcentajeDescuento Porcentaje de descuento aplicado.
     * @param enPromocion Indica si el servicio está en promoción.
     * @throws ServicioException Si el codServicio no es válido.
     */
      public Hospedaje(String codServicio, double precioPorNoche, boolean enPromocion, String nombreHospedaje, double porcentajeDescuento) {
          if (String.valueOf(codServicio).length() < 5) {
            throw new ServicioException("El código de servicio debe tener al menos 5 dígitos.");
        }
        this.codServicio = codServicio;
        this.nombreHospedaje = nombreHospedaje;
        this.precioPorNoche = precioPorNoche;
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
    }

    @Override
    public double calcularPrecioFinal(java.time.LocalDate dia) {
        // Aplicar descuento si está en promoción y es de lunes a viernes
        if (isEnPromocion() && (dia.getDayOfWeek().getValue() >= 1 && dia.getDayOfWeek().getValue() <= 5)) {
            return precioPorNoche - (precioPorNoche * obtenerPorcentajeDescuento() / 100);
        }
        return precioPorNoche;
    }

    // Getters y Setters
    public String getHospedaje() {
        return hospedaje;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }


}
