fun main() {
    val arrayInts = intArrayOf(1, 2, 3, 4, 5)

    // Recorrer con un while
    var i = 0
    while (i < arrayInts.size) {
        println(arrayInts[i])
        i++
    }

    println()

    // Recorrer con un for
    for (i in (0..arrayInts.size - 1)) {
        println(arrayInts[i])
    }

    println()
    /*
    Equivalente en JAVA o C#
    for (int i = 0; i < arrayInts.size; i++) {
        println(arrayInts[i])
    }*/
    for (i in (0 until arrayInts.size)) {
        println(arrayInts[i])
    }
    println()

    // Recorrer con un for y un indice
    for (i in (arrayInts.indices)) {
        println("Indice: $i, valor: ${arrayInts[i]}")
    }

    println()

    // Recorrer con un for each
    /*
    Equivalente en JAVa o C#
    for (int i : arrayInts) {
        println(i)
     */
    for (i in arrayInts) {
        println(i)
    }

    println()

    // Solo los indices pares
    for (i in (arrayInts.indices step 2)) {
        println("Indice: $i, valor: ${arrayInts[i]}")
    }
    // Más feo!!
    for (i in (0 until arrayInts.size) step 2) {
        println(arrayInts[i])
    }

    println()

    // Recorrer hacia atras con un while
    i = arrayInts.size - 1
    while (i >= 0) {
        println(arrayInts[i])
        i--
    }

    // Recorrerlo hacia atrás, desde el final hasta el principio
    for (i in (arrayInts.size - 1 downTo 0)) {
        println(arrayInts[i])
    }

    println()

    for (i in (arrayInts.size - 1 downTo 0) step 2) {
        println(arrayInts[i])
    }

    println()

    for (i in arrayInts.indices.reversed()) {
        println("Indice: $i, valor: ${arrayInts[i]}")
    }

    println()

    // usar withIndex
    for (element in arrayInts.withIndex()) {
        println("Indice: ${element.index}, valor: ${element.value}")
    }

    // Desestructurando
    for ((index, value) in arrayInts.withIndex()) {
        println("Indice: $index, valor: $value")
    }

}