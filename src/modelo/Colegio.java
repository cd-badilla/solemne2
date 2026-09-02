package com.ugm.programacion;

public class Colegio {
    private String codigo;
    private String nombre;
    private String comuna;
    private double latitud;
    private double longitud;
    private int capacidadMaxima;
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

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getComuna() { return comuna; }
    public double getLatitud() { return latitud; }
    public double getLongitud() { return longitud; }
    public int getCapacidadMaxima() { return capacidadMaxima; }
    public int getAsignadosActuales() { return asignadosActuales; }
}