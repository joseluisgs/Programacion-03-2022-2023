fun main() {
    val vectorEnteros = intArrayOf(-4, 1, -6, 4, 7, 5, 9)

    val max = maximo(vectorEnteros)
    println("El maximo es $max")

    val min = minimo(vectorEnteros)
    println("El minimo es $min")

    val suma = suma(vectorEnteros)
    println("La suma es $suma")

    val multiplicacion = multiplicacion(vectorEnteros)
    println("La multiplicacion es $multiplicacion")

    val media = media(vectorEnteros)
    println("La media es $media")

    //  imprimir(vectorEnteros)
    println(vectorEnteros.contentToString())
    println(vectorEnteros.joinToString(", "))

    // Imprimir ascedente
    println("Ascendente")
    imprimirAscendente(vectorEnteros)

    // Imprimir descendente
    println("Descendente")
    imprimirDescendente(vectorEnteros)

    // Batalla de pares contra impares
    when (batallaParesImpares(vectorEnteros)) {
        0 -> println(
            "Empate: ${sumaElementosPosicionPares(vectorEnteros) - sumaElementosPosicionImpares(vectorEnteros)} Pares: ${
                sumaElementosPosicionPares(
                    vectorEnteros
                )
            } Impares: ${sumaElementosPosicionImpares(vectorEnteros)}"
        )

        1 -> println(
            "Ganan los pares: Pares: ${sumaElementosPosicionPares(vectorEnteros)} vs Impares: ${
                sumaElementosPosicionImpares(
                    vectorEnteros
                )
            }"
        )

        -1 -> println(
            "Ganan los impares: Impares: ${sumaElementosPosicionImpares(vectorEnteros)} vs Pares: ${
                sumaElementosPosicionPares(
                    vectorEnteros
                )
            }"
        )
    }

    // importante los arrays van por referencia, por eso es fundamental
    // usar var y val -- Pues no!! siempre pasan por referencia!!!!
    val vectorInmutable = intArrayOf(1, 2, 3, 4, 5)
    var vectorMutable = intArrayOf(1, 2, 3, 4, 5)
    println("Vector inmutable: ${vectorInmutable.contentToString()}")
    println("Vector mutable: ${vectorMutable.contentToString()}")
    sumaMasUno(vectorInmutable)
    sumaMasUno(vectorMutable)
    println("Vector inmutable: ${vectorInmutable.contentToString()}")
    println("Vector mutable: ${vectorMutable.contentToString()}")

    // No se copina vectores igualando, se igualan las referencias!!!
    val vectorInmutable2 = vectorInmutable // Son la misma referencia con distinto nombre
    vectorInmutable2[0] = 100
    println("Vector inmutable: ${vectorInmutable.contentToString()}")

    // Copiar clonar vectores
    val vectorInmutable3 = clone(vectorInmutable)
    vectorInmutable3[0] = 200
    println("Vector inmutable: ${vectorInmutable.contentToString()}")
    println("Vector inmutable3: ${vectorInmutable3.contentToString()}")

    // Igualdad vs Identidad
    // dos elementos son iguales si tienen el mismo contenido
    // dos elementos son identicos si son la misma referencia
    // Identidad
    if (vectorInmutable === vectorInmutable2) {
        println("Son la misma referencia")
    } else {
        println("No son la misma referencia")
    }
    val vectorInmutable4 = clone(vectorInmutable)
    // iguales
    if (igualdad(vectorInmutable, vectorInmutable4)) {
        println("Son iguales")
    } else {
        println("No son iguales")
    }


}

/**
 * Compara dos vectores y devuelve true si son iguales en contenido
 * @param origen Vector de origen
 * @param destino Vector de destino
 * @return true si son iguales, false en caso contrario
 */
fun igualdad(origen: IntArray, destino: IntArray): Boolean {
    if (origen.size != destino.size) {
        return false
    }
    for (i in origen.indices) {
        if (origen[i] != destino[i]) {
            return false
        }
    }
    return true
}

/**
 * Clona un vector de enteros
 * @param vector Vector de enteros
 * @return Clon del vector
 */
fun clone(vector: IntArray): IntArray {
    val vectorClonado = IntArray(vector.size)
    for (i in vector.indices) {
        vectorClonado[i] = vector[i]
    }
    return vectorClonado

}

/**
 * Suma 1 a todos los elementos del vector
 * @param vector Vector de enteros
 */
fun sumaMasUno(vector: IntArray) {
    for (i in vector.indices) {
        vector[i]++
    }
}


/**
 * Devuleve la suma de elementos de un vector de enteros
 * de las posiciones pares
 * @param vectorEnteros Vector de enteros
 * @return Suma de los elementos de las posiciones pares
 */
fun sumaElementosPosicionPares(vectorEnteros: IntArray): Int {
    var suma = 0
    for (i in vectorEnteros.indices) {
        if (i % 2 == 0) {
            suma += vectorEnteros[i]
        }
    }
    return suma
}

/**
 * Devuelve el resultado de la resta entre números en posición par
 * menos los números en posición impar
 * @param vectorEnteros Vector de enteros
 * @return Resultado de la resta: positivo si gana los pares, negativo si gana los impares o 0 si empatan
 */
fun batallaParesImpares(vectorEnteros: IntArray): Int {
    val sumaPar = sumaElementosPosicionPares(vectorEnteros)
    val sumaImpar = sumaElementosPosicionImpares(vectorEnteros)
    return when {
        sumaPar > sumaImpar -> {
            1
        }

        sumaPar < sumaImpar -> {
            -1
        }

        else -> {
            0
        }
    }
}

/**
 * Devuleve la suma de elementos de un vector de enteros
 * de las posiciones impares
 * @param vectorEnteros Vector de enteros
 * @return Suma de los elementos de las posiciones impares
 */
fun sumaElementosPosicionImpares(vectorEnteros: IntArray): Int {
    var suma = 0
    for (i in vectorEnteros.indices) {
        if (i % 2 != 0) {
            suma += vectorEnteros[i]
        }
    }
    return suma
}

/**
 * Imprime el vector en orden ascendente
 * @param vectorEnteros
 */
fun imprimirDescendente(vectorEnteros: IntArray) {
    for (i in vectorEnteros.indices.reversed()) {
        println(vectorEnteros[i])
    }
}

/**
 * Imprime el vector en orden ascendente
 * @param vectorEnteros
 */
fun imprimirAscendente(vectorEnteros: IntArray) {
    for (i in vectorEnteros.indices) {
        println(vectorEnteros[i])
    }
}

/**
 * Devuelve la media de los elementos de un vector
 * @param vectorEnteros Vector de enteros
 * @return media de los elementos del vector
 */
fun media(vectorEnteros: IntArray): Double {
    var suma = 0.0
    for (i in vectorEnteros) {
        suma += i
    }
    return suma / vectorEnteros.size
}

/**
 * Devuelve la multiplicación de todos los elementos del vector
 * @param vectorEnteros Vector de enteros
 * @return multiplicación de todos los elementos del vector
 */
fun multiplicacion(vectorEnteros: IntArray): Int {
    var resultado = 1
    for (i in vectorEnteros.indices) {
        resultado *= vectorEnteros[i]
    }
    return resultado
}

/**
 * Devuelve la suma de los elementos de un vector
 * @param vectorEnteros Vector de enteros
 * @return suma de los elementos del vector
 */
fun suma(vectorEnteros: IntArray): Int {
    var suma = 0
    for (i in vectorEnteros.indices) {
        suma += vectorEnteros[i]
    }
    return suma
}

/**
 * Devuelve el maximo de un vector de enteros
 * @param vectorEnteros Vector de enteros
 * @return El mínimo de los elementos del vector
 */
fun minimo(vectorEnteros: IntArray): Int {
    var min = vectorEnteros[0]
    for (i in vectorEnteros.indices) {
        if (vectorEnteros[i] < min) {
            min = vectorEnteros[i]
        }
    }
    return min
}

/**
 * Devuelve el máximo de un vector de enteros
 * @param vectorEnteros Vector de enteros
 * @return El máximo del vector
 */
fun maximo(vectorEnteros: IntArray): Int {
    var max = vectorEnteros[0]
    /*for (i in vectorEnteros.indices) {
        if (vectorEnteros[i] > max) {
            max = vectorEnteros[i]
        }
    }*/
    // for each
    for (elemento in vectorEnteros) {
        if (elemento > max) {
            max = elemento
        }
    }
    return max
}
