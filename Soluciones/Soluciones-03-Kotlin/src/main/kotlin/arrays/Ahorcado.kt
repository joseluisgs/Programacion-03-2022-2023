fun main() {
    println("Juego del Ahorcado")

    val palabra = palabraAleatoriaDiccionario()
    // println("La palabra a adivinar es: $palabra")

    // val arrayLetras = palabra.toCharArray()
    // val arrayBooleanLetras = BooleanArray(arrayLetras.size)

    val arrayLetras = arrayLetras(palabra)
    // println("Array de letras: ${printArray(arrayLetras)}")
    val arrayBooleanLetras = arrayBoolean(palabra)
    // println("Array de booleans: ${arrayBooleanLetras.contentToString()}")

    var intentos = palabra.length + 3 // Le damos tres vidas!
    var adivinado = false

    do {
        println("Intentos: $intentos")
        println("Palabra:")
        imprimirPalabraSecreta(arrayLetras, arrayBooleanLetras)

        val letra = pedirLetra()
        println("Letra introducida: $letra")
        adivinado = comprobarLetra(letra, arrayLetras, arrayBooleanLetras)

        intentos--
    } while (intentos > 0 && !adivinado)

    if (adivinado) {
        println("Has adivinado la palabra")
        println("Lo has conseguido en $intentos intentos")
    } else {
        println("Has perdido")
    }
    println("La palabra era: $palabra")
}

fun imprimirPalabraSecreta(
    arrayLetras: CharArray,
    arrayBooleanLetras: BooleanArray
) {

    require(arrayLetras.size == arrayBooleanLetras.size) {
        "Los arrays deben tener el mismo tamaño"
    }
    check(arrayLetras.isNotEmpty()) {
        "Los arrays no pueden estar vacíos"
    }

    for (i in arrayLetras.indices) {
        if (arrayBooleanLetras[i]) {
            print("${arrayLetras[i]} ")
        } else {
            print("_ ")
        }
    }
    println()
}

fun comprobarLetra(
    letra: Char,
    arrayLetras: CharArray,
    arrayBooleanLetras: BooleanArray
): Boolean {
    // Recorremos en busca de la letra
    for (i in arrayLetras.indices) {
        if (arrayLetras[i] == letra) {
            arrayBooleanLetras[i] = true
        }
    }

    // solo si todas las letras son true, adivinado es true
    for (i in arrayBooleanLetras.indices) {
        if (!arrayBooleanLetras[i]) {
            return false
        }
    }
    return true
}

fun pedirLetra(): Char {
    do {
        println("Introduce una letra: ")
        val letra = readln().lowercase().firstOrNull() ?: ' '
        // val input = readln().lowercase()
        // val letra = if (input.length == 1) input[0] else ' '
        if (letra.isLetter()) {
            return letra
        } else {
            println("No has introducido una letra")
        }
    } while (true)
}

fun arrayLetras(palabra: String): CharArray {
    val arrayLetras = CharArray(palabra.length)
    for (i in palabra.indices) {
        arrayLetras[i] = palabra[i]
    }
    return arrayLetras
}

fun arrayBoolean(palabra: String): BooleanArray {
    return BooleanArray(palabra.length)
}

fun palabraAleatoriaDiccionario(): String {
    val listaPalabras = arrayOf(
        "portatil", "arbol", "hormiga", "regleta"
    )
    return listaPalabras.random()
    // val randomIndex = (listaPalabras.indices).random()
    // return listaPalabras[randomIndex]
}
