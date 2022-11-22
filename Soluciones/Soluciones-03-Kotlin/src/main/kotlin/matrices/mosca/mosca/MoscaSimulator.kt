package mosca

import matrices.mosca.types.Coordenada
import matrices.mosca.types.Matriz


/**
 * Obtiene el número de Intentos
 */
fun getNumeroIntentos(): Int {
    var intentos = 0
    do {
        println("Introduce el número de intentos máximos, mayor a 1")
        // Si no lo puede comveretir da null
        intentos = readln().toIntOrNull() ?: 0
    } while (intentos < 1)
    return intentos
}

fun getNumeroCasillas(): Int {
    var numCasillas: Int
    do {
        println("Dime el número de casillas, siempre mayor a 5")
        numCasillas = readln().toIntOrNull() ?: 0
        println("Tamaño de vector es: $numCasillas")
    } while (numCasillas < 5)
    return numCasillas
}

fun imprimirCasillas(casillas: Matriz) {
    for (fila in casillas) {
        print("{ ")
        for (columna in fila) {
            print("$columna ")
        }
        println("} ")
    }
}

fun iniciarCasillas(casillas: Matriz) {
    // i recorre todos los indices
    for (i in casillas.indices) {
        // j recorre todos los elementos de cada indice
        for (j in casillas.indices) {
            // Se inicializa el valor de cada casilla a 0
            casillas[i][j] = 0
        }
    }
}

fun getPosicion(casillas: Matriz): Int {
    var fila: Int
    do {
        fila = (casillas.indices).random()
    } while (fila < 0 || fila >= casillas.size)
    return fila
}

fun situarMosca(casillas: Matriz, mosca: Int) {
    val fila: Int = getPosicion(casillas)
    val columna: Int = getPosicion(casillas)
    casillas[fila][columna] = mosca
}

fun posicionGolpear(casillas: Matriz): Coordenada {
    val posMosca: Coordenada = intArrayOf(0, 0)
    do {
        println("Introduce la posición de la Fila a atacar: ")
        posMosca[0] = (readln().toIntOrNull() ?: 0) - 1
        println("La posición Fila elegida es: " + (posMosca[0] + 1))
    } while (posMosca[0] < 0 || posMosca[0] >= casillas.size)
    do {
        println("Introduce la posición de la Columna a atacar: ")
        posMosca[1] = (readln().toIntOrNull() ?: 0) - 1
        println("La posición Columna elegida es: " + (posMosca[1] + 1))
    } while (posMosca[1] < 0 || posMosca[1] >= casillas.size)
    return posMosca
}

fun analizarGolpeo(MOSCA: Int, casillas: Matriz, posMosca: Coordenada): Boolean {
    // Logica del juego
    // Acertamos
    if (casillas[posMosca[0]][posMosca[1]] == MOSCA) {
        return true
    }
    // Analizamos los limites
    for (i in -1..1) {
        for (j in -1..1) {
            if (posMosca[0] + i >= 0
                && posMosca[0] + i < casillas.size
                && posMosca[1] + j >= 0
                && posMosca[1] + j < casillas.size
            ) {
                if (casillas[posMosca[0] + i][posMosca[1] + j] == MOSCA) {
                    println("¡CASI!")
                    iniciarCasillas(casillas)
                    situarMosca(casillas, MOSCA)
                    return false
                }
            }
        }
    }
    return false
}

// Vamos a buscar la mosca
fun buscarMosca(mosca: Int = 1, casillas: Matriz): Coordenada {
    for (i in casillas.indices) {
        for (j in casillas[i].indices) {
            if (casillas[i][j] == mosca) {
                //println("La mosca está en la posición: " + (i + 1) + "," + (j + 1))
                return intArrayOf(i, j)
            }
        }
    }
    return intArrayOf(-1, -1)
}

