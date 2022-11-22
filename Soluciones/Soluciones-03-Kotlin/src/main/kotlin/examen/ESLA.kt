package examen

fun main(args: Array<String>) {
    // Constantes
    val NUM_SOLDADOS = 2000
    val SOLDADOS_COTIGENCIA = 20
    var almacen = 39000
    val LIMITE_ALMACEN = 3900
    val TIEMPO_MAXIMO = 7200
    val TIEMPO_CHECK = 200
    val TOTAL_CONTINGENCIAS = NUM_SOLDADOS / SOLDADOS_COTIGENCIA

    var contigenciasVivas = NUM_SOLDADOS / SOLDADOS_COTIGENCIA
    val contigencias = IntArray(contigenciasVivas) { 400 }
    val URUK_PROBABILIDAD = 20
    val TIEMPO_ATAQUE = 50
    var temporizador = 0

    println("*** El Señor de los Anillos ***")
    println("*** Batalla de Mordor ***")
    initContengicas(contigencias)
    printContigencias(contigencias)

    do {
        // Al final
        // temporizador ++; // No lo necesito porque ya espero una oleada
        // Actúan Marry y Pippin abasteciendo las tropas
        if (temporizador % TIEMPO_CHECK == 0) {
            // como no puedo hacer paso por referencia por eso lo devuelvo
            almacen = abastecerTropas(almacen, contigencias)
        }
        // Simulando batalla
        // ¿Que tropa esta siendo atacada? Como no puedo hacer paso por referencia por eso lo devuelvo
        contigenciasVivas = ataqueEnemigo(contigenciasVivas, contigencias, URUK_PROBABILIDAD)

        // Espero otra oleada, esto opcional, comentar si no se usa
        esperarTime(TIEMPO_ATAQUE)
        temporizador += TIEMPO_ATAQUE
    } while (temporizador < TIEMPO_MAXIMO && almacen > LIMITE_ALMACEN)
    printReport(almacen, LIMITE_ALMACEN, contigenciasVivas, TOTAL_CONTINGENCIAS, contigencias)
}

/**
 * abastecerTropas con el almacen
 * @param almacen Int Almacen de armas, como no puedo por el paso por referencia, lo devuelvo
 * @param contigencias IntArray Contigencias
 * @return Int Devuelve el almacen actualizado
 */
private fun abastecerTropas(almacen: Int, contigencias: IntArray): Int {
    var futuroAlmacen = almacen // si no Kotlin me bloquea la rasignación
    println(" --> Merry y Pippin Comprueban estado de contiengecias")
    for (i in contigencias.indices) {
        if (contigencias[i] != 400 && contigencias[i] != -1) {
            futuroAlmacen = restablcerContingencia(contigencias, i, futuroAlmacen)
        }
    }
    return futuroAlmacen // Devuelvo el almacen porque ha cambiado ya que no hay paso por referencia en tipos simples
}

/**
 * Imprime el informe de la batalla
 * @param almacen Int Almacen de armas
 * @param limiteAlmacen Int Limite de almacen
 * @param contigenciasVivas Int Contigencias vivas
 * @param totalContingencias Int Total de contingencias
 * @param contigencias IntArray Contigencias
 */
private fun printReport(
    almacen: Int,
    limiteAlmacen: Int,
    contigenciasVivas: Int,
    totalContingencias: Int,
    contigencias: IntArray
) {
    if (almacen < limiteAlmacen) {
        println("Has perdido la batalla, te has quedado sin suministros")
    } else {
        println("Se ha terminado el programa porque se ha alcanzado el tiempo máximo")
    }
    println("Almacen: $almacen")
    println("Contingencias vivas: $contigenciasVivas")
    println("Contingencias muertas: " + (totalContingencias - contigenciasVivas))
    println("Contingencias: ")
    printContigencias(contigencias)
}

/**
 * Simula el ataque de los enemigos
 * @param contigenciasVivas Int Contigencias vivas como no puedo por el paso por referencia, lo devuelvo
 * @param contigencias IntArray Contigencias
 * @param uruk_probabilidad Int Probabilidad de que sea un uruk hai
 * @return Int Devuelve el numero de contigencias vivas actualizado
 */
private fun ataqueEnemigo(contigenciasVivas: Int, contigencias: IntArray, URUK_PROBABILIDAD: Int): Int {
    var contigenciasActuales = contigenciasVivas
    val numContingencia = alerta(contigenciasActuales, contigencias) // ¿Que contingencia es atacada?
    val enemigos = tropasEnemigas() // ¿Cuantos enemigos son?
    val isUrukHai: Boolean = isUrukHai(URUK_PROBABILIDAD) // ¿Es un uruk hai? lo veremos // ¿hay uruk hai?
    println("Contiencia: $numContingencia esta siendo atacada")
    println("Tropas enemigas que nos atacan: $enemigos y tienen UrukHai: $isUrukHai")
    var victoriaEnOleada = true
    if (contigencias[numContingencia] > enemigos) {
        contigencias[numContingencia] -= enemigos
        victoriaEnOleada = if (isUrukHai) {
            sorteo(75)
        } else {
            sorteo(85)
        }
    } else if (contigencias[numContingencia] < enemigos && enemigos < 10) {
        contigencias[numContingencia] -= enemigos
        victoriaEnOleada = if (isUrukHai) {
            sorteo(35)
        } else {
            sorteo(45)
        }
    } else if (contigencias[numContingencia] < enemigos && enemigos >= 10) {
        contigencias[numContingencia] -= enemigos
        victoriaEnOleada = false
    }

    // Ha caido la contingencia
    if (!victoriaEnOleada) {
        contigenciasActuales--
        contigencias[numContingencia] = -1
    }
    return contigenciasActuales
}

/**
 * Inicia las contingencias con 400 soldados
 * @param contigencias
 */
private fun initContengicas(contigencias: IntArray) {
    for (i in contigencias.indices) {
        contigencias[i] = 400
    }
}

/**
 * Imprime las contingencias
 * @param contigencias
 */
private fun printContigencias(contigencia: IntArray) {
    // No utlizo las funciones de Kotlin contentToString()
    print("contingencia: { ")
    for (j in contigencia) {
        if (j == -1) {
            print("\uD83D\uDC80 ")
        } else {
            print("$j ")
        }
    }
    println("}")
}

/**
 * Restablece la contingencia
 * @param contigencias IntArray Contigencias
 * @param numContingencia Int Numero de contingencia
 * @param almacen Int Almacen de armas como no puedo por el paso por referencia, lo devuelvo
 * @return Int Devuelve el almacen actualizado ya que no hay paso por referencia en tipos simples
 */
private fun restablcerContingencia(contigencia: IntArray, numContingencia: Int, almacen: Int): Int {
    var futuroAlmacen = almacen
    futuroAlmacen -= 400 - contigencia[numContingencia]
    contigencia[numContingencia] = 400
    return futuroAlmacen
}

/**
 * Genera un numero aleatorio entre 1 y 100
 */
private fun sorteo(probabilidad: Int): Boolean {
    return (1..100).random() < probabilidad
}

/**
 * Devuelve la contigencia que es atacada
 * @param contigenciasVivas Int Contigencias vivas
 * @param contigencias IntArray Contigencias
 * @return Int Devuelve la contigencia que es atacada
 */
private fun alerta(totalContingencias: Int, contigencias: IntArray): Int {
    var contingencia = 0
    do {
        contingencia = (0 until totalContingencias).random()
        if (estadoContingencia(contigencias, contingencia) == -1) {
            contingencia = -1
        }
    } while (contingencia == -1)
    return contingencia
}

/**
 * Devuelve el estado de la contingencia
 * @param contigencias IntArray Contigencias
 * @param numContingencia Int Numero de contingencia
 * @return Int Devuelve el estado de la contingencia
 */
private fun estadoContingencia(contigencias: IntArray, numContingencia: Int): Int {
    return contigencias[numContingencia]
}

/**
 * Devuelve el numero de tropas enemigas
 * @return Int Devuelve el numero de tropas enemigas
 */
private fun tropasEnemigas(): Int {
    return (1..15).random()
}

/**
 * Devuelve si es un uruk hai
 * @param uruk_probabilidad Int Probabilidad de que sea un uruk hai
 * @return Boolean Devuelve si es un uruk hai
 */
private fun isUrukHai(probabilidad: Int): Boolean {
    return sorteo(probabilidad)
}

/**
 * Para el programa un tiempo determinado
 * @param tiempo Int Tiempo en milisegundos
 * @throws InterruptedException Excepcion de interrupcin del hilo main
 */
private fun esperarTime(tiempo: Int) {
    Thread.sleep(tiempo.toLong())
}

