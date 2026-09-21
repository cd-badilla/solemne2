package com.ugm.programacion.logica;

import com.ugm.programacion.modelo.Colegio;

public class ColegioDistancia implements Comparable<ColegioDistancia> {
    private final Colegio colegio;
    private final double distancia;

    public ColegioDistancia(Colegio colegio, double distancia) {
        this.colegio = colegio;
        this.distancia = distancia;
    }

    public Colegio getColegio() {
        return colegio;
    }

    public double getDistancia() {
        return distancia;
    }

    @Override
    public int compareTo(ColegioDistancia otro) {
        return Double.compare(this.distancia, otro.distancia);
    }
}
