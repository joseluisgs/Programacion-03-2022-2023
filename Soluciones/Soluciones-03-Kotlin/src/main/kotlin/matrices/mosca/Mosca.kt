package matrices.mosca

import matrices.mosca.types.Columnas
import matrices.mosca.types.Coordenada
import matrices.mosca.types.Matriz
import mosca.*


/**
 * Mosca en la Matriz
 */
fun main() {
    println("Mosca Matriz")
    var numCasillas = 10
    val MOSCA = 1

    // pedir numero de intentos
    var numIntentos = getNumeroIntentos()
    // Pedir tamaño de Matriz
    numCasillas = getNumeroCasillas()

    val casillas = Matriz(numCasillas) { Columnas(numCasillas) }

    // Todas las casillas son 0 menos la de la mosca
    iniciarCasillas(casillas)

    // Situar la mosca en el vector
    situarMosca(casillas, MOSCA)
    imprimirCasillas(casillas)

    var estaMuerta = false
    var posMosca: Coordenada

    println("Atrapa a la Mosca")

    do {
        // Pedirle la posición donde vas a dar un tortazo
        posMosca = posicionGolpear(casillas)

        // Anlizamos el Golpeo
        estaMuerta = analizarGolpeo(MOSCA, casillas, posMosca)
        imprimirCasillas(casillas)

        numIntentos--
        if (numIntentos > 0) {
            println("Te quedan $numIntentos intentos")
        }
    } while (!estaMuerta && numIntentos > 0)

    if (estaMuerta)
        println("¡Has cazado a la maldita mosca!")
    else
        println("¡Has perdido!")

    posMosca = buscarMosca(MOSCA, casillas)
    if (posMosca[0] != -1)
        println("La mosca está en la posición: {${posMosca[0] + 1},${posMosca[1] + 1}}")
    imprimirCasillas(casillas)

}

