/**
 * Main de Binarios
 */

// Lo bueno que tiene Kotlin es que no necesitamos iniciar nada, solo una función llamada main
fun main(args: Array<String>) {
    println("Hola Kotlin DAM - Binarios")

    println("Trabajando con Binarios")

    // Leemos un número binario y lo transformamos en vector de enterios de 1 y 0
    val binary = readBinary();
    printBinary(binary);

    // Pasamos a decimal
    val dec = binaryToDecimal(binary);
    println("Decimal: $dec");

    val num1 = intArrayOf(1, 1, 1) // Es {1,1,1};
    val num2 = intArrayOf(1, 0, 0, 0) // {1,0,0,0};

    // Vamos a sumar

    // Vamos a sumar
    print("num1: ")
    printBinary(num1)
    print("num2: ")
    printBinary(num2)
    print("Suma: ")
    val sum = add(num1, num2)
    printBinary(sum)

    val sub = subtract(num2, num1)
    print("Resta: ")
    printBinary(sub)


}