package com.ugm.programacion.modelo;

import java.util.Locale;

public class Asignacion {
    private final Ciudadano ciudadano;
    private final Colegio colegio;
    private final String tipoAsignacion;
    private final double distancia;

    public Asignacion(Ciudadano ciudadano, Colegio colegio, String tipoAsignacion, double distancia) {
        this.ciudadano = ciudadano;
        this.colegio = colegio;
        this.tipoAsignacion = tipoAsignacion;
        this.distancia = distancia;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public Colegio getColegio() {
        return colegio;
    }

    public String getTipoAsignacion() {
        return tipoAsignacion;
    }

    public double getDistancia() {
        return distancia;
    }

    public String formatearFila() {
        String colegioNombre = colegio != null ? colegio.getNombre() : "Ninguno";
        return String.format(
                Locale.US,
                "%-22s | %-45s | %-28s | %7.2f km",
                ciudadano.getNombre(),
                colegioNombre,
                tipoAsignacion,
                distancia
        );
    }
}
