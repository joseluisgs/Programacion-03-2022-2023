package matrices

fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )

    printMatrix(matrix)

    val max = maximoMatrix(matrix)
    println("El maximo es $max")

    val min = minimoMatrix(matrix)
    println("El minimo es $min")

    val suma = sumaMatrix(matrix)
    println("La suma es $suma")

    val multiplicacion = multiplicacionMatrix(matrix)
    println("La multiplicacion es $multiplicacion")

    val media = mediaMatrix(matrix)
    println("La media es $media")

    batallaParesImparesMatrix(matrix)

    val matrix2 = clonarMatrix(matrix)
    println("Matrix original")
    printMatrix(matrix)
    println("Matrix clonada")
    printMatrix(matrix2)

    val iguales = igualdadMatrix(matrix, matrix2)
    println("Son iguales? $iguales")

}

fun sumaMatrix(matrix: Array<IntArray>): Any {
    var res = 0
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            res += matrix[i][j]
        }
    }
    return res
}

fun igualdadMatrix(matrix: Array<IntArray>, matrix2: Array<IntArray>): Any {
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            if (matrix[i][j] != matrix2[i][j]) {
                return false
            }
        }
    }
    return true
}

fun clonarMatrix(matrix: Array<IntArray>): Array<IntArray> {
    var res = Array(matrix.size) { IntArray(matrix[0].size) }
    // Recorremos y copiamos los valores
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            res[i][j] = matrix[i][j]
        }
    }
    return res
}


fun batallaParesImparesMatrix(matrix: Array<IntArray>) {
    var sumaPar = 0
    var sumaImpar = 0
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            if (matrix[i][j] % 2 == 0) {
                sumaPar += matrix[i][j]
            } else {
                sumaImpar += matrix[i][j]
            }
        }
    }
    when {
        sumaPar > sumaImpar -> println("Ganan los pares: $sumaPar vs $sumaImpar")
        sumaPar < sumaImpar -> println("Ganan los impares: $sumaImpar vs $sumaPar")
        else -> println("Empate: $sumaPar vs $sumaImpar")
    }
}

fun mediaMatrix(matrix: Array<IntArray>): Double {
    var sum = 0.0
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            sum += matrix[i][j]
        }
    }
    return sum / (matrix.size * matrix[0].size)
}

fun multiplicacionMatrix(matrix: Array<IntArray>): Int {
    var res = 1
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            res *= matrix[i][j]
        }
    }
    return res
}

fun minimoMatrix(matrix: Array<IntArray>): Int {
    var min = matrix[0][0]
    // con for each
    for (fila in matrix) {
        for (elemento in fila) {
            if (elemento < min) {
                min = elemento
            }
        }
    }
    return min
}

fun maximoMatrix(matrix: Array<IntArray>): Int {
    var max = matrix[0][0]
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            if (matrix[i][j] > max) {
                max = matrix[i][j]
            }
        }
    }
    return max
}

fun printMatrix(matrix: Array<IntArray>) {
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            print("${matrix[i][j]} ")
        }
        println()
    }
}