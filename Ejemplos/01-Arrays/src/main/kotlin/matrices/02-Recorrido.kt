package matrices

fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )

    // Recorremos con un while, la forma más incomoda
    var i = 0 // filas
    while (i < matrix.size) {
        var j = 0 // columnas
        while (j < matrix[i].size) {
            print("${matrix[i][j]} ")
            j++
        }
        println()
        i++
    }

    println()

    // con un for, la forma más cómoda
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            print("${matrix[i][j]} ")
        }
        println()
    }

    println()

    //  for each
    for (fila in matrix) {
        for (elemento in fila) {
            print("$elemento ")
        }
        println()
    }

    println()

    // for until
    for (i in 0 until matrix.size) {
        for (j in 0 until matrix[i].size) {
            print("${matrix[i][j]} ")
        }
        println()
    }

    println()

    // escribo las columnas a la inversa
    for (i in matrix.indices) {
        for (j in matrix[i].indices.reversed()) {
            print("${matrix[i][j]} ")
        }
        println()
    }

    println()

    // escribo las filas a la inversa
    for (i in matrix.indices.reversed()) {
        for (j in matrix[i].indices) {
            print("${matrix[i][j]} ")
        }
        println()
    }

    println()

    // Todo a la inversa
    for (i in matrix.indices.reversed()) {
        for (j in matrix[i].indices.reversed()) {
            print("${matrix[i][j]} ")
        }
        println()
    }

    println()


}