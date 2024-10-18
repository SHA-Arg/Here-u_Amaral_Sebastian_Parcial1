/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

/**
 *
 * @author Sebastian
 */
import Model.*;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        // 1. Pruebas de creación de objetos con codServicio inválido
        System.out.println("1-1: Intentar crear el objeto Gastronomia con codServicio inválido (menos de 5 dígitos)");
        try {
            Gastronomia g1 = new Gastronomia("4892", 180.0, true, "Hamburguesa criolla", 15.0, 4);
        } catch (ServicioException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        System.out.println("1-2: Crear el objeto Gastronomia con codServicio válido");
        Gastronomia g2 = new Gastronomia("489235", 180.0, true, "Hamburguesa criolla", 15.0, 4);
        System.out.println("Objeto creado: " + g2.getGastronomia());

        System.out.println("1-3: Intentar crear el objeto Hospedaje con codServicio inválido (menos de 5 dígitos)");
        try {
            Hospedaje h1 = new Hospedaje("2872", 1500.0, true, "Cabaña 3 personas", 10.0);
        } catch (ServicioException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        System.out.println("1-4: Crear el objeto Hospedaje con codServicio válido");
        Hospedaje h2 = new Hospedaje("287282", 1500.0, true, "Cabaña 3 personas", 10.0);
        System.out.println("Objeto creado: " + h2.getHospedaje());

        // 2. Prueba del método calcularPrecioFinal (polimorfismo)
        System.out.println("2-1: Calcular precio final para el servicio de Gastronomia");
        double precioFinalGastronomia = g2.calcularPrecioFinal(4); // Día con descuento
        System.out.println("Precio final para Gastronomia con descuento: $" + precioFinalGastronomia);

        System.out.println("2-2: Calcular precio final para el servicio de Gastronomia sin descuento");
        double precioSinDescuentoGastronomia = g2.calcularPrecioFinal(2); // Día sin descuento
        System.out.println("Precio final para Gastronomia sin descuento: $" + precioSinDescuentoGastronomia);

        System.out.println("2-3: Calcular precio final para el servicio de Hospedaje en promoción");
        double precioFinalHospedajePromocion = h2.calcularPrecioFinal();
        System.out.println("Precio final para Hospedaje en promoción: $" + precioFinalHospedajePromocion);

        // 3. Verificación de la consistencia del sistema (agregar servicios a una lista)
        System.out.println("3-1: Crear lista de servicios y agregar servicios creados");
        List<Servicio> listaServicios = new ArrayList<>();
        listaServicios.add(g2);
        listaServicios.add(h2);
        System.out.println("Lista de servicios actualizada: ");
        for (Servicio s : listaServicios) {
            System.out.println("Servicio: " + s.obtenerCodServicio() + ", Precio final: $" + s.calcularPrecioFinal());
        }

        // 4. Prueba de duplicados (excepción personalizada)
        System.out.println("4-1: Intentar agregar un servicio duplicado a la lista");
        try {
            agregarServicio(listaServicios, g2);
        } catch (ServicioException e) {
            System.out.println("Excepción capturada al intentar agregar duplicado: " + e.getMessage());
        }

        System.out.println("4-2: Agregar un nuevo servicio válido a la lista");
        Gastronomia g3 = new Gastronomia("123456", 200.0, true, "Pizza margarita", 20.0, 5);
        agregarServicio(listaServicios, g3);
        System.out.println("El nuevo servicio ha sido agregado con exito. Lista actualizada:");
        for (Servicio s : listaServicios) {
            System.out.println("Servicio: " + s.obtenerCodServicio() + ", Precio final: $" + s.calcularPrecioFinal());
        }
    }

    /**
     * Método para agregar un servicio a la lista.
     * Lanza una excepción si se intenta agregar un servicio con un código ya existente.
     *
     * @param lista Lista de servicios.
     * @param servicio Servicio a agregar.
     * @throws ServicioException Si el servicio ya existe en la lista.
     */
    public static void agregarServicio(List<Servicio> lista, Servicio servicio) {
        for (Servicio s : lista) {
            if (s.obtenerCodServicio() == servicio.obtenerCodServicio()) {
                throw new ServicioException("El servicio con código " + servicio.obtenerCodServicio() + " ya existe.");
            }
        }
        lista.add(servicio);
    }
}
