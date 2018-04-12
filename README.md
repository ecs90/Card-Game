# Card-Game

PERSISTENCIA UTILIZADA Y POR QUE:

Use Mysql a travez de jdbc. MySql porque es el motor que venimos utilizando desde el anio pasado,
estoy acostumbrado a su sintaxis y era mas sencillo que migrar a otro.
JDBC porque fue lo que nos enseniaron, asi que con un poco de asistencia de mis companieros lo pude sacar andando rapido,
y era mas sencillo que aprender por mi cuenta en el poco tiempo que tengo libre como utilizar hibernate.

FUNCIONALIDAD DEL JUEGO:

Son 4 jugadores a los que se le reparte cartas de uno en uno. Pense en hacer un sistema de semaforos para que se pelearan por agarrar
de a una carta pero no llegue con el tiempo, asi que los jugadores estan creados como threads pero realmente no pelean por concurrencia.
Una vez que cada jugador tiene su carta, se comparan los numeros de las mismas, y aquellos jugadores que compartan el numero mas alto 
anotan un punto. Al vaciarce el mazo (pila de 52 cartas, 13 rondas), se carga en la base de datos el jugador de mas puntos con todas
sus cartas del partido.
En el juego, los jugadores son el obserbable, siendo los atributos a "destacar" las cartas y los puntos, y el observador es el juego
que va relatando que cartas se dieron y como se van actualizando la tabla de puntos.

DIAGRAMA UML:

Diagrama adjuntado en el archivo Top-Level Package.png realizado con las herramientas del editor (IntelliJ)
