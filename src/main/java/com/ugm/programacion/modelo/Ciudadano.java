package com.ugm.programacion.modelo;

public class Ciudadano {
    private final String id;
    private final String rut;
    private final String nombre;
    private final String comuna;
    private final double latitud;
    private final double longitud;

    public Ciudadano(String id, String rut, String nombre, String comuna, double latitud, double longitud) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.comuna = comuna;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getId() {
        return id;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getComuna() {
        return comuna;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }
}
