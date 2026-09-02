package com.ugm.programacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AsignadorVotacion {

    public static List<Asignacion> asignarCiudadanos(List<Ciudadano> ciudadanos, List<Colegio> colegios) {
        List<Asignacion> asignaciones = new ArrayList<>();

        for (Ciudadano ciudadano : ciudadanos) {
            List<ColegioDistancia> colegiosDistancia = new ArrayList<>();

            // 1. Calcular distancia a cada colegio
            for (Colegio colegio : colegios) {
                double dist = CalculadoraDistancia.calcularDistancia(
                        ciudadano.getLatitud(), ciudadano.getLongitud(),
                        colegio.getLatitud(), colegio.getLongitud()
                );
                colegiosDistancia.add(new ColegioDistancia(colegio, dist));
            }

            // 2. Ordenar de menor a mayor distancia
            Collections.sort(colegiosDistancia);

            Colegio colegioAsignado = null;
            String tipoAsignacion = "No asignado";
            double distanciaFinal = 0.0;

            // 3. Buscar el primer colegio con cupo y distancia <= 5 km (Normal)
            boolean asignado = false;
            for (ColegioDistancia cd : colegiosDistancia) {
                if (cd.getDistancia() <= 5.0 && cd.getColegio().tieneCupo()) {
                    colegioAsignado = cd.getColegio();
                    colegioAsignado.asignarCiudadano();
                    tipoAsignacion = "Normal";
                    distanciaFinal = cd.getDistancia();
                    asignado = true;
                    break;
                }
            }

            // 4. Si no hay cupo <= 5 km, buscar excepcional (el más cercano disponible sin importar distancia)
            if (!asignado) {
                for (ColegioDistancia cd : colegiosDistancia) {
                    if (cd.getColegio().tieneCupo()) {
                        colegioAsignado = cd.getColegio();
                        colegioAsignado.asignarCiudadano();
                        tipoAsignacion = "Excepcional por distancia";
                        distanciaFinal = cd.getDistancia();
                        asignado = true;
                        break;
                    }
                }
            }

            // 5. Si de plano ningún colegio tiene cupo
            if (!asignado) {
                tipoAsignacion = "No asignado por falta de cupos";
                distanciaFinal = colegiosDistancia.isEmpty() ? 0.0 : colegiosDistancia.get(0).getDistancia();
            }

            asignaciones.add(new Asignacion(ciudadano, colegioAsignado, tipoAsignacion, distanciaFinal));
        }

        return asignaciones;
    }
}