@echo off
setlocal
cd /d "%~dp0"

set "JAVA_HOME="
if exist "%ProgramFiles%\Java\jdk-26\bin\javac.exe" set "JAVA_HOME=%ProgramFiles%\Java\jdk-26"
if exist "%ProgramFiles%\Java\jdk-26.0.2.1\bin\javac.exe" set "JAVA_HOME=%ProgramFiles%\Java\jdk-26.0.2.1"
if exist "%ProgramFiles%\Java\jdk-17\bin\javac.exe" set "JAVA_HOME=%ProgramFiles%\Java\jdk-17"
if exist "%ProgramFiles(x86)%\Java\jdk-26\bin\javac.exe" set "JAVA_HOME=%ProgramFiles(x86)%\Java\jdk-26"
if exist "%ProgramFiles(x86)%\Java\jdk-26.0.2.1\bin\javac.exe" set "JAVA_HOME=%ProgramFiles(x86)%\Java\jdk-26.0.2.1"
if exist "%ProgramFiles(x86)%\Java\jdk-17\bin\javac.exe" set "JAVA_HOME=%ProgramFiles(x86)%\Java\jdk-17"

if "%JAVA_HOME%"=="" (
    echo ERROR: No se encontro un JDK instalado.
    echo Instala JDK 17 o 26 y vuelve a intentar.
    pause
    exit /b 1
)

set "PATH=%JAVA_HOME%\bin;%PATH%"

if not exist out mkdir out

echo Compilando proyecto...
for /r src %%f in (*.java) do javac -d out "%%f"

echo Ejecutando programa...
java -cp out com.ugm.programacion.Main

if errorlevel 1 (
    echo.
    echo ERROR: Fallo al ejecutar la clase principal.
    pause
    exit /b 1
)

pause
