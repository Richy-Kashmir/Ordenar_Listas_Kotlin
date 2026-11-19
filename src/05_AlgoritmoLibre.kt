
class BubbleSort {

  //Ejecuta el algoritmo Bubble Sort sobre las listas de vehículos y números.

    fun ejecutar() {
        Utilidades.mostrarCabecera("05 - BUBBLE SORT (algoritmo libre)")

        val tiempoVehiculos = procesarLista("Vehículos", GenerarDatos.listaVehiculos)
        val tiempoNumeros = procesarLista("Números", GenerarDatos.listaNumeros)

        TablaResultados.registrar("Bubble Sort", tiempoVehiculos, tiempoNumeros)
    }

    // Ordena midiendo el tiempo y muestra el resultado.

    private fun <T : Comparable<T>> procesarLista(nombre: String, original: List<T>): Long {
        val copia = original.toMutableList()

        Utilidades.mostrarLista("Lista original de $nombre", copia)

        val inicio = System.nanoTime()
        bubbleSort(copia)
        val fin = System.nanoTime()

        Utilidades.mostrarLista("Lista ordenada de $nombre", copia)
        Utilidades.mostrarTiempo(fin - inicio)

        return fin - inicio
    }

    // Algoritmo Bubble Sort optimizado.

    private fun <T : Comparable<T>> bubbleSort(lista: MutableList<T>) {
        val n = lista.size

        for (pasada in 0 until n - 1) {
            // Variable para saber si en esta pasada hemos movido algo
            var hayIntercambio = false

            // En cada pasada los últimos elementos ya están colocados, por eso restamos "pasada"
            for (j in 0 until n - 1 - pasada) {
                if (lista[j].compareTo(lista[j + 1]) > 0) {
                    intercambiar(lista, j, j + 1)
                    hayIntercambio = true
                }
            }

            // Si no ha habido ningún intercambio, la lista ya está ordenada
            if (!hayIntercambio) {
                break
            }
        }
    }

   // Intercambia dos elementos de la lista usando una variable auxiliar.

    private fun <T> intercambiar(lista: MutableList<T>, a: Int, b: Int) {
        val aux = lista[a]
        lista[a] = lista[b]
        lista[b] = aux
    }
}
