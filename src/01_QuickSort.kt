


class QuickSort {

    // Metodo principal que ordena las listas.
    fun ejecutar() {
        Utilidades.mostrarCabecera("01 - QUICKSORT")

        val tiempoVehiculos = procesarLista("Vehículos", GenerarDatos.listaVehiculos)
        val tiempoNumeros = procesarLista("Números", GenerarDatos.listaNumeros)

        TablaResultados.registrar("QuickSort", tiempoVehiculos, tiempoNumeros)
    }


   // Función que devuelve el tiempo en nanosegundos.
    private fun <T : Comparable<T>> procesarLista(nombre: String, original: List<T>): Long {

        // Aquí hace una COPIA para no modificar la lista original
        val copia = original.toMutableList()

        Utilidades.mostrarLista("Lista original de $nombre", copia)

        // Se mide solo el tiempo que tarda la ordenación
        val inicio = System.nanoTime()
        quickSort(copia, 0, copia.size - 1)
        val fin = System.nanoTime()

        Utilidades.mostrarLista("Lista ordenada de $nombre", copia)
        Utilidades.mostrarTiempo(fin - inicio)

        return fin - inicio
    }

    // Función recursiva de QuickSort.

    private fun <T : Comparable<T>> quickSort(lista: MutableList<T>, izquierda: Int, derecha: Int) {

        // Este "if" ordena la lista de forma recursiva.
        if (izquierda >= derecha) {
            return
        }

        // El pivote se colocará en su sitio y obtendrá su posición
        val posicionPivote = particion(lista, izquierda, derecha)

        // En la parte de la izquierda se ordenara el pivote y luego en la parte de la derecha
        quickSort(lista, izquierda, posicionPivote - 1)
        quickSort(lista, posicionPivote + 1, derecha)
    }

   // Función que pone el pivote en su posición y devuelve su índice.
    private fun <T : Comparable<T>> particion(lista: MutableList<T>, izquierda: Int, derecha: Int): Int {
        val pivote = lista[derecha]

        // "i" marca hasta dónde llegan los elementos menores que el pivote
        var i = izquierda - 1

        for (j in izquierda until derecha) {

            // compareTo devuelve un número negativo si lista[j] es menor que el pivote
            if (lista[j].compareTo(pivote) < 0) {
                i++
                intercambiar(lista, i, j)
            }
        }

        // Ponemos el pivote en su posición definitiva
        intercambiar(lista, i + 1, derecha)
        return i + 1
    }

    // Función para intercambiar dos elementos.
    private fun <T> intercambiar(lista: MutableList<T>, a: Int, b: Int) {
        val aux = lista[a]
        lista[a] = lista[b]
        lista[b] = aux
    }
}
