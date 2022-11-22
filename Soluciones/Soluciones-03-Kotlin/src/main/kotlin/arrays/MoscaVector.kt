fun main() {
    val tamaño = 5
    var intentos = 5
    var cazada = false

    var vector = crearVectorMosca(tamaño)

    do {
        // Donde esta la mosca
        val posicion = pedirPosicion(tamaño)
        // Analizar golpe
        // hemos utilizado un inline
        when (analizarGolpeJugador(posicion, vector)) {
            0 -> {
                println("Has fallado")
            }

            1 -> {
                println("Uy, casi has dado a la mosca")
                // Porque debemos sortear la mosca otra vez al moverse
                vector = crearVectorMosca(tamaño)
            }

            2 -> {
                println("Has cazado a la mosca")
                cazada = true
            }
        }
        intentos--
    } while (intentos > 0 && !cazada)

    if (cazada) {
        println("Eres un gran cazador de moscas")
        println("Lo has conseguido en $intentos intentos")
    } else {
        println("Has perdido")

    }
    mostrarVectorMosca(vector)
    println("La mosca estaba en la posición ${getPosicionMosca(vector)}")
}

// Renombrar nombre y parámetros
fun analizarGolpeJugador(posicionAGolpear: Int, vectorPosiciones: IntArray): Int {
    // Utilizamos un early return!
    // ¡Hemos acertado!!
    if (vectorPosiciones[posicionAGolpear] == 1) {
        return 2
    }
    // Extraer a método
    return comprobarPosicionEnLimitesVector(posicionAGolpear, vectorPosiciones)
}

private fun comprobarPosicionEnLimitesVector(posicionAGolpear: Int, vectorPosiciones: IntArray): Int {
    // Comprobamos a derecha e izquierda
    // Sin salirnos de los límites por la izquierda
    // sin salirnos
    if (posicionAGolpear > 0 && vectorPosiciones[posicionAGolpear - 1] == 1) {
        return 1
    }
    // Sin salirnos de los limites por la derecha
    // sin salirnos
    return if (posicionAGolpear < vectorPosiciones.size - 1 && vectorPosiciones[posicionAGolpear + 1] == 1) {
        1
    } else {
        0
    }
}

fun pedirPosicion(tamaño: Int): Int {
    var posicion = 0
    do {
        println("Introduce la posicion de la mosca: ")
        posicion = readln().toIntOrNull() ?: 0
    } while (posicion <= 0 || posicion > tamaño)
    return posicion - 1
}

fun crearVectorMosca(tamaño: Int): IntArray {
    val vector = IntArray(tamaño) { 0 }
    // Sorteo de la posicion de la mosca
    val posicionMosca = (0 until tamaño).random()
    vector[posicionMosca] = 1
    return vector
}

fun mostrarVectorMosca(vector: IntArray) {
    print("[")
    for (i in vector.indices) {
        if (i <= vector.size - 2) {
            print("${casillaVectorMosca(vector[i])}, ")
        } else {
            print(casillaVectorMosca(vector[i]))
        }
    }
    println("]")
}

fun casillaVectorMosca(numero: Int) = when (numero) {
    0 -> " "
    1 -> "\uD83D\uDD4A️"
    else -> "Error"
}


fun getPosicionMosca(vector: IntArray): Int {
    for (i in vector.indices) {
        if (vector[i] == 1) {
            return i + 1
        }
    }
    return -1
}
