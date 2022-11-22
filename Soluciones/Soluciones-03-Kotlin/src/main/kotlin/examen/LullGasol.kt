package examen

fun main() {
    val NUM_RONDAS = 3
    val NUM_LANZAMIENTOS = 5
    val puntuacionLlul = IntArray(NUM_RONDAS) // { 0 }
    val puntuacionGasol = IntArray(NUM_RONDAS) // { 0 }

    juegoLanzamientos(NUM_RONDAS, NUM_LANZAMIENTOS, puntuacionLlul, puntuacionGasol)

    imprimirResultados(puntuacionLlul, puntuacionGasol)
}

private fun juegoLanzamientos(
    NUM_RONDAS: Int,
    NUM_LANZAMIENTOS: Int,
    puntuacionLlul: IntArray,
    puntuacionGasol: IntArray
) {
    // repetimos el juego NUM_RONDAS veces
    for (i in 0..NUM_RONDAS - 1) {
        println("Ronda ${i + 1}")
        // repetimos el lanzamiento NUM_LANZAMIENTOS veces
        for (j in 0 until NUM_LANZAMIENTOS) {
            println("Lanzamiento Llul: ${j + 1}")
            // Llul lanza
            if (j < NUM_LANZAMIENTOS - 1) {
                puntuacionLlul[i] += lanzamiento(lanzamiento = j, probabilidad = 0.5, puntuacion = 1)
            } else {
                puntuacionLlul[i] += lanzamiento(lanzamiento = j, probabilidad = 0.5, puntuacion = 2)
            }
            // Gasol lanza
            println("Lanzamiento Gasol: ${j + 1}")
            // Llul lanza
            if (j < NUM_LANZAMIENTOS - 1) {
                puntuacionGasol[i] += lanzamiento(lanzamiento = j, probabilidad = 0.33, puntuacion = 1)
            } else {
                puntuacionGasol[i] += lanzamiento(lanzamiento = j, probabilidad = 0.33, puntuacion = 2)
            }
        }
    }
}

fun lanzamiento(lanzamiento: Int, probabilidad: Double, puntuacion: Int): Int {
    val resultado = Math.random()
    return if (resultado < probabilidad) {
        println("Lanzamiento ${lanzamiento + 1}: acierto y tiene $puntuacion puntos")
        puntuacion
    } else {
        println("Lanzamiento ${lanzamiento + 1}: fallo")
        0
    }
}

fun imprimirResultados(puntuacionLlul: IntArray, puntuacionGasol: IntArray) {
    // analizamos cada ronda
    for (i in puntuacionLlul.indices) {
        println("Resultados de la ronda ${i + 1}")
        // si la puntuación de Llul es mayor que la de Gasol
        if (puntuacionLlul[i] > puntuacionGasol[i]) {
            println("Gana Llul en la ronda ${i + 1} con ${puntuacionLlul[i]} puntos")
        } else if (puntuacionLlul[i] < puntuacionGasol[i]) {
            println("Gana Gasol en la ronda ${i + 1} con ${puntuacionGasol[i]} puntos")
        } else {
            println("Empate en la ronda ${i + 1} con ${puntuacionLlul[i]} puntos")
        }
        println("Llul: ${puntuacionLlul.contentToString()} puntos")
        println("Gasol: ${puntuacionGasol.contentToString()} puntos")
    }

    // necesitamos los puntos totales de cada jugador
    val puntosLull = sumaPuntosTotal(puntuacionLlul)
    val puntosGasol = sumaPuntosTotal(puntuacionGasol)

    // ¿Quién ha ganado? when para no repetir el if como antes
    println("Resultados finales")
    when {
        puntosLull > puntosGasol -> println("Gana Llul con $puntosLull puntos")
        puntosLull < puntosGasol -> println("Gana Gasol con $puntosGasol puntos")
        else -> println("Empate con $puntosLull puntos")
    }
}

fun sumaPuntosTotal(puntuacion: IntArray): Int {
    var suma = 0
    for (i in puntuacion.indices) {
        suma += puntuacion[i]
    }
    return suma
}
