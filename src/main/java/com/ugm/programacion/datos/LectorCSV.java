package com.ugm.programacion.datos;

import com.ugm.programacion.modelo.Ciudadano;
import com.ugm.programacion.modelo.Colegio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorCSV {

    public static List<Ciudadano> leerCiudadanos(String rutaArchivo) {
        List<Ciudadano> ciudadanos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            boolean primerLinea = true;
            while ((linea = br.readLine()) != null) {
                if (primerLinea) {
                    primerLinea = false;
                    continue;
                }

                String[] partes = linea.split(",");
                if (partes.length >= 6) {
                    ciudadanos.add(new Ciudadano(
                            partes[0].trim(),
                            partes[1].trim(),
                            partes[2].trim(),
                            partes[3].trim(),
                            Double.parseDouble(partes[4].trim()),
                            Double.parseDouble(partes[5].trim())
                    ));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de ciudadanos: " + e.getMessage());
        }
        return ciudadanos;
    }

    public static List<Colegio> leerColegios(String rutaArchivo) {
        List<Colegio> colegios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            boolean primerLinea = true;
            while ((linea = br.readLine()) != null) {
                if (primerLinea) {
                    primerLinea = false;
                    continue;
                }

                String[] partes = linea.split(",");
                if (partes.length >= 6) {
                    colegios.add(new Colegio(
                            partes[0].trim(),
                            partes[1].trim(),
                            partes[2].trim(),
                            Double.parseDouble(partes[3].trim()),
                            Double.parseDouble(partes[4].trim()),
                            Integer.parseInt(partes[5].trim())
                    ));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de colegios: " + e.getMessage());
        }
        return colegios;
    }
}
