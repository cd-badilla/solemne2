package com.ugm.programacion;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String rutaCiudadanos = "ciudadanos_santiago.csv";
        String rutaColegios = "colegios_santiago.csv";

        // Cargar datos
        List<Ciudadano> ciudadanos = LectorCSV.leerCiudadanos(rutaCiudadanos);
        List<Colegio> colegios = LectorCSV.leerColegios(rutaColegios);

        if (ciudadanos.isEmpty() || colegios.isEmpty()) {
            System.out.println("Error: No se pudieron cargar los datos de los archivos CSV.");
            return;
        }

        // Realizar asignación
        List<Asignacion> resultados = AsignadorVotacion.asignarCiudadanos(ciudadanos, colegios);

        // Mostrar resultados
        System.out.println("===         UNIVERSIDAD GABRIELA MISTRAL         ===");
        System.out.println("=== RESUMEN DE ASIGNACIÓN DE LOCALES DE VOTACIÓN ===");
        System.out.printf("%-22s | %-45s | %-28s | %10s%n", "Ciudadano", "Local", "Tipo", "Distancia");
        System.out.println("-".repeat(115));
        for (Asignacion a : resultados) {
            String nombreColegio = (a.getColegio() != null) ? a.getColegio().getNombre() : "Ninguno";
            System.out.printf("%-22s | %-45s | %-28s | %7.2f km%n",
                    a.getCiudadano().getNombre(),
                    nombreColegio,
                    a.getTipoAsignacion(),
                    a.getDistancia());
        }
    }
}