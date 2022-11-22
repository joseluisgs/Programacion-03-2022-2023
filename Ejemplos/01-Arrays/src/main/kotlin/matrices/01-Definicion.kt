package matrices

fun main() {
    // Definimos una matriz en base a sus filas
    // Columnas
    // Es un array(filas) de arrays(columnas)

    // 3x3 con valores definidos
    val m1 = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )

    // 3x3 con valores por defecto
    val m2 = Array(3) { IntArray(3) }
    val m21 = Array(3) { Array(3) { 0 } }

    // 3x3 de char
    val m3 = Array(3) { CharArray(3) }

    // 4x4 de boolean
    val m4 = Array(4) { BooleanArray(4) }

    // 5x7 string
    val m5 = Array(5) { Array(7) { "" } }

    // Para leer o escribir usamos dos indices
    println(m1[0][0])
    m1[0][1] = 5
    println(m1[0][1])


}