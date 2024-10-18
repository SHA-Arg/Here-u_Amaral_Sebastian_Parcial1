/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Sebastian
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private final List<Servicio> listaServicio;

    public Sistema() {
        listaServicio = new ArrayList<>();
    }

    // Agregar un servicio de tipo Gastronomía
    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws Exception {
        if (traerServicio(codServicio) != null) {
            throw new ServicioException("El servicio con el código " + codServicio + " ya existe.");
        }
        Gastronomia gastronomiaServicio = new Gastronomia(codServicio, porcentajeDescuento, enPromocion, gastronomia, precio, diaSemDesc);
        return listaServicio.add(gastronomiaServicio);
    }

    // Agregar un servicio de tipo Hospedaje
    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws Exception {
        if (traerServicio(codServicio) != null) {
            throw new ServicioException("El servicio con el código " + codServicio + " ya existe.");
        }
        Hospedaje hospedajeServicio = new Hospedaje(codServicio, porcentajeDescuento, enPromocion, hospedaje, precioPorNoche);
        return listaServicio.add(hospedajeServicio);
    }

    // Traer un servicio por código
    public Servicio traerServicio(String codServicio) {
        for (Servicio s : listaServicio) {
            if (s.obtenerCodServicio().equals(codServicio)) {
                return s;
            }
        }
        return null;
    }

    // Traer servicios en promoción
    public List<Servicio> traerServicio(boolean enPromocion) {
        List<Servicio> serviciosEnPromocion = new ArrayList<>();
        for (Servicio s : listaServicio) {
            if (s.isEnPromocion() == enPromocion) {
                serviciosEnPromocion.add(s);
            }
        }
        return serviciosEnPromocion;
    }

    // Traer servicios en promoción en un día específico
    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia) {
        List<Servicio> serviciosEnPromocion = new ArrayList<>();
        for (Servicio s : listaServicio) {
            if (s.isEnPromocion() == enPromocion && s.calcularPrecioFinal(dia) < s.calcularPrecioFinal(dia)) {
                serviciosEnPromocion.add(s);
            }
        }
        return serviciosEnPromocion;
    }
}
