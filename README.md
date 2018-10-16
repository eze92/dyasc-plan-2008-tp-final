# dyasc-plan-2008-tp-final

Trabajo Practico de la materia  Diseño y Arquitectura de Sistemas de Computacion

## Arquitectura

Se decidió utilizar una estructura modularizada para la resolución del problema en todo el proyecto. Ésta se divide en 4 grupos bien definidos:

 + Programa: contiene el main de todo el proyecto.
 + Entrada: se encarga de separar e identifacar cada argumento recibido por consola. También notifica sobre posibles errores en la lectura de tales parámetros.
 + Salida: se encarga de generar la salida correspondiente. La salida puede ser:  
    * Por pantalla: con el comando **--mode=no-output [nombre_del_archivo].md**
    * Mediante un archivo: con el comando **--mode=default** ó **--output=[nombre_de_carpeta]** más **[nombre_del_archivo].md**
 + Dominio: se encarga de realizar el parseo de cada expresión recibida del archivo MarkDown a HTML.

#### Dominio

Para identificar cada una de las expresiones del MarkDown se utilizó el patrón *Cadena de responsabilidades*, donde cada expresión se transforma en un objeto de la cadena. Ejemplo: la expresión **---** se corresponde con la clase **Seccion**.

Se añadió una expresión extra que denota la finalización del archivo, de esta manera cuando la *Cadena de reponsabilidades* encuentra la expresión **FIN** (expresión creada por nosotros), reconocerá que el archivo no contiene más expresiones por tratar.

-----

## Integrantes

Beltrame Martín  
Ledesma Ezequiel


-----
[![Build Status](https://travis-ci.org/eze92/dyasc-plan-2008-tp-final.svg?branch=master)](https://travis-ci.org/eze92/dyasc-plan-2008-tp-final)
