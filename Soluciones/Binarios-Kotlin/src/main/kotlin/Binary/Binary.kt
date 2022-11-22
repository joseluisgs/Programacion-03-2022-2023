import kotlin.math.abs
import kotlin.math.max
import kotlin.math.pow

// Mi librería de Datos para trabajar con Binarios

/**
 * Lee un número binario desde la consola
 */
fun readBinary(): IntArray {
    var line: String
    // Leemos un número y solo debe tener 0s y 1s
    do {
        println("Intrdouzca el número binario: ")
        line = readLine().toString(); // Leemos de la consola y lo pasamos a String
    } while (!isBinary(line))

    // Ahora los tranformamos a vector de enteros
    return toIntVector(line)
}

/**
 * Transforma una cadena de 1 y 0 en un vector de enteros de 1 y 0
 */
fun toIntVector(line: String): IntArray {
    val res = IntArray(line.length) // Con esto creamos en vector []
    for (i in res.indices) {
        // cada caracter a string lo tengo que pasar a entero, la otra forma es Character.getNumericValue(number)
        res[i] = line[i].toString().toInt()
    }
    return res
}

/**
 * Comprueba si una cadena es un número binario, es decir solo tiene 1s y 0s
 */
fun isBinary(line: String): Boolean {
    var isBinary = true
    var i = 0
    while (i < line.length && isBinary) {
        isBinary = line[i] == '0' || line[i] == '1'
        i++
    }
    return isBinary
}

/**
 * Imprime un vector binario
 */
fun printBinary(binary: IntArray) {
    for (i in binary) {
        print(i)
    }
    println()
}

/**
 * Trasforma un vector de binarios en un entero
 */
fun binaryToDecimal(num: IntArray): Int {
    var res = 0
    for (i in num.indices.reversed()) {
        res += (num[i] * 2.0.pow((num.size - i - 1))).toInt()
    }
    return res
}

/**
 * da la vuelta a un vector, no es necesario gracias a Kotlin
 */
fun reverse(num: IntArray): IntArray {
    val res = IntArray(num.size)
    // invertimos el vector
    for (i in num.indices) {
        res[i] = num[num.size - 1 - i]
    }
    return res
}

/**
 * Redimensiona in vector
 */
fun resize(num: IntArray, max: Int): IntArray {
    val res = IntArray(max)
    // lo coloco de atras adelante, los 0 que añado se quedan al comienzo
    var j = max - 1
    for (i in num.indices.reversed()) {
        res[j] = num[i]
        j--
    }
    return res
}

/**
 * Suma dos vectores binarios
 */
fun add(num1: IntArray, num2: IntArray): IntArray {
    // Debemos tener el mismo tamaño
    var num1 = num1
    var num2 = num2
    val max = max(num1.size, num2.size)

    if (num1.size < num2.size) num1 = resize(num1, max) else num2 = resize(num2, max)

    // Ahora los sumamos, es uno mas para el acarreo el vector que tenemos
    val res = IntArray(max + 1)
    var carry = 0
    // Lo voy a hacer sin invertir
    var j = max
    for (i in num1.indices.reversed()) {
        // sumamos el carry y el elemento de la posición i
        val sum = num1[i] + num2[i] + carry
        // si la suma es mayor que 1, el carry es 1
        carry = if (sum > 1) 1 else 0
        // el resto es el resultado, porque el módulo es 1 o 2
        res[j] = sum % 2
        j--
    }
    // si el carry es 1, lo metemos al final (o posición 0)
    if (carry == 1) {
        res[0] = 1
    }
    return res
}

/**
 * Resto dos vectores
 */
fun subtract(num1: IntArray, num2: IntArray): IntArray {
    // Debemos tener el mismo tamaño
    var num1 = num1
    var num2 = num2
    val max = max(num1.size, num2.size)
    // con el ternario
    //int max = num1.length > num2.length ? num1.length : num2.length;

    // Ahora los dos vectores deben tener el mismo tamaño
    if (num1.size < num2.size) num1 = resize(num1, max) else num2 = resize(num2, max)

    // Ahora los restamos, el tamaño siempre es el del mayor
    val res = IntArray(max)
    var carry = 0
    // Lo voy a hacer sin invertir
    var j = max - 1
    for (i in num1.indices.reversed()) {
        // restamos el carry y el elemento de la posición i
        val sum = num1[i] - num2[i] - carry
        // si la resta es menor que 0, el carry es 1
        carry = if (sum < 0) 1 else 0
        res[j] = abs(sum % 2)
        j--
    }
    return res
}
