package cadenas

fun main() {
    // Un string es inmutable
    val cadena = "Hola"
    println(cadena)
    println(cadena[0])
    println(cadena[1])
    // cadena[2] = "O" Es inmutable
    // cadena = "Adios" // No nos deja porque es val, constante

    var mensaje = "Hola"
    println(mensaje)
    // OJO; que en el fondo ha cambiado la referencia
    mensaje = "Adios"
    mensaje = "$mensaje mundo"
    mensaje += "!!"
    println(mensaje)

    // Se crean 1000 objetos String cambiando la refrencia
    for (i in (1..1000)) {
        mensaje += "!!"
    }
    println(mensaje)

    // Se crea un solo objeto String cambiando la referencia
    // Es mutable!!!
    val mensajeBuilder = StringBuilder()
    println(mensajeBuilder)
    mensajeBuilder.append("Hola")
    mensajeBuilder[0] = 'A'
    println(mensajeBuilder)
    for (i in (1..1000)) {
        mensajeBuilder.append("!!")
    }
    mensaje = mensajeBuilder.toString()
    println(mensaje)
}