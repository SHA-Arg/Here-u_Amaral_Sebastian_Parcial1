package Model;

/**
 *
 * @author Sebastian
 * 
 */
public abstract class Servicio {
    protected String codServicio;
    protected double porcentajeDescuento;
    protected boolean enPromocion;

    // Constructor
    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) throws Exception {
        if (codServicio.length() != 6) {
            throw new ServicioException("El código de servicio debe tener exactamente 6 caracteres.");
        }
        this.codServicio = codServicio;
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
    }

    // Métodos Getters y Setters
    public String obtenerCodServicio() {
        return codServicio;
    }

    public double obtenerPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public boolean estaEnPromocion() {
        return enPromocion;
    }

    public void setEnPromocion(boolean enPromocion) {
        this.enPromocion = enPromocion;
    }

    // Método abstracto
    public abstract double calcularPrecioFinal(java.time.LocalDate dia);


}
