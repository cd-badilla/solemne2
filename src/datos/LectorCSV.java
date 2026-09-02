package com.ugm.programacion;

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
                if (primerLinea) { // Omitir cabecera si existe
                    primerLinea = false;
                    continue;
                }
                String[] partes = linea.split(",");
                if (partes.length >= 6) {
                    String id = partes[0].trim();
                    String rut = partes[1].trim();
                    String nombre = partes[2].trim();
                    String comuna = partes[3].trim();
                    double lat = Double.parseDouble(partes[4].trim());
                    double lon = Double.parseDouble(partes[5].trim());

                    ciudadanos.add(new Ciudadano(id, rut, nombre, comuna, lat, lon));
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
                    String codigo = partes[0].trim();
                    String nombre = partes[1].trim();
                    String comuna = partes[2].trim();
                    double lat = Double.parseDouble(partes[3].trim());
                    double lon = Double.parseDouble(partes[4].trim());
                    int capacidad = Integer.parseInt(partes[5].trim());

                    colegios.add(new Colegio(codigo, nombre, comuna, lat, lon, capacidad));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de colegios: " + e.getMessage());
        }
        return colegios;
    }
}