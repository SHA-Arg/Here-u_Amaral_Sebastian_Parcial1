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
            Gastronomia plato1 = new Gastronomia("489265", 180.0, true, "Hamburguesa criolla", 15.0, 4);
        } catch (ServicioException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        System.out.println("1-2: Crear el objeto Gastronomia con codServicio válido");
        Gastronomia plato2 = new Gastronomia("489235", 180.0, true, "Hamburguesa criolla", 15.0, 4);
        System.out.println("Objeto creado: " + plato2.getGastronomia());

        System.out.println("1-3: Intentar crear el objeto Hospedaje con codServicio inválido (menos de 5 dígitos)");
        try {
            Hospedaje hospedaje1 = new Hospedaje("2872", 1500.0, true, "Cabaña 3 personas", 10.0);
        } catch (ServicioException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        System.out.println("1-4: Crear el objeto Hospedaje con codServicio válido");
        Hospedaje hospedaje2 = new Hospedaje("287282", 1500.0, true, "Cabaña 3 personas", 10.0);
        System.out.println("Objeto creado: " + hospedaje2.getHospedaje());

        // 2. Prueba del método calcularPrecioFinal (polimorfismo)
        System.out.println("2-1: Calcular precio final para el servicio de Gastronomia");
        double precioFinalGastronomia = plato2.calcularPrecioFinal(4); // Día con descuento
        System.out.println("Precio final para Gastronomia con descuento: $" + precioFinalGastronomia);

        System.out.println("2-2: Calcular precio final para el servicio de Gastronomia sin descuento");
        double precioSinDescuentoGastronomia = plato2.calcularPrecioFinal(2); // Día sin descuento
        System.out.println("Precio final para Gastronomia sin descuento: $" + precioSinDescuentoGastronomia);

        System.out.println("2-3: Calcular precio final para el servicio de Hospedaje en promoción");
        double precioFinalHospedajePromocion = hospedaje2.calcularPrecioFinal();
        System.out.println("Precio final para Hospedaje en promoción: $" + precioFinalHospedajePromocion);

        // 3. Verificación de la consistencia del sistema (agregar servicios a una lista)
        System.out.println("3-1: Crear lista de servicios y agregar servicios creados");
        List<Servicio> listaServicios = new ArrayList<>();
        listaServicios.add(plato2);
        listaServicios.add(hospedaje2);
        System.out.println("Lista de servicios actualizada: ");
        for (Servicio pedido : listaServicios) {
            System.out.println("Servicio: " + pedido.obtenerCodServicio() + ", Precio final: $" + pedido.calcularPrecioFinal());
        }

        // 4. Prueba de duplicados (excepción personalizada)
        System.out.println("4-1: Intentar agregar un servicio duplicado a la lista");
        try {
            agregarServicio(listaServicios, plato2);
        } catch (ServicioException e) {
            System.out.println("Excepción capturada al intentar agregar duplicado: " + e.getMessage());
        }

        System.out.println("4-2: Agregar un nuevo servicio válido a la lista");
        Gastronomia plato3 = new Gastronomia("123456", 200.0, true, "Pizza margarita", 20.0, 5);
        agregarServicio(listaServicios, plato3);
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
        for (Servicio pedido : lista) {
           if (pedido.obtenerCodServicio().equals(servicio.obtenerCodServicio())) {
                throw new ServicioException("El servicio con código " + servicio.obtenerCodServicio() + " ya existe.");
            }
        }
        lista.add(servicio);
    }
}
