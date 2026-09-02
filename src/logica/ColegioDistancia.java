package com.ugm.programacion;

public class ColegioDistancia implements Comparable<ColegioDistancia> {
    private Colegio colegio;
    private double distancia;

    public ColegioDistancia(Colegio colegio, double distancia) {
        this.colegio = colegio;
        this.distancia = distancia;
    }

    public Colegio getColegio() { return colegio; }
    public double getDistancia() { return distancia; }

    @Override
    public int compareTo(ColegioDistancia otro) {
        return Double.compare(this.distancia, otro.distancia);
    }
}