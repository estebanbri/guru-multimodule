ESTRUCTURA "ANIDADA" :( VS "CHATA (FLAT)" :)
---------------------------------------------
Si tenes una estructura (ESTRUCTURA "ANIDADA") de maven multi-modulos asi:

guru-parent (proyecto git)
    pom.xml
    guru-api (module)
        pom.xml
    guru-core (module)
            pom.xml

Si en algun release no tocaste es decir no hubo modificaciones algun proyecto hijo (ej guru-core)
esta estructura anidada tenes desventajas:
 1- No vas a manejar como modulos individuales, es decir guru-parent va a tener la responsabilidad de todos los modulos hijos que contenga.
 2- En git vas a tener un unico repositorio el cual sin tenes muchos modulos hijos se va a ir haciendo cada vez mas pesado la descarga cuando
 hagas git clone. Y es mas, capaz no necesitas descargar algunos modulos hijos y te lo vas a tener que descargar igual (ej: necesito probar
 el modulo A por una prueba y teniendolo en un unico repo git vas a tener que descarte todos los modulos.
 3- Si usas jenkins te contiene manejarlos en proyectos separados de git al parent y los hijos. Porque de esta
 manera vas buildeando en jenkins cada modulo que se fue modicando y no volver a buildear al vicio modulos que no se modificaron
 en cierto release.

Mejor es utilizar la estructura "CHATA (FLAT)" asi:
guru-parent (proyecto git)
    pom.xml
guru-api (proyecto git)
    pom.xml (<relativePath>../guru-parent</relativePath>)
guru-core (proyecto git)
    pom.xml (<relativePath>../guru-parent</relativePath>)

Como ves en el pom de los hijos vas a tener que definir la etiqueta relativePath:

<parent>
  <groupId>...</groupId>
  <artifactId>ref-pom</artifactId>
  <version>..</version>
  <relativePath>../guru-parent</relativePath>
</parent>

La cual le da la ubicacion donde esta ubicado el parent.
