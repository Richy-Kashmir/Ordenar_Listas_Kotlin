import kotlin.random.Random


object GenerarDatos {

    // Lista de vehículos. Al usar el objeto se rellena una vez.
    val listaVehiculos: MutableList<String> = generarVehiculos()

    // Lista de números aleatorios. También se genera una única vez.
    val listaNumeros: MutableList<Int> = generarNumeros()

    // Función que genera la lista de vehículos.
    private fun generarVehiculos(): MutableList<String> {
        val vehiculos = mutableListOf(
            "Toyota Corolla", "Seat Ibiza", "Ford Focus", "Renault Clio", "Audi A3",
            "Volkswagen Golf", "Peugeot 208", "BMW Serie 1", "Kia Sportage", "Hyundai Tucson",
            "Mercedes Clase A", "Opel Corsa", "Citroen C3", "Dacia Sandero", "Fiat 500",
            "Nissan Qashqai", "Mazda CX-5", "Honda Civic", "Skoda Octavia", "Tesla Model 3",
            "Volvo XC60", "Jeep Renegade", "Mini Cooper", "Cupra Formentor", "Suzuki Swift",
            "Land Rover Defender", "Porsche 911", "Alfa Romeo Giulia", "Lexus NX", "Mitsubishi ASX",
            "Subaru Forester", "Chevrolet Camaro", "Ferrari Roma", "Lamborghini Urus", "Jaguar F-Pace",
            "Smart ForTwo", "Ds 7", "Lancia Ypsilon", "Maserati Ghibli", "Ssangyong Korando",
            "Yamaha MT-07", "Kawasaki Ninja", "Vespa Primavera", "Harley Davidson Sportster", "Ducati Monster"
        )
        vehiculos.shuffle()
        return vehiculos
    }

    // Función que genera la lista de números aleatorios.
    private fun generarNumeros(): MutableList<Int> {
        val numeros = mutableListOf<Int>()

        while (numeros.size < 100) {
            // Random.nextInt(desde, hasta) -> el "hasta" no se incluye, por eso ponemos 10001
            val numero = Random.nextInt(1, 10001)

            // Comprobamos que no esté repetido antes de añadirlo
            if (!numeros.contains(numero)) {
                numeros.add(numero)
            }
        }
        return numeros
    }
}
