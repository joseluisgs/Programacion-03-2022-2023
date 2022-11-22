package examen

const val LUKE = -1
const val LIBRE = 0
const val ESPACIO = 7
const val MAX_ENEMIGOS = 25
const val TIME_MAX = 10_000
const val MAX_ENERGIA = 10
const val ESPERA = 1000
const val PROB_DAÑO = 25

var escudosEnergia = MAX_ENERGIA
var enemigosAbatidos = 0
var espacio = Array(ESPACIO) { IntArray(ESPACIO) }

fun main() {
    println("En una galaxia muy muy lejana...")

    // Enemigos
    val enemigos = pedirEnemigos()

    iniciarEspacio(espacio, enemigos)
    println("El espacio Inicial antes de la batalla:")
    printEspacio(espacio)

    // Batalla
    val escudosEnergia = batallaEstelar(enemigos)

    informeResultados(espacio, enemigos, escudosEnergia)

}

private fun batallaEstelar(enemigos: Int): Int {

    var time = 0

    // doble_buffer
    var matrixLectura = clonarMatriz(espacio)
    do {
        // doble_buffer
        val matrixEscritura = clonarMatriz(matrixLectura)

        // Acción de Luke
        realizarAccionLuke(matrixLectura, matrixEscritura)

        // Recibimos daño!!
        escudosEnergia += probabilidadDaño(PROB_DAÑO)

        // Cambiamos las matrices doble_buffer
        matrixLectura = clonarMatriz(matrixEscritura)

        printEspacio(matrixLectura)
        Thread.sleep(ESPERA.toLong())
        time += ESPERA
    } while (time < TIME_MAX && enemigosAbatidos != enemigos && escudosEnergia > 0)

    // Para que estacio sea la última matriz
    espacio = clonarMatriz(matrixLectura)

    return escudosEnergia
}

fun realizarAccionLuke(matrixLectura: Array<IntArray>, matrixEscritura: Array<IntArray>) {
    // Donde esta luke?
    val posicionLuke = buscarLuke(matrixLectura)
    println("Luke esta en la posicion: ${posicionLuke[0] + 1}, ${posicionLuke[1] + 1}")
    // Miramos en las 8 direcciones y masacramos a los enemigos
    for (i in -1..1) {
        for (j in -1..1) {
            if (posicionLuke[0] + i in 0 until ESPACIO
                && posicionLuke[1] + j >= 0
                && posicionLuke[1] + j < ESPACIO
            ) {
                if (matrixLectura[posicionLuke[0] + i][posicionLuke[1] + j] > 0) {
                    // Si fuera masacre ponemos LIBRE
                    println("Luke ha masacrado a un enemigo en la posicion: ${posicionLuke[0] + i + 1} ${posicionLuke[1] + j + 1}")
                    matrixEscritura[posicionLuke[0] + i][posicionLuke[1] + j]--
                    enemigosAbatidos++
                }
            }
        }
    }

    // Movemos a Luke a una posicion aleatoria libre
    val nuevaPosicionLuke = moverLuke(matrixLectura)
    println("Luke se ha movido a la posicion: ${nuevaPosicionLuke[0] + 1}, ${nuevaPosicionLuke[1] + 1}")
    matrixEscritura[nuevaPosicionLuke[0]][nuevaPosicionLuke[1]] = LUKE
    // La antigua posicion de luke la ponemos LIBRE
    matrixEscritura[posicionLuke[0]][posicionLuke[1]] = LIBRE

}

fun moverLuke(matrixLectura: Array<IntArray>): IntArray {
    val posicionLibre = IntArray(2) { -1 }
    do {
        posicionLibre[0] = (0 until ESPACIO).random()
        posicionLibre[1] = (0 until ESPACIO).random()
    } while (matrixLectura[posicionLibre[0]][posicionLibre[1]] != LIBRE)

    return posicionLibre
}

fun buscarLuke(matrixLectura: Array<IntArray>): IntArray {
    for (i in matrixLectura.indices) {
        for (j in matrixLectura[i].indices) {
            if (matrixLectura[i][j] == LUKE) {
                return intArrayOf(i, j)
            }
        }
    }
    return intArrayOf(-1, -1)
}

fun probabilidadDaño(limite: Int): Int {
    val probabilidad = (1..100).random()
    return if (probabilidad <= limite) {
        println("Luke ha recibido un golpe, su escudo ha perdido un punto de energía")
        -1
    } else {
        0
    }
}

private fun informeResultados(espacio: Array<IntArray>, enemigos: Int, escudosEnergia: Int) {
    println("El espacio Final despues de la batalla:")
    printEspacio(espacio)
    // Analisis de resultados
    if (enemigosAbatidos == enemigos) {
        println("\uD83C\uDF89 ¡¡¡ Han ganado al imperio, Luke ha sobrevivido !!!")
    } else if (escudosEnergia == 0) {
        println("\uD83D\uDC80 Han ganado los imperiales, has muerto")
    } else {
        println("✨ Has tardado demasiado, pero Luke ha sobrevivido y escapa")
    }
    println("Enemigos restantes: ${enemigos - enemigosAbatidos}")
    println("Escudos y Energia restantes: $escudosEnergia")
    println("Enemigos abatidos: $enemigosAbatidos")

}

fun printEspacio(espacio: Array<IntArray>) {
    for (fila in espacio) {
        for (columna in fila) {
            when (columna) {
                LUKE -> print(" L ")
                LIBRE -> print(" . ")
                else -> print(" $columna ")
            }
        }
        println()
    }
    println()
}

fun pedirEnemigos(): Int {
    do {
        print("¿Cuántos enemigos quieres? ")
        val enemigos = readln().toIntOrNull() ?: 0
        if (enemigos in 1..MAX_ENEMIGOS)
            return enemigos
        else
            println("El número de enemigos debe estar entre 1 y $MAX_ENEMIGOS")
    } while (true)
}

fun iniciarEspacio(espacio: Array<IntArray>, enemigos: Int) {

    // Ponemos todo a cero
    for (i in 0 until ESPACIO) {
        for (j in 0 until ESPACIO) {
            espacio[i][j] = LIBRE
        }
    }

    // Colocamos a Luke en una posicion aleatoria
    val filaLuke = (0 until ESPACIO).random()
    val columnaLuke = (0 until ESPACIO).random()
    espacio[filaLuke][columnaLuke] = LUKE

    // Para cada enemigo, se pueden poner en cualquier posicion
    // que no sea la de Luke
    repeat(enemigos) {
        // Buscamos una posicion que no esté luke e incrementamos
        var fila: Int
        var columna: Int
        do {
            fila = (0 until ESPACIO).random()
            columna = (0 until ESPACIO).random()
        } while (espacio[fila][columna] == LUKE)
        // Colocamos el enemigo // Aumentamos el valor en esa casilla
        espacio[fila][columna]++
    }
}

fun clonarMatriz(matriz: Array<IntArray>): Array<IntArray> {
    val clon = Array(matriz.size) { IntArray(matriz[0].size) }
    for (i in matriz.indices) {
        for (j in matriz[0].indices) {
            clon[i][j] = matriz[i][j]
        }
    }
    return clon
}
