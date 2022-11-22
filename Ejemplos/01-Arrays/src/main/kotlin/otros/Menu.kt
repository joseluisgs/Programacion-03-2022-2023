package otros

import kotlin.system.exitProcess

fun main() {
    do {
        val opcion = menuOpciones()
        println("Has elegido la opción $opcion")
        procesarOpcionMenu(opcion)
    } while (opcion != 0)
}

fun procesarOpcionMenu(opcion: Int) {
    when (opcion) {
        1 -> println("Acción opción 1")
        2 -> println("Acción opción 2")
        3 -> println("Acción opción 3")
        4 -> {
            println("Adíos... \uD83D\uDC4B")
            exitProcess(0)
        } // Salimos
    }
}

fun menuOpciones(): Int {
    do {
        // Presentamos la opción
        println("[1] Opción 1")
        println("[2] Opción 2")
        println("[3] Opción 3")
        println("[4] Salir")

        // Leer opción
        val opcion = readln().toIntOrNull() ?: 0
        // Early return
        if (opcion in 1..4) {
            return opcion
        }
        println("Opción incorrecta. Pulse una opción entre 1 y 4")
    } while (true)
}

