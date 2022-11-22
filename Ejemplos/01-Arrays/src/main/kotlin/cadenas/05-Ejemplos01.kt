package cadenas

fun main() {
    val mensaje = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme..."

    // ¿Está acordarme?
    println(mensaje.contains("acordarme"))

    // Eliminar la coma ,
    println(mensaje.replace(",", ""))

    // Poner la decima palabra en mayúsculas
    val palabras = mensaje.split(" ").toTypedArray()
    for (palabras in palabras) {
        println(palabras)
    }
    palabras[9] = palabras[9].uppercase()
    println(palabras[9])

    val mensaje2 = palabras.joinToString(" ")
    println(mensaje2)

    // esto no se ve muy bien!!!
    val mensaje3 = palabras.contentToString()
    println(mensaje3)

    // No lo sabes o se te va de la cabeza!!! Hazlo tú!!!!
    val myBuilder = StringBuilder()
    for (palabra in palabras) {
        myBuilder.append(palabra)
        myBuilder.append(" ")
    }
    println(myBuilder.toString())

    // Tomamos la última palabra
    // val ultimaPalabra = palabras[palabras.size - 1]
    var ultimaPalabra = palabras.last()
    // Las letras pares en mayúscula las impares en minúscula
    var ultimaPalabraMayusculaMinuscula = cambiarMayusculaMinuscula(ultimaPalabra)
    println(ultimaPalabraMayusculaMinuscula)
    // Lo juntamos
    palabras[palabras.size - 1] = ultimaPalabraMayusculaMinuscula
    val mensaje4 = palabras.joinToString(" ")
    println(mensaje4)

    // Todo con string builder
    val sb = StringBuilder(mensaje)
    //  me quedo con la ultima
    ultimaPalabra = sb.substring(sb.lastIndexOf(" ") + 1)
    println(ultimaPalabra)
    // Cambio las letras pares en mayúscula las impares en minúscula
    ultimaPalabraMayusculaMinuscula = cambiarMayusculaMinuscula(ultimaPalabra)
    println(ultimaPalabraMayusculaMinuscula)
    // Lo juntamos
    // sb.replace(sb.lastIndexOf(" ") + 1, sb.length, ultimaPalabraMayusculaMinuscula)
    // val mensaje5 = sb.toString()
    val mensaje5 = sb.toString().replace(ultimaPalabra, ultimaPalabraMayusculaMinuscula)
    println(mensaje5)

    println(mensaje)
    val textoCifrado = cifrarCesar(mensaje, 90)
    println(textoCifrado)
    val textoDescifrado = cifrarCesar(textoCifrado, 90)
    println(textoDescifrado)
}

fun cifrarCesar(mensaje: String, desplazamiento: Int): String {
    val alafabeto =
        " " +
                "abcdefghijklmnñopqrstuvwxyz" +
                "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ1234567890" +
                ".,;:?¡!()[]{}@#\$%&/\\\"'çÇáéíóúÁÉÍÓÚ" +
                "àèìòùÀÈÌÒÙâêîôûÂÊÎÔÛäëïöüÄËÏÖÜãõÃÕ"

    val sb = StringBuilder()

    val desplazamiento = desplazamiento % alafabeto.length

    for (caracter in mensaje) {
        val posicion = alafabeto.indexOf(caracter)
        if (posicion == -1) {
            sb.append(caracter)
        } else {
            if (posicion + desplazamiento < 0) {
                sb.append(alafabeto[alafabeto.length + (posicion + desplazamiento)])
            } else {
                sb.append(alafabeto[(posicion + desplazamiento) % alafabeto.length])
            }
        }
    }
    return sb.toString()
}

fun cambiarMayusculaMinuscula(ultimaPalabra: String): String {
    // Opción a con Builder
    val myBuilder = StringBuilder()
    for (i in ultimaPalabra.indices) {
        if (i % 2 == 0) {
            myBuilder.append(ultimaPalabra[i].uppercase())
        } else {
            myBuilder.append(ultimaPalabra[i].lowercase())
        }
    }
    return myBuilder.toString()

    // La opción B es de nuevpo pasarlo a aun array de caracteres
    /*val array = ultimaPalabra.toCharArray()
    for (i in array.indices) {
        if (i % 2 == 0) {
            array[i] = array[i].uppercaseChar()
        } else {
            array[i] = array[i].lowercaseChar()
        }
    }
    return array.concatToString()*/

    // opción C es solo con un string, se ve guay pero es ineficiente un objeto nuevo
    /*var resultado = ""
    for (i in ultimaPalabra.indices) {
        if (i % 2 == 0) {
            resultado += ultimaPalabra[i].uppercase()
        } else {
            resultado += ultimaPalabra[i].lowercase()
        }
    }
    return resultado*/
}
