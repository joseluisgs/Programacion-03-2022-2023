package cadenas

fun main() {
    var mensaje = "En un lugar de la Mancha de cuyo nombre no quiero acordarme"

    // Longitud
    println(mensaje.length)

    // imprimir el caracter de una posicion
    println(mensaje[4])

    // pasar a mayúsculas
    println(mensaje.uppercase())

    // pasar a minúsculas
    println(mensaje.lowercase())

    // Contiene una subcadena
    println(mensaje.contains("lugar"))
    println(mensaje.contains("I love Kotlin"))

    // Pasar a array de caracteres
    val array = mensaje.toCharArray()
    array[0] = array[0].uppercaseChar()

    // De array de caracteres a string
    mensaje = array.concatToString()
    println(mensaje)

    // Obtener una subcadena entre indices
    println(mensaje.substring(3, 12))

    // Obtener un array de cadenas, en base a un separador
    val palabras = mensaje.split(" ").toTypedArray()
    for (palabra in palabras) {
        println(palabra)
    }

    // Eliminar un caracter o subcadena
    println(mensaje.replace(" ", ""))
}