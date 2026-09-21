package com.ugm.programacion.modelo;

public class Colegio {
    private final String codigo;
    private final String nombre;
    private final String comuna;
    private final double latitud;
    private final double longitud;
    private final int capacidadMaxima;
    private int asignadosActuales;

    public Colegio(String codigo, String nombre, String comuna, double latitud, double longitud, int capacidadMaxima) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.comuna = comuna;
        this.latitud = latitud;
        this.longitud = longitud;
        this.capacidadMaxima = capacidadMaxima;
        this.asignadosActuales = 0;
    }

    public boolean tieneCupo() {
        return asignadosActuales < capacidadMaxima;
    }

    public void asignarCiudadano() {
        if (tieneCupo()) {
            asignadosActuales++;
        }
    }

    public String getCodigo() {
        return codigo;
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

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public int getAsignadosActuales() {
        return asignadosActuales;
    }
}
