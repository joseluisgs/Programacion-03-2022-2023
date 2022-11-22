fun main() {
    val array = intArrayOf(1, 2, 3, 4, 5)
    printArray(array)
    val reversedArray= reversedArray(array)
    printArray(reversedArray)

    val arrayDos = intArrayOf(5, 4, 3, 2, 1)

    // son capicuas!!!
    if(compareArray(reversedArray, arrayDos)) {
        println("Son capicuas")
    } else {
        println("No son capicuas")
    }

    val capicua = intArrayOf(1, 2, 3, 2, 1)
    printArray(capicua)
    val reversedCapicua = reversedArray(capicua)
    printArray(reversedCapicua)
    if(compareArray(reversedCapicua, capicua)) {
        println("Son capicuas")
    } else {
        println("No son capicuas")
    }
}