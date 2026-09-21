package com.ugm.programacion.logica;

import com.ugm.programacion.modelo.Asignacion;
import com.ugm.programacion.modelo.Ciudadano;
import com.ugm.programacion.modelo.Colegio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AsignadorVotacion {

    private static final double DISTANCIA_MAXIMA_KM = 5.0;
    private static final String TIPO_NORMAL = "Normal";
    private static final String TIPO_EXCEPCIONAL = "Excepcional por distancia";
    private static final String TIPO_SIN_CUPOS = "No asignado por falta de cupos";

    public static List<Asignacion> asignarCiudadanos(List<Ciudadano> ciudadanos, List<Colegio> colegios) {
        List<Asignacion> asignaciones = new ArrayList<>();

        for (Ciudadano ciudadano : ciudadanos) {
            List<ColegioDistancia> colegiosDistancia = calcularDistancias(ciudadano, colegios);
            asignaciones.add(asignarCiudadano(ciudadano, colegiosDistancia));
        }

        return asignaciones;
    }

    private static List<ColegioDistancia> calcularDistancias(Ciudadano ciudadano, List<Colegio> colegios) {
        List<ColegioDistancia> colegiosDistancia = new ArrayList<>();

        for (Colegio colegio : colegios) {
            double distancia = CalculadoraDistancia.calcularDistancia(
                    ciudadano.getLatitud(),
                    ciudadano.getLongitud(),
                    colegio.getLatitud(),
                    colegio.getLongitud()
            );
            colegiosDistancia.add(new ColegioDistancia(colegio, distancia));
        }

        Collections.sort(colegiosDistancia);
        return colegiosDistancia;
    }

    private static Asignacion asignarCiudadano(Ciudadano ciudadano, List<ColegioDistancia> colegiosDistancia) {
        for (ColegioDistancia opcion : colegiosDistancia) {
            if (opcion.getDistancia() <= DISTANCIA_MAXIMA_KM && opcion.getColegio().tieneCupo()) {
                opcion.getColegio().asignarCiudadano();
                return new Asignacion(ciudadano, opcion.getColegio(), TIPO_NORMAL, opcion.getDistancia());
            }
        }

        for (ColegioDistancia opcion : colegiosDistancia) {
            if (opcion.getColegio().tieneCupo()) {
                opcion.getColegio().asignarCiudadano();
                return new Asignacion(ciudadano, opcion.getColegio(), TIPO_EXCEPCIONAL, opcion.getDistancia());
            }
        }

        double distanciaReferencia = colegiosDistancia.isEmpty() ? 0.0 : colegiosDistancia.get(0).getDistancia();
        return new Asignacion(ciudadano, null, TIPO_SIN_CUPOS, distanciaReferencia);
    }
}
