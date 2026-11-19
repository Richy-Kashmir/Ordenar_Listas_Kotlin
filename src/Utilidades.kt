

object Utilidades {

    // Se usa <T> (genérico) para que la misma función sirva tanto para String como para Int.

    fun <T> mostrarLista(titulo: String, lista: List<T>) {
        println("$titulo (${lista.size} elementos):")
        println(lista.joinToString(", "))
        println()
    }

    // Convierte nanosegundos a milisegundos y lo muestra. 1 milisegundo = 1.000.000 nanosegundos.

    fun mostrarTiempo(nanosegundos: Long) {
        val milisegundos = nanosegundos / 1_000_000.0
        println("Tiempo de ordenación: $nanosegundos ns (${"%.4f".format(milisegundos)} ms)")
        println()
    }

    // Imprime una línea de separación con el nombre del algoritmo, para que la salida se lea mejor.

    fun mostrarCabecera(nombreAlgoritmo: String) {
        println("=".repeat(70))
        println("   $nombreAlgoritmo")
        println("=".repeat(70))
    }
}

// Guarda los tiempos de todos los algoritmos para mostrar al final una tabla comparativa. Cada algoritmo llama a registrar() cuando termina.

object TablaResultados {

    // Lista de filas. Cada fila guarda: nombre del algoritmo, tiempo con vehículos y tiempo con números.
    private val filas = mutableListOf<Triple<String, Long, Long>>()

    fun registrar(algoritmo: String, tiempoVehiculos: Long, tiempoNumeros: Long) {
        filas.add(Triple(algoritmo, tiempoVehiculos, tiempoNumeros))
    }

    // Muestra todos los resultados
    fun mostrar() {
        println("=".repeat(70))
        println("   TABLA COMPARATIVA DE TIEMPOS")
        println("=".repeat(70))
        println(String.format("%-20s %22s %22s", "Algoritmo", "Vehículos (ns)", "Números (ns)"))
        println("-".repeat(70))
        for (fila in filas) {
            println(String.format("%-20s %22d %22d", fila.first, fila.second, fila.third))
        }
        println("-".repeat(70))
        println("Nota: el primer algoritmo que se ejecuta suele salir algo más lento porque")
        println("la máquina virtual de Java todavía se está \"calentando\" (JIT).")
    }
}
