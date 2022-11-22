package examen

var ALTITUD_INDEX = 0
var VELOCIDAD_INDEX = 1
var parametrosVuelo = IntArray(2)
var constantesVuelo = IntArray(2)
const val MAX_TIME = 5000
const val PROBABILIDAD_FALLO = 1 // 1%

fun main() {
    var cronometro = 0

    // Pedimos los parámetros de vuelo
    pedirParametrosDeVuelo()

    // Experimento es que empiece cerca de la alitud fijada por arriba o abajo
    parametrosVuelo[ALTITUD_INDEX] = constantesVuelo[ALTITUD_INDEX] + (-200..200).random()
    parametrosVuelo[VELOCIDAD_INDEX] = constantesVuelo[VELOCIDAD_INDEX] + (-200..200).random()

    do {
        println("Hola soy el piloto automático mi tiempo es $cronometro")
        // Comprobar y corregir altitud
        val altitud = altitud() // Por utilizar estas funciones
        if (constantesVuelo[ALTITUD_INDEX] > altitud) {
            println("Subiendo el avión de altura")
            aumentar('a')
        } else if (constantesVuelo[ALTITUD_INDEX] < altitud) {
            println("Bajando el avión de altura")
            disminuir('a')
        }

        // Comprobar y corregir velocidad
        // Es una locura hacerlo así se haría como la altura!!!!
        val velocidad = IntArray(1)  // Por utilizar estas funciones
        velocidad(velocidad)
        if (constantesVuelo[VELOCIDAD_INDEX] > velocidad[0]) {
            println("Acelerando el avión de velocidad")
            aumentar('v')
        } else if (constantesVuelo[VELOCIDAD_INDEX] < velocidad[0]) {
            println("Desacelerando el avión de velocidad")
            disminuir('v')
        }

        println("Altura actual: ${parametrosVuelo[ALTITUD_INDEX]}")
        println("Velocidad actual: ${parametrosVuelo[VELOCIDAD_INDEX]}")


        // Al final
        esperar(200)
        cronometro += 200
    } while (cronometro <= MAX_TIME && !falloSistema())

    if (cronometro > MAX_TIME) {
        println("El piloto automático ha terminado su tiempo de ejecución")
    } else {
        println("El piloto automático ha detectado un fallo en el sistema volviendo a control manual")
    }
}

fun pedirParametrosDeVuelo() {
    do {
        println("Introduce la altura de vuelo (entre 1000 y 5000 metros)")
        constantesVuelo[ALTITUD_INDEX] = readln().toIntOrNull() ?: 0
    } while (constantesVuelo[ALTITUD_INDEX] < 1000 || constantesVuelo[ALTITUD_INDEX] > 5000)

    do {
        println("Introduce la velocidad de vuelo (entre 500 y 700 km/h)")
        constantesVuelo[VELOCIDAD_INDEX] = readln().toIntOrNull() ?: 0
    } while (constantesVuelo[VELOCIDAD_INDEX] < 500 || constantesVuelo[VELOCIDAD_INDEX] > 700)
}

fun falloSistema() = ((1..100).random() <= PROBABILIDAD_FALLO)


fun altitud(): Int {
    return parametrosVuelo[ALTITUD_INDEX]
}

// Esto es una locura hacerlo así para un solo parámetro y se haría como la altura
fun velocidad(parametros: IntArray) {
    parametros[0] = parametrosVuelo[VELOCIDAD_INDEX]
}

fun esperar(tiempo: Int) {
    Thread.sleep(tiempo.toLong())
}

fun aumentar(parametro: Char) {
    when (parametro) {
        'a' -> parametrosVuelo[ALTITUD_INDEX] += 10
        'v' -> parametrosVuelo[VELOCIDAD_INDEX] += 10
    }
}

fun disminuir(parametro: Char) {
    when (parametro) {
        'a' -> parametrosVuelo[ALTITUD_INDEX] -= 10
        'v' -> parametrosVuelo[VELOCIDAD_INDEX] -= 10
    }
}
