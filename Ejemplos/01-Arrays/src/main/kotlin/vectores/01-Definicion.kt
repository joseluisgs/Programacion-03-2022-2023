fun main() {
    println("Mis Arrays")

    // Definiciones de arrays
    val intArray = intArrayOf(1, 2, 3, 4, 5) // array inicializado
    val intArrayDeUnElemento = intArrayOf(5) // array de 1 elemento
    val intArray2: Array<Int> = arrayOf(1, 2, 3, 4, 5) // array inicializado
    val intArrayDeUnElemento2: Array<Int> = arrayOf(5) // array  de un elemento
    val intArray3 = IntArray(5) { 6 } // array de 5 elementos con valor 6
    val intArray4 = IntArray(5) { 0 } // array de 5 elementos con valores 0
    val intArray5 = IntArray(5) // array de 5 elementos con valores por defecto
    val intArray6 = Array<Int>(5) { 0 } // array de 5 elementos con valores 0

    println(intArray6.joinToString())
    println(intArray6.size)
    println(intArray6[0])
    println(intArray6[1])
    intArray6[1] = 5
    println(intArray6.joinToString())

    // Doubles
    val doubleArray = doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0) // array inicializado
    val doubleArrayDeUnElemento = doubleArrayOf(5.0) // array de 1 elementos
    val doubleArray2: Array<Double> = arrayOf(1.0, 2.0, 3.0, 4.0, 5.0) // array inicializado
    val doubleArrayDeUnElemento2: Array<Double> = arrayOf(5.0)
    val doubleArray3 = DoubleArray(5) { 6.0 } // array de 5 elementos con valor 6
    val doubleArray4 = DoubleArray(5) { 0.0 } // array de 5 elementos con valores 0
    val doubleArray5 = DoubleArray(5) // array de 5 elementos con valores
    val doubleArray6 = Array<Double>(5) { 0.0 } // array de 5 elementos con valores 0

    println(doubleArray6.joinToString())
    println(doubleArray6.size)
    println(doubleArray6[0])
    println(doubleArray6[1])
    doubleArray6[1] = 5.0
    println(doubleArray6.joinToString())

    // Strings
    val stringArray = arrayOf("uno", "dos", "tres", "cuatro", "cinco") // array inicializado
    val stringArray2 = Array<String>(5) { "0" } // array de 5 elementos con valores 0
    val stringArray3 = Array<String>(5) { "" } // array de 5 elementos con valores ""
    val stringArray4 = Array<String>(5) { "0" } // array de 5 elementos con valores "0"

    println(stringArray4.joinToString())
    println(stringArray4.size)
    println(stringArray4[0])
    println(stringArray4[1])
    stringArray4[1] = "dos"
    println(stringArray4.joinToString())

    // Booleans
    val booleanArray = booleanArrayOf(true, false, true, false, true) // array inicializado
    val booleanArray2 = Array<Boolean>(5) { false } // array de 5 elementos con valores false
    val booleanArray3 = Array<Boolean>(5) { true } // array de 5 elementos con valores true

    println(booleanArray3.joinToString())
    println(booleanArray3.size)
    println(booleanArray3[0])
    println(booleanArray3[1])
    booleanArray3[1] = false
    println(booleanArray3.joinToString())

    // println(booleanArray3[99]) // IndexOutOfBoundsException
    //println(booleanArray3[-1]) // IndexOutOfBoundsException

}