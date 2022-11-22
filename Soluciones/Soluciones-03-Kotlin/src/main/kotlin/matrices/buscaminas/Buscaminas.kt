package matrices.buscaminas

/**
 * 0 = hidden, 1 = show, 2 = marked
 */

// Variables globales... no es buena práctica
// Debes pasarlas a cada función como parámetros
var MINAS = 0
var TABLERO_INTERNO = Array(9) { IntArray(9) { 0 } }
var TABLERO_VISTA = Array(9) { IntArray(9) { 0 } }
var BANDERA_MINAS = 0 // candidatas a minas que pongo
var CASILLAS_RESTANTES = 81 // casillas por descubrir
var PONER_MINA = false
var PRIMER_VISTAZO = true // primera jugada
var HAY_EXPLOSION = false

fun main() {

    // Algoitmo prinicipal
    // inicializa el tablero
    inicializarJuego()
    // bucle principal, podríamos hacerlo con do while, pero ya hemoos hecho muchos así que...
    while ((BANDERA_MINAS > 0 || MINAS > 0) && !HAY_EXPLOSION && CASILLAS_RESTANTES != 0) {
        imprimirTablero()
        analizarAccion()
    }
    // Resumen final
    imprimirTablero()
    // Modo Java, no hay if como expresión
    /*if (HAY_EXPLOSION) {
        println("Has perdido")
    } else {
        println("Has ganado")
    }*/
    // Con operador ternario java
    //println(HAY_EXPLOSION ? "Has perdido" : "Has ganado")
    println(if (HAY_EXPLOSION) "¡Has marcado una mina y has perdido" else "¡Has ganado! Has superado todas las minas")
}

/**
 * Inicializa el juego
 */
private fun inicializarJuego() {
    MINAS = getNumMinas("¿Cántas minas quieres usar? ", false)
    if (MINAS !in 1..71)
        MINAS = pedirMinasEnIntervalo(MINAS, 1..71)

    // Casillas restantes sin minas
    CASILLAS_RESTANTES -= MINAS

    // Mientras no se haya puesto la mina
    while (!PONER_MINA) {
        imprimirTablero()
        analizarAccion()
    }

    // en caso de que el usuario marque bombas antes de liberar un campo
    for (fila in TABLERO_INTERNO.indices) {
        for (columna in TABLERO_INTERNO.indices) {
            if (TABLERO_VISTA[fila][columna] == 2 && TABLERO_INTERNO[fila][columna] == 11) {
                BANDERA_MINAS -= 1
                MINAS -= 1
            }
        }
    }
}

/**
 * Imprime el tablero vista en base al tablero interno
 */
private fun imprimirTablero() {
    val linea = "—│—————————│"
    println("\n │123456789│")
    println(linea)
    for (fila in TABLERO_INTERNO.indices) {
        print("${fila + 1}│")
        for (columna in TABLERO_INTERNO[fila].indices) {
            print(
                when {
                    TABLERO_INTERNO[fila][columna] == 11 && HAY_EXPLOSION -> "X"
                    TABLERO_VISTA[fila][columna] == 2 && !HAY_EXPLOSION -> "*"
                    TABLERO_VISTA[fila][columna] == 1 -> {
                        if (TABLERO_INTERNO[fila][columna] == 0)
                            "/"
                        else TABLERO_INTERNO[fila][columna]
                    }

                    else -> "."
                }
            )
        }
        println("│")
    }
    println(linea)
}

/**
 * Analiza la acción
 */
private fun analizarAccion() {
    var marcado = false
    do {

        print("Activar/desactivar marcas de minas o liberar una celda [fila columna mina|liberar]: ")
        // 1 3 mina or 1 3 liberar
        val input = readln().split(" ").toTypedArray() // [1, 3, mina]
        if (input.size == 3) {
            var fila = input[0].toIntOrNull() ?: getNumMinas(input[0])
            var columna = input[1].toIntOrNull() ?: getNumMinas(input[1])
            val accion = input[2].lowercase()

            // Está en el intervalo de 1 a 9, si no pedir
            if (fila !in 1..9)
                fila = pedirMinasEnIntervalo(fila, 1..9)
            if (columna !in 1..9)
                columna = pedirMinasEnIntervalo(columna, 1..9)

            // Como el usuario no entiende que el array empieza en 0, resto 1
            fila-- // fila-=1
            columna-- // columna-=1

            // Si es librera o mrcar, si no pues no salimos de este while
            when (accion) {
                "liberar" -> marcado = liberarCasilla(fila, columna)
                "mina" -> marcado = marcarMina(fila, columna)
            }
        }
    } while (!marcado)
}

/**
 * Libera una casilla
 * @param fila fila
 * @param columna columna
 * @return true si se ha liberado una casilla
 */
private fun liberarCasilla(fila: Int, columna: Int): Boolean {
    // configura la vista que necesitamos a nivel interno
    if (!PONER_MINA) {
        if (TABLERO_VISTA[fila][columna] == 2)
            BANDERA_MINAS -= 1

        TABLERO_VISTA[fila][columna] = 1
        // comprobamos ayacentes
        comprobarAdyacentes(fila, columna)
        PRIMER_VISTAZO = false

        ponerMinasTablero()

        // restablece la vista, para que se puedan mostrar los campos abiertos
        for (row in TABLERO_VISTA.indices) {
            for (col in TABLERO_VISTA[row].indices) {
                if (TABLERO_VISTA[row][col] == 1) TABLERO_VISTA[row][col] = 0
            }
        }
        // Ponemos la mina!!
        TABLERO_VISTA[fila][columna] = 1
        PONER_MINA = true
        CASILLAS_RESTANTES -= 1
        comprobarAdyacentes(fila, columna)
        return true
    } else {
        // Liberamos las casillas si no hay nada alrededor
        if (TABLERO_INTERNO[fila][columna] == 11) {
            HAY_EXPLOSION = true
            return true
        } else {
            when (TABLERO_VISTA[fila][columna]) {
                0 -> {
                    TABLERO_VISTA[fila][columna] = 1
                    CASILLAS_RESTANTES -= 1
                    if (TABLERO_INTERNO[fila][columna] == 0)
                        comprobarAdyacentes(fila, columna)
                    return true
                }

                1 -> {
                    println("esta casilla ya ha sido liberada")
                    return false
                }

                2 -> {
                    TABLERO_VISTA[fila][columna] = 1
                    CASILLAS_RESTANTES -= 1
                    if (TABLERO_INTERNO[fila][columna] == 0)
                        comprobarAdyacentes(fila, columna)
                    BANDERA_MINAS -= 1
                    return true
                }
            }
        }
    }
    return false
}

/**
 * Marca una mina
 * @param fila fila
 * @param columna columna
 * @return true si se ha marcado una mina
 */
private fun marcarMina(fila: Int, columna: Int): Boolean {
    if (TABLERO_INTERNO[fila][columna] == 11) {
        return if (TABLERO_VISTA[fila][columna] == 0) {
            MINAS -= 1
            TABLERO_VISTA[fila][columna] = 2
            true
        } else {
            MINAS += 1
            TABLERO_VISTA[fila][columna] = 0
            true
        }
    } else {
        return when (TABLERO_VISTA[fila][columna]) {
            0 -> {
                TABLERO_VISTA[fila][columna] = 2
                BANDERA_MINAS += 1
                true
            }

            2 -> {
                TABLERO_VISTA[fila][columna] = 0
                BANDERA_MINAS -= 1
                true
            }

            else -> {
                println("campos ya descubiernos no pueden ser mrcados")
                false
            }
        }
    }
}

/**
 * Pone las minas en el tablero
 */
private fun ponerMinasTablero() {
    // Repetimos por cada mina
    repeat(MINAS) {
        // Generamos una posición hasta que esta este libre para situar las cosas
        var colocada = false
        while (!colocada) {
            val fila = (0..8).random()
            val columna = (0..8).random()
            if (TABLERO_INTERNO[fila][columna] != 11 && TABLERO_VISTA[fila][columna] != 1) {
                TABLERO_INTERNO[fila][columna] = 11
                colocada = true
                comprobarAdyacentes(fila, columna)
            }
        }
    }
}

/**
 * Comprueba adyacentes y llama las funciones necesarias para poner los números en el tablero
 * @param fila fila
 * @param columna columna
 */
private fun comprobarAdyacentes(fila: Int, columna: Int) {
    // Cuidado con los limites
    if (columna != 0 && TABLERO_INTERNO[fila][columna - 1] != 11)
        accionParaAdyacentes(fila, columna - 1)

    if (columna != 8 && TABLERO_INTERNO[fila][columna + 1] != 11)
        accionParaAdyacentes(fila, columna + 1)

    if (fila != 0) {
        if (TABLERO_INTERNO[fila - 1][columna] != 11)
            accionParaAdyacentes(fila - 1, columna)
        if (columna != 0 && TABLERO_INTERNO[fila - 1][columna - 1] != 11)
            accionParaAdyacentes(fila - 1, columna - 1)
        if (columna != 8 && TABLERO_INTERNO[fila - 1][columna + 1] != 11)
            accionParaAdyacentes(fila - 1, columna + 1)
    }

    if (fila != 8) {
        if (TABLERO_INTERNO[fila + 1][columna] != 11)
            accionParaAdyacentes(fila + 1, columna)
        if (columna != 0 && TABLERO_INTERNO[fila + 1][columna - 1] != 11)
            accionParaAdyacentes(fila + 1, columna - 1)
        if (columna != 8 && TABLERO_INTERNO[fila + 1][columna + 1] != 11)
            accionParaAdyacentes(fila + 1, columna + 1)
    }
}

/**
 * Tiene 3 cosas diferentes que hacer dependiendo de si es la primera vez que se ejecuta
 * y si ya se han colocado todas las bombas.
 * Después de que se hayan satisfecho los dos primeros casos,
 * se usa para borrar campos alrededor de un campo vacío.
 * @param fila fila
 * @param columna columna
 */
private fun accionParaAdyacentes(fila: Int, columna: Int) {
    if (!PONER_MINA && !PRIMER_VISTAZO) TABLERO_INTERNO[fila][columna] += 1 else {
        if (TABLERO_VISTA[fila][columna] != 1) {
            if (TABLERO_VISTA[fila][columna] == 2)
                BANDERA_MINAS -= 1
            TABLERO_VISTA[fila][columna] = 1
            if (!PRIMER_VISTAZO)
                CASILLAS_RESTANTES -= 1
            if (TABLERO_INTERNO[fila][columna] == 0 && !PRIMER_VISTAZO)
                comprobarAdyacentes(fila, columna)
        }
    }
}

/**
 * Pide el número para poner minas
 * @param text texto a mostrar
 * @param defaultMessage mensaje por defecto
 * @return número de minas
 */
private fun getNumMinas(text: String, defaultMessage: Boolean = true): Int {
    val strErrorNum = " No es un número válido, por favor inténtelo otra vez: "
    var num = text
    var default = defaultMessage

    do {
        print(if (default) num + strErrorNum else num)
        if (!default) default = true
        num = readln()
        // Voy a poner una epression regular para comprobar que es un número, aunque podría hacerlo de otras mneras que ya conoces!!
    } while (!num.matches(Regex("\\d+")))
    return num.toInt()
}

/**
 * Numero de minas por intervalo
 * @param num the domprobar
 * @para range rango de números
 * @return número dentro del rango
 */
private fun pedirMinasEnIntervalo(num: Int, range: IntRange): Int {
    var num2 = num
    do {
        num2 = getNumMinas(
            "$num2 no está en el rango permitido. Introduzca un valor entre ${range.first} y ${range.last}: ",
            false
        )
    } while (num in range)
    return num2
}