
class MergeSort {

    // Función que ejecuta el algoritmo y registra los tiempos.
    fun ejecutar() {
        Utilidades.mostrarCabecera("03 - MERGESORT")

        val tiempoVehiculos = procesarLista("Vehículos", GenerarDatos.listaVehiculos)
        val tiempoNumeros = procesarLista("Números", GenerarDatos.listaNumeros)

        TablaResultados.registrar("MergeSort", tiempoVehiculos, tiempoNumeros)
    }


    private fun <T : Comparable<T>> procesarLista(nombre: String, original: List<T>): Long {
        val copia = original.toMutableList()

        Utilidades.mostrarLista("Lista original de $nombre", copia)

        val inicio = System.nanoTime()
        val ordenada = mergeSort(copia)
        val fin = System.nanoTime()

        Utilidades.mostrarLista("Lista ordenada de $nombre", ordenada)
        Utilidades.mostrarTiempo(fin - inicio)

        return fin - inicio
    }

    // Función recursiva de MergeSort. Devuelve una nueva lista ordenada.
    private fun <T : Comparable<T>> mergeSort(lista: MutableList<T>): MutableList<T> {
        // Caso base: una lista de 0 o 1 elementos ya está ordenada
        if (lista.size <= 1) {
            return lista
        }

        // Calculamos la mitad
        val mitad = lista.size / 2

        // Creamos las dos mitades copiando los elementos a mano
        val izquierda = mutableListOf<T>()
        val derecha = mutableListOf<T>()
        for (i in 0 until mitad) {
            izquierda.add(lista[i])
        }
        for (i in mitad until lista.size) {
            derecha.add(lista[i])
        }

        // Ordenamos cada mitad (llamada recursiva) y después las mezclamos
        val izquierdaOrdenada = mergeSort(izquierda)
        val derechaOrdenada = mergeSort(derecha)

        return mezclar(izquierdaOrdenada, derechaOrdenada)
    }

    // Función que mezcla dos listas ordenadas en una sola lista ordenada.
    private fun <T : Comparable<T>> mezclar(izquierda: MutableList<T>, derecha: MutableList<T>): MutableList<T> {
        val resultado = mutableListOf<T>()
        var i = 0 // posición en la lista izquierda
        var j = 0 // posición en la lista derecha

        // Mientras queden elementos en las dos listas, cogemos el menor
        while (i < izquierda.size && j < derecha.size) {
            if (izquierda[i].compareTo(derecha[j]) <= 0) {
                resultado.add(izquierda[i])
                i++
            } else {
                resultado.add(derecha[j])
                j++
            }
        }

        // Añadimos lo que quede en la lista izquierda (si queda algo)
        while (i < izquierda.size) {
            resultado.add(izquierda[i])
            i++
        }

        // Añadimos lo que quede en la lista derecha (si queda algo)
        while (j < derecha.size) {
            resultado.add(derecha[j])
            j++
        }

        return resultado
    }
}
