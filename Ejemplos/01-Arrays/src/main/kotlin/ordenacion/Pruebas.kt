package ordenacion

fun main() {
    val vectorInicial = IntArray(50_000) { (0..1000000000).random() }

    var timeIni = 0L
    var timeFin = 0L

    // Probamos burbuja
    val vectorBurbuja = vectorInicial.clone()
    timeIni = System.currentTimeMillis()
    bubbleSort(vectorBurbuja)
    timeFin = System.currentTimeMillis()
    println("Tiempo burbuja: ${timeFin - timeIni} ms")
    // println("Contenido vector burbuja: ${vectorBurbuja.contentToString()}")
    // println("¿Está ordenado? ${vectorBurbuja.contentEquals(vectorInicial.sortedArray())}")

    // Probamos selección
    val vectorSeleccion = vectorInicial.clone()
    timeIni = System.currentTimeMillis()
    selectionSort(vectorSeleccion)
    timeFin = System.currentTimeMillis()
    println("Tiempo selección: ${timeFin - timeIni} ms")
    // println("Contenido vector selección: ${vectorSeleccion.contentToString()}")
    // println("¿Está ordenado? ${vectorSeleccion.contentEquals(vectorInicial.sortedArray())}")

    // Probamos inserción
    val vectorInsercion = vectorInicial.clone()
    timeIni = System.currentTimeMillis()
    insertionSort(vectorInsercion)
    timeFin = System.currentTimeMillis()
    println("Tiempo inserción: ${timeFin - timeIni} ms")
    // println("Contenido vector inserción: ${vectorInsercion.contentToString()}")
    //println("¿Está ordenado? ${vectorInsercion.contentEquals(vectorInicial.sortedArray())}")

    // Probamos shell
    val vectorShell = vectorInicial.clone()
    timeIni = System.currentTimeMillis()
    shellSort(vectorShell)
    timeFin = System.currentTimeMillis()
    println("Tiempo shell: ${timeFin - timeIni} ms")
    // println("Contenido vector shell: ${vectorShell.contentToString()}")
    // println("¿Está ordenado? ${vectorShell.contentEquals(vectorInicial.sortedArray())}")

    // Probamos quicksort
    val vectorQuick = vectorInicial.clone()
    timeIni = System.currentTimeMillis()
    quickSort(vectorQuick)
    timeFin = System.currentTimeMillis()
    println("Tiempo quick: ${timeFin - timeIni} ms")
    // println("Contenido vector quicksort: ${vectorQuick.contentToString()}")
    //println("¿Está ordenado? ${vectorQuick.contentEquals(vectorInicial.sortedArray())}")

    // Contra el método de ordenación de Kotlin: Doble Pivot QuickSort
    val vectorKotlin = vectorInicial.clone()
    timeIni = System.currentTimeMillis()
    vectorKotlin.sortedArray()
    timeFin = System.currentTimeMillis()
    println("Tiempo kotlin: ${timeFin - timeIni} ms")

    val elementoParaBuscar = vectorInicial.random()

    timeIni = System.nanoTime()
    linearSearch(vectorInicial, elementoParaBuscar)
    timeFin = System.nanoTime()
    println("Tiempo búsqueda lineal: ${timeFin - timeIni} ns")

    // Busqueda binaria
    val vectorOrdenado = vectorInicial.sortedArray()
    timeIni = System.nanoTime()
    binarySearch(vectorOrdenado, elementoParaBuscar)
    timeFin = System.nanoTime()
    println("Tiempo búsqueda binaria: ${timeFin - timeIni} ns")

    // Búsqueda de Kotlin
    timeIni = System.nanoTime()
    vectorOrdenado.binarySearch(elementoParaBuscar)
    timeFin = System.nanoTime()
    println("Tiempo búsqueda binaria de Kotlin: ${timeFin - timeIni} ns")
    

}