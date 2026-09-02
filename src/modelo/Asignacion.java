package com.ugm.programacion;

import java.util.Locale;

public class Asignacion {
    private Ciudadano ciudadano;
    private Colegio colegio; // Puede ser null si no hay asignación
    private String tipoAsignacion; // "Normal", "Excepcional por distancia", "No asignado"
    private double distancia;

    public Asignacion(Ciudadano ciudadano, Colegio colegio, String tipoAsignacion, double distancia) {
        this.ciudadano = ciudadano;
        this.colegio = colegio;
        this.tipoAsignacion = tipoAsignacion;
        this.distancia = distancia;
    }

    public Ciudadano getCiudadano() { return ciudadano; }
    public Colegio getColegio() { return colegio; }
    public String getTipoAsignacion() { return tipoAsignacion; }
    public double getDistancia() { return distancia; }

    @Override
    public String toString() {
        String colegioNombre = (colegio != null) ? colegio.getNombre() : "Ninguno";
        return String.format(Locale.US,
                "%-22s | %-45s | %-28s | %7.2f km",
                ciudadano.getNombre(), colegioNombre, tipoAsignacion, distancia);
    }
}