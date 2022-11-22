/**
 * Devuelve un array invertido
 * @param array el array a invertir
 * @return el array invertido
 */
fun reversedArray(array: IntArray): IntArray {
    val result = IntArray(array.size)
    for (i in array.indices) {
        result[i] = array[array.size - i - 1]
    }
    return result
}

/**
 * Imprime un array
 * @param array el array a imprimir
 */
fun printArray(array: IntArray) {
    print("[")
    for (i in array.indices) {
        if (i <= array.size - 2) {
            print("${array[i]}, ")
        } else {
            print("${array[i]}")
        }
    }
    println("]")
}

fun printArray(array: CharArray) {
    print("[")
    for (i in array.indices) {
        if (i <= array.size - 2) {
            print("${array[i]}, ")
        } else {
            print("${array[i]}")
        }
    }
    println("]")
}


/**
 * Compara dos arrays
 * @param arrayUno el primer array
 * @param arrayDos el segundo array a comparar
 * @return true si son iguales, false si no lo son
 */
fun compareArray(arrayUno: IntArray, arrayDos: IntArray): Boolean {
    for (i in arrayUno.indices) {
        if (arrayUno[i] != arrayDos[i]) {
            return false
        }
    }
    return true
}