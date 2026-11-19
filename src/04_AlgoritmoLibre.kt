
class InsertionSort {

    // Ordena 2 listas (Vehículos y Números) y registra los tiempos en la tabla de resultados.
    fun ejecutar() {
        Utilidades.mostrarCabecera("04 - INSERTION SORT (algoritmo libre)")

        val tiempoVehiculos = procesarLista("Vehículos", GenerarDatos.listaVehiculos)
        val tiempoNumeros = procesarLista("Números", GenerarDatos.listaNumeros)

        TablaResultados.registrar("Insertion Sort", tiempoVehiculos, tiempoNumeros)
    }



     // Ordena midiendo el tiempo y muestra el resultado.
    private fun <T : Comparable<T>> procesarLista(nombre: String, original: List<T>): Long {
        val copia = original.toMutableList()

        Utilidades.mostrarLista("Lista original de $nombre", copia)

        val inicio = System.nanoTime()
        insertionSort(copia)
        val fin = System.nanoTime()

        Utilidades.mostrarLista("Lista ordenada de $nombre", copia)
        Utilidades.mostrarTiempo(fin - inicio)

        return fin - inicio
    }

// Función de algoritmo Insertion Sort.

    private fun <T : Comparable<T>> insertionSort(lista: MutableList<T>) {
        // Empezamos en la posición 1 porque un solo elemento (el 0) ya está "ordenado"
        for (i in 1 until lista.size) {
            // Guardamos el elemento que queremos colocar
            val actual = lista[i]
            var j = i - 1

            // Mientras el de la izquierda sea mayor, lo desplazamos una posición a la derecha
            while (j >= 0 && lista[j].compareTo(actual) > 0) {
                lista[j + 1] = lista[j]
                j--
            }

            // Colocamos el elemento en el hueco que ha quedado
            lista[j + 1] = actual
        }
    }
}
