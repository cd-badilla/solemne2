package com.ugm.programacion;

public class Ciudadano {
    private String id;
    private String rut;
    private String nombre;
    private String comuna;
    private double latitud;
    private double longitud;

    public Ciudadano(String id, String rut, String nombre, String comuna, double latitud, double longitud) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.comuna = comuna;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getId() { return id; }
    public String getRut() { return rut; }
    public String getNombre() { return nombre; }
    public String getComuna() { return comuna; }
    public double getLatitud() { return latitud; }
    public double getLongitud() { return longitud; }
}