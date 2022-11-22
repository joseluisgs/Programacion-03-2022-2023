package cadenas

// Argumentos de entrada
fun main(args: Array<String>) {
    // if (args.size == 0) {
    if (args.isEmpty()) {
        println("No hay argumentos de entrada")
    } else {
        println("Argumentos de entrada:")
        for (i in args.indices) {
            println("args[$i] = ${args[i]}")
        }
    }
}