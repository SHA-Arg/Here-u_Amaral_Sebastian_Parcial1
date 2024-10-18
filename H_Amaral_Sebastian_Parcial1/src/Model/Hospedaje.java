/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Sebastian
 *
 * Clase Hospedaje que extiende de Servicio. Representa un servicio de hospedaje y contiene atributos específicos como el precio por noche y descuentos.
 */
public class Hospedaje extends Servicio {

    // Atributos específicos de Hospedaje
    private String hospedaje;
    private double precioPorNoche;

    /**
     * Constructor de la clase Hospedaje. Verifica que el codServicio sea válido antes de asignarlo.
     *
     * @param codServicio Código único del servicio.
     * @param precioPorNoche Precio por noche del servicio.
     * @param porcentajeDescuento Porcentaje de descuento aplicado.
     * @param enPromocion Indica si el servicio está en promoción.
     * @throws ServicioException Si el codServicio no es válido.
     */
    // Constructor
    public Hospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws Exception {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
    }
    // Método para calcular el precio final

    @Override
    public double calcularPrecioFinal(java.time.LocalDate dia) {
        // Aplicar descuento si está en promoción y es de lunes a viernes
        if (estaEnPromocion() && (dia.getDayOfWeek().getValue() >= 1 && dia.getDayOfWeek().getValue() <= 5)) {
            return precioPorNoche - (precioPorNoche * getPorcentajeDescuento() / 100);
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

    private double getPorcentajeDescuento() {
       return porcentajeDescuento;
    }


}
