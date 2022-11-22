package exp_regulares

fun main() {
    val stringPalabras = "   Hola, soy un string con varias palabras  "
    println(stringPalabras)
    // Limpiamos los espacios en blanco al principio y al final
    val stringPalabrasSinBlancos = stringPalabras.trim()
    println(stringPalabrasSinBlancos)
    val palabrasArray = stringPalabrasSinBlancos
        .split(" ")
        .toTypedArray()

    // Sacar cuantas palabras tenemos
    println("El string tiene ${palabrasArray.size} palabras")
    // imprimir el array
    println(palabrasArray.contentToString())

    val cadenaFromArray = palabrasArray.joinToString(" ")
    println(cadenaFromArray)

}