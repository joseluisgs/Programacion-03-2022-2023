package matrices.doble_buffer

const val MAX = 5
fun main() {
    val matrix = Array(MAX) { IntArray(MAX) }

    initMatrix(matrix)
    printMatrix(matrix)

    //sinDobleBuffer(matrix)

    conDobleBuffer(matrix)

    println("FIN!")

}

/**
 * No esta bien
 */
fun sinDobleBuffer(matrix: Array<IntArray>) {
    val timeMax = 10_000
    var time = 0
    do {
        moverLosUnosSinDobleBuffer(matrix)
        printMatrix(matrix)
        Thread.sleep(1000)
        time += 1_000
    } while (time < timeMax)
}

/**
 * No esta bien porque vamos machacando los valores de la matriz
 * a la misma vez que el bucle los lee por lo tanto
 * estamos mutando la matriz mientras la leemos
 */
fun moverLosUnosSinDobleBuffer(matrix: Array<IntArray>) {
    for (fila in matrix.indices) {
        for (columna in matrix[fila].indices) {
            if (matrix[fila][columna] == 1) {
                // Mover aleatoriamente a una posicion que tenga un 0
                var esCero = false
                do {
                    val nuevaFila = (0 until MAX).random()
                    val nuevaColumna = (0 until MAX).random()
                    if (matrix[nuevaFila][nuevaColumna] == 0) {
                        matrix[fila][columna] = 0
                        matrix[nuevaFila][nuevaColumna] = 1
                        esCero = true
                    }
                } while (!esCero)
            }
        }
    }
}

// Ponemos 0 o 1 si la posición está vacía
fun initMatrix(matrix: Array<IntArray>) {
    val maxUnos = 10
    // sorteo de 10 posiciones mientras que no sea 0
    repeat(10) {
        var esCero = false
        do {
            val fila = (0 until MAX).random()
            val columna = (0 until MAX).random()
            if (matrix[fila][columna] == 0) {
                matrix[fila][columna] = 1
                esCero = true
            }
        } while (!esCero)
    }
}

fun printMatrix(matrix: Array<IntArray>) {
    println()
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            print(matrix[i][j])
        }
        println()
    }
}

fun conDobleBuffer(matrix: Array<IntArray>) {
    val timeMax = 10_000
    var time = 0
    var matrixLectura = clonarMatriz(matrix)
    do {
        // Intercambiamos las matrices
        val matrixEscritura = clonarMatriz(matrixLectura)

        // Acción
        moverLosUnosConDobleBuffer(matrixLectura, matrixEscritura)

        // Intercambiamos de nuevo
        matrixLectura = clonarMatriz(matrixEscritura)

        printMatrix(matrixLectura)
        Thread.sleep(1000)
        time += 1_000
    } while (time < timeMax)
}

fun clonarMatriz(matrixLectura: Array<IntArray>): Array<IntArray> {
    val matrixEscritura = Array(MAX) { IntArray(MAX) }
    for (fila in matrixLectura.indices) {
        for (columna in matrixLectura[fila].indices) {
            matrixEscritura[fila][columna] = matrixLectura[fila][columna]
        }
    }
    return matrixEscritura
}

fun moverLosUnosConDobleBuffer(matrixLectura: Array<IntArray>, matrixEscritura: Array<IntArray>) {
    for (fila in matrixLectura.indices) {
        for (columna in matrixLectura[fila].indices) {
            if (matrixLectura[fila][columna] == 1) {
                // Mover aleatoriamente a una posicion que tenga un 0
                var esCero = false
                do {
                    val nuevaFila = (0 until MAX).random()
                    val nuevaColumna = (0 until MAX).random()
                    if (matrixEscritura[nuevaFila][nuevaColumna] == 0) {
                        matrixEscritura[fila][columna] = 0
                        matrixEscritura[nuevaFila][nuevaColumna] = 1
                        esCero = true
                    }
                } while (!esCero)
            }
        }
    }
}
