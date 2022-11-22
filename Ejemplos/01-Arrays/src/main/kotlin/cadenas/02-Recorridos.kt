package cadenas

fun main() {
    val cadena = "En un lugar de la Mancha de cuyo nombre no quiero acordarme"
    // También están indexados

    // Recorrido con for
    for (i in cadena.indices) {
        println(cadena[i])
    }

    // Recorrido con for each
    for (i in cadena) {
        println(i)
    }

    // Recorrido con while
    var i = 0
    while (i < cadena.length) {
        println(cadena[i])
        i++
    }

    // for con until
    for (i in cadena.length - 1 downTo 0) {
        println(cadena[i])
    }
    // for reverse y paso dos
    for (i in cadena.indices.reversed() step 2) {
        println(cadena[i])
    }
}