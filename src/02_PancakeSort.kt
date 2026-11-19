

class PancakeSort {

   // Función que ejecuta el algoritmo Pancake Sort.
    fun ejecutar() {
        Utilidades.mostrarCabecera("02 - PANCAKE SORT")

        val tiempoVehiculos = procesarLista("Vehículos", GenerarDatos.listaVehiculos)
        val tiempoNumeros = procesarLista("Números", GenerarDatos.listaNumeros)

        TablaResultados.registrar("Pancake Sort", tiempoVehiculos, tiempoNumeros)
    }

   // Función que devuelve el tiempo en nanosegundos.
    private fun <T : Comparable<T>> procesarLista(nombre: String, original: List<T>): Long {
        val copia = original.toMutableList()

        Utilidades.mostrarLista("Lista original de $nombre", copia)

        val inicio = System.nanoTime()
        pancakeSort(copia)
        val fin = System.nanoTime()

        Utilidades.mostrarLista("Lista ordenada de $nombre", copia)
        Utilidades.mostrarTiempo(fin - inicio)

        return fin - inicio
    }

    // Función que implementa el algoritmo Pancake Sort.
    private fun <T : Comparable<T>> pancakeSort(lista: MutableList<T>) {
        var tamagno = lista.size

        while (tamagno > 1) {
            // Busca el mayor elemento.
            val posicionMayor = buscarPosicionMayor(lista, tamagno)

            // Si el mayor ya está al final de la parte desordenada, no lo volteará
            if (posicionMayor != tamagno - 1) {

                // Sube todo desde la posición 0.
                voltear(lista, posicionMayor)

                // Baja al final de la parte desordenada.
                voltear(lista, tamagno - 1)
            }

            // Ese último elemento ya está en su sitio, así que la parte desordenada se reduce
            tamagno--
        }
    }

    // Función que busca la posición del mayor elemento.
    private fun <T : Comparable<T>> buscarPosicionMayor(lista: MutableList<T>, tamanio: Int): Int {
        // Variable que guarda la posición del mayor elemento.
        var posicionMayor = 0

        // Recorre la lista desde la posición 1 hasta el final de la parte desordenada.
        for (i in 1 until tamanio) {
            if (lista[i].compareTo(lista[posicionMayor]) > 0) {
                posicionMayor = i
            }
        }
        return posicionMayor
    }

    // Función para voltear la lista desde la posicion 0.
    private fun <T> voltear(lista: MutableList<T>, hasta: Int) {
        // Variables que marcan el inicio y el final de la parte que se va a voltear.
        var inicio = 0
        var fin = hasta

        // Mientras no se crucen, intercambia los elementos de inicio y fin.
        while (inicio < fin) {
            val aux = lista[inicio]
            lista[inicio] = lista[fin]
            lista[fin] = aux
            inicio++
            fin--
        }
    }
}
