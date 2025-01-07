# MultiActivityApp: Aplicación de Computación Móvil

## Descripción
Este proyecto consiste en el desarrollo de una aplicación Android con diferentes funcionalidades distribuidas en varias actividades. El proyecto está diseñado para practicar conceptos básicos de desarrollo móvil utilizando Android Studio.

## Funcionalidades
1. **Actividad Principal:**
   - Contiene tres botones: `Guess Game`, `Random Greet` y `Countries`.
   - Incluye:
     - Un cuadro de texto asociado al botón `Guess Game` (acepta solo números).
     - Un spinner asociado al botón `Random Greet`.
   - Diseñada con un `ConstraintLayout` o `RelativeLayout` para verse bien en orientación portrait y landscape.

2. **Guess Game:**
   - Botón `Guess Game` lanza una nueva actividad para adivinar un número aleatorio entre 0 y el valor ingresado en el cuadro de texto.
   - Restricciones:
     - El valor ingresado debe estar entre 0 y 1000.
     - Si no se cumple, se muestra un mensaje de error en pantalla.
   - Interfaz similar a la mostrada en la Figura 2.

3. **Random Greet:**
   - Botón `Random Greet` lanza una nueva actividad que muestra un saludo en el idioma seleccionado en el spinner.

4. **Countries:**
   - Botón `Countries` lanza una actividad que muestra una lista de países.
   - Los datos de los países se obtienen del archivo `paises.json` (disponible en BrightSpace -> Semana 5).
   - Al seleccionar un país, se abre una nueva actividad con información detallada del país seleccionado.

## Requisitos
- **Software:**
  - Android Studio 2023.10 o superior.
  - SDK de Android (versión mínima: 21).

- **Hardware:**
  - Dispositivo Android físico o emulador con Android 5.0 o superior.

## Instrucciones de Uso
1. Clona este repositorio:
   ```bash
   git clone <URL del repositorio>
   ```
2. Abre el proyecto en Android Studio.
3. Conecta un dispositivo físico o inicia un emulador.
4. Ejecuta la aplicación haciendo clic en el botón **Run**.

## Estructura del Proyecto
```
|
|-- app/
|   |-- src/
|       |-- main/
|           |-- java/
|           |   |-- <paquete principal>/
|           |       |-- MainActivity.java
|           |       |-- GuessGameActivity.java
|           |       |-- RandomGreetActivity.java
|           |       |-- CountryListActivity.java
|           |       |-- CountryDetailActivity.java
|           |
|           |-- res/
|               |-- layout/
|               |   |-- activity_main.xml
|               |   |-- activity_guess_game.xml
|               |   |-- activity_random_greet.xml
|               |   |-- activity_country_list.xml
|               |   |-- activity_country_detail.xml
|               |
|               |-- values/
|                   |-- strings.xml
|                   |-- styles.xml
|
|-- paises.json
```

## Funcionalidades Adicionales
- Validación de entradas en tiempo real.
- Diseño responsivo adaptable a diferentes tamaños de pantalla.

## Capturas de Pantalla
- **Figura 1:** Actividad Principal (portrait y landscape).
- **Figura 2:** Actividad Guess Game.

## Licencia
Este proyecto es de uso académico y no está destinado para distribución comercial.

---
**Autor:** [Tu Nombre]  
**Curso:** Introducción a la Computación Móvil  
**Fecha:** Octubre 2023
