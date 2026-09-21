package com.ugm.programacion;

import com.ugm.programacion.datos.LectorCSV;
import com.ugm.programacion.logica.AsignadorVotacion;
import com.ugm.programacion.modelo.Asignacion;
import com.ugm.programacion.modelo.Ciudadano;
import com.ugm.programacion.modelo.Colegio;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String rutaCiudadanos = "ciudadanos_santiago.csv";
        String rutaColegios = "colegios_santiago.csv";

        List<Ciudadano> ciudadanos = LectorCSV.leerCiudadanos(rutaCiudadanos);
        List<Colegio> colegios = LectorCSV.leerColegios(rutaColegios);

        if (ciudadanos.isEmpty() || colegios.isEmpty()) {
            System.out.println("Error: No se pudieron cargar los datos de los archivos CSV.");
            return;
        }

        List<Asignacion> resultados = AsignadorVotacion.asignarCiudadanos(ciudadanos, colegios);

        System.out.println("===         UNIVERSIDAD GABRIELA MISTRAL         ===");
        System.out.println("=== RESUMEN DE ASIGNACION DE LOCALES DE VOTACION ===");
        System.out.printf("%-22s | %-45s | %-28s | %10s%n", "Ciudadano", "Local", "Tipo", "Distancia");
        System.out.println("-".repeat(115));

        for (Asignacion asignacion : resultados) {
            System.out.println(asignacion.formatearFila());
        }
    }
}
