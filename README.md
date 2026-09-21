# solemne2

Proyecto Java para asignar ciudadanos a colegios (locales de votación) en la Región Metropolitana de Santiago, considerando distancia geográfica, cupos y reglas de asignación.

## Requisitos

Para ejecutar este proyecto necesitas:

- Java JDK 17 o superior
- Maven (opcional si se ejecuta con el wrapper o desde un IDE)
- Sistema operativo con acceso a la terminal o consola
- Archivos CSV del proyecto:
  - `ciudadanos_santiago.csv`
  - `colegios_santiago.csv`

## ¿Qué hace el programa?

El programa:

1. Lee los ciudadanos desde `ciudadanos_santiago.csv`
2. Lee los colegios desde `colegios_santiago.csv`
3. Calcula la distancia entre cada ciudadano y cada colegio usando la fórmula de Haversine
4. Ordena los colegios según cercanía
5. Asigna a cada ciudadano:
   - al colegio más cercano con cupo y dentro de 5 km, si existe
   - al colegio más cercano disponible aunque esté a más de 5 km, si corresponde
   - como no asignado si no hay cupos disponibles
6. Muestra por consola el resumen final de asignaciones

## Cómo ejecutar el programa

### Opción 1: desde terminal con Maven

1. Abre una terminal en la raíz del proyecto.
2. Ejecuta:

```bash
mvn compile
mvn exec:java -Dexec.mainClass=com.ugm.programacion.Main
```

Si Maven no está instalado o no está en el PATH, se debe instalar antes.

### Opción 2: desde IntelliJ IDEA o Eclipse

1. Abre el proyecto en el IDE.
2. Busca la clase `Main`.
3. Ejecuta `main` como aplicación Java.
4. La salida se mostrará en la consola.

### Opción 3: compilación manual con javac

Desde la raíz del proyecto:

```bash
javac -d out $(find src/main/java -name "*.java")
java -cp out com.ugm.programacion.Main
```

En Windows PowerShell, la forma equivalente es:

```powershell
$files = Get-ChildItem -Recurse -Path src\main\java -Filter *.java | Select-Object -ExpandProperty FullName
javac -d out $files
java -cp out com.ugm.programacion.Main
```

## Estructura principal

- `src/main/java/com/ugm/programacion/Main.java`: punto de entrada
- `src/main/java/com/ugm/programacion/datos/LectorCSV.java`: carga los CSV
- `src/main/java/com/ugm/programacion/logica/CalculadoraDistancia.java`: cálculo de distancia
- `src/main/java/com/ugm/programacion/logica/AsignadorVotacion.java`: lógica de asignación
- `src/main/java/com/ugm/programacion/modelo/`: clases `Ciudadano`, `Colegio`, `Asignacion`

## Nota importante

El programa depende de que los archivos CSV estén en la misma carpeta raíz del proyecto y con los nombres exactos:

- `ciudadanos_santiago.csv`
- `colegios_santiago.csv`

Si faltan o no tienen el formato esperado, la lectura puede fallar o devolver resultados incompletos.
