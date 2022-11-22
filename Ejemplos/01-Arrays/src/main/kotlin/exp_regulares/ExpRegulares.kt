package exp_regulares


fun main() {
    println("Dime tu DNI: ")
    val dni = readln()

    val isDNI = isDNIValidoManual(dni.uppercase())
    println("El DNI $dni es ${if (isDNI) "válido" else "inválido"}")
    when (isDNIValidoManualCodigoError(dni.uppercase())) {
        0 -> println("El DNI $dni es válido")
        -1 -> println("El DNI $dni es inválido porque no tiene 9 caracteres")
        -2 -> println("El DNI $dni es inválido, no se ha introducido una letra válida")
        -3 -> println("El DNI $dni es inválido, no es la letra correcta")
        -4 -> println("El DNI $dni es inválido, no se ha introducido un número válido")
    }

    try {
        isDNIValidoExcepciones(dni.uppercase())
        println("El DNI $dni válido")
    } catch (e: Exception) {
        println("El DNI $dni es inválido, ${e.message}")
    }

    try {
        isDNIValidoConExpRegular(dni.uppercase())
        println("El DNI $dni válido")
    } catch (e: Exception) {
        println("El DNI $dni es inválido, ${e.message}")
    }

    try {
        isDNIValidoConExpRegular(dni.uppercase())
        println("El DNI $dni válido")
    } catch (e: Exception) {
        println("El DNI $dni es inválido, ${e.message}")
    }
}

/**
 * Comprueba si un DNI es válido o no
 * @param dni DNI a comprobar
 * @return true si es válido, false si no lo es
 *
 * PROBLEMA: No ofrece información del tipo de error
 */
fun isDNIValidoManual(dni: String): Boolean {
    // Early return
    if (dni.length != 9) return false
    if (dni.last() !in 'A'..'Z') return false
    if (!checkLetraDNI(dni)) return false
    // Ver si el resto son números
    val numeros = dni.substring(0, dni.length - 1)
    for (c in numeros) {
        if (c !in '0'..'9') return false
    }
    return true
}

/**
 * Comprueba si la letra del DNI es correcta
 * @param dni DNI a comprobar
 * @return 0 si es correcta, -1..., -2..., -3..., -4... si no lo es
 */
fun isDNIValidoManualCodigoError(dni: String): Int {
    // Early return
    if (dni.length != 9) return -1
    if (dni.last() !in 'A'..'Z') return -2
    if (!checkLetraDNI(dni)) return -3
    // Ver si el resto son números
    val numeros = dni.substring(0, dni.length - 1)
    for (c in numeros) {
        if (c !in '0'..'9') return -4
    }
    return 0
}

fun isDNIValidoExcepciones(dni: String): Boolean {
    // Von excepciones con requiere y propias
    require(dni.length == 9) { "El DNI debe tener 9 caracteres" }
    require(dni.last() in 'A'..'Z') { "El DNI debe terminar en una letra entre A y Z" }
    require(checkLetraDNI(dni)) { "La letra del DNI no es correcta" }
    // Ver si el resto son números
    val numeros = dni.substring(0, dni.length - 1)
    for (c in numeros) {
        if (c !in '0'..'9') throw IllegalArgumentException("El DNI debe contener solo números")
    }
    return true
}

fun checkLetraDNI(dni: String): Boolean {
    val letras = "TRWAGMYFPDXBNJZSQVHLCKE"
    val numero = dni.substring(0, dni.length - 1).toInt()
    println("Número: $numero")
    val letra = dni.last()
    return letras[numero % 23] == letra
}

fun isDNIValidoConExpRegular(dni: String): Boolean {
    // Expresión regular
    val regex = Regex("[0-9]{8}[A-Z]")
    val regex2 = """\d{8}[A-Z]""".toRegex()
    if (!regex.matches(dni)) throw IllegalArgumentException("El DNI no tiene el formato correcto")
    if (!checkLetraDNI(dni)) throw IllegalArgumentException("La letra del DNI no es correcta")
    return true
}

fun isDNIValidoConExpRegularOpt(dni: String): Boolean {
    require(Regex("[0-9]{8}[A-Z]").matches(dni)) { "El DNI no tiene el formato correcto" }
    require(checkLetraDNI(dni)) { "La letra del DNI no es correcta" }
    return true
}
