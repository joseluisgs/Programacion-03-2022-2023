fun main() {
    val c = suma(1, 2)
    println(c)
    val d = suma(numeroB = 2, numeroA = 1)
    println(d)
    val e = incremento(3, 2)
    println(e)
    val f = incremento(incremento = 2, numero = 3)
    println(f)
    try {
        val g = incrementoPositivo(3, -2)
        println(g)
    } catch (e: Exception) {
        println(e.message)
    }

    try {
        val h = dividir(3, 0)
        println(h)
    } catch (e: Exception) {
        println(e.message)
        // Finally es opcional
    } finally {
        println("Esto se ejecuta siempre")
    }

    println(dividir(3, 2))

}

fun suma(numeroA: Int, numeroB: Int): Int {
    return numeroA + numeroB
}

// Esta sobre-cargada
fun suma(numeroA: Double, numeroB: Double): Double {
    return numeroA + numeroB
}

/**
 * Incrementa un numero en un incremento
 * @param numero el numero a incrementar
 * @param incremento el incremento. Por defecto 1
 * @return el numero incrementado
 */
fun incremento(numero: Int, incremento: Int = 1): Int {
    return numero + incremento
}

// solucion con sobrecarga!!!
/*
fun incremento(numero: Int): Int {
    return numero + 1
}*/


/**
 * Incrementa un numero en un incremento positivo
 * @param numero el numero a incrementar
 * @param incremento el incremento. Por defecto 1, y siempre positivo
 * @return el numero incrementado
 * @throws Exception si el incremento es negativo
 */
fun incrementoPositivo(numero: Int, incremento: Int = 1): Int {
    /*if (incremento < 0) {
        throw IllegalArgumentException("El incremento no puede ser negativo")
    }*/
    check(incremento >= 0) { "El incremento no puede ser negativo" }
    return numero + incremento
}

/**
 * Divide dos numeros enteros
 * @param dividendo el dividendo de la division
 * @param divisor el divisor de la division. Nunca 0
 * @return el resultado de la division
 * @throws Exception si el divisor es 0
 */
fun dividir(dividendo: Int, divisor: Int): Int {
    /*if (numeroB == 0) {
        throw IllegalArgumentException("El numero B no puede ser 0")
    }*/
    require(divisor != 0) { "El numero B no puede ser 0" }

    return dividendo / divisor
}