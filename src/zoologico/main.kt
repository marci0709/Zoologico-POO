package zoologico

fun construirZoologico() {
    val recinto1 = Recinto()
    recinto1.imprimirTamano()

    val recinto2 = Recinto(largo = 300, alto = 150)
    recinto2.imprimirTamano()

    // Constructor secundario
    val recinto3 = Recinto(numeroDeAnimales = 5)
    recinto3.imprimirTamano()

    // Setter del volumen
    val recinto4 = Recinto(numeroDeAnimales = 5)
    recinto4.imprimirTamano()
    recinto4.volumen = 4.5
    recinto4.imprimirTamano()

    val aviario = RecintoAviario(diametro = 400, alto = 300)
    aviario.imprimirTamano()
}
fun crearAnimales() {
    val leon = Leon()
    val loro = Loro()
    val aguila = Aguila()

    leon.presentarse()
    leon.emitirSonido()

    loro.presentarse()
    loro.emitirSonido()
    loro.volar()
    loro.aterrizar()

    aguila.presentarse()
    aguila.emitirSonido()
    aguila.volar()
    aguila.aterrizar()

    // Polimorfismo: una lista de la interfaz con objetos distintos
    println("--- Todos los voladores ---")
    val voladores: List<Volador> = listOf(loro, aguila)
    for (volador in voladores) {
        volador.volar()
    }
}
// when con un String: devuelve los kg de alimento según la dieta
fun calcularAlimentoDiario(animal: Animal): Int {
    return when (animal.dieta) {
        "carnívoro" -> 5
        "frugívoro" -> 1
        else -> 2
    }
}

// if como expresión: decide el lugar según el tipo de animal
fun asignarRecinto(animal: Animal): String {
    return if (animal is Volador) "aviario" else "recinto terrestre"
}

// when sin argumento: usa condiciones con rangos
fun clasificarVuelo(volador: Volador): String {
    return when {
        volador.alturaMaxima < 500 -> "vuelo bajo"
        volador.alturaMaxima < 2000 -> "vuelo medio"
        else -> "vuelo alto"
    }
}

// Función que devuelve un Boolean
fun puedeAlojar(recinto: Recinto, cantidad: Int): Boolean {
    return cantidad <= recinto.capacidad
}

// if / else que devuelve un mensaje
fun verificarAlojamiento(nombre: String, recinto: Recinto, cantidad: Int): String {
    return if (puedeAlojar(recinto, cantidad)) {
        "$nombre SÍ puede alojar $cantidad animales"
    } else {
        "$nombre NO puede alojar $cantidad animales (capacidad: ${recinto.capacidad})"
    }
}
fun gestionarZoologico() {
    println("=== GESTIÓN DEL ZOOLÓGICO ===")

    // val = inmutable, var = mutable
    val recintoTerrestre = Recinto(largo = 250, ancho = 200, alto = 170)
    val aviario = RecintoAviario(diametro = 400, alto = 300)
    val nombreZoo: String = "Zoológico Andino"
    var totalAnimales: Int = 0
    var alimentoTotal: Int = 0
    val animales = listOf(Leon(), Loro(), Aguila())

    println("Bienvenidos al $nombreZoo")

    for (animal in animales) {
        totalAnimales++
        val alimento = calcularAlimentoDiario(animal)
        alimentoTotal += alimento
        println("${animal.nombre}: come $alimento kg/día -> ${asignarRecinto(animal)}")
    }

    println("Total de animales: $totalAnimales")
    println("Alimento total diario: $alimentoTotal kg")

    println(verificarAlojamiento("Recinto terrestre", recintoTerrestre, 15))
    println(verificarAlojamiento("Aviario", aviario, 10))

    for (animal in animales) {
        if (animal is Volador) {
            println("${animal.nombre} -> ${clasificarVuelo(animal)}")
        }
    }
}

fun main() {
    construirZoologico()
    crearAnimales()
    gestionarZoologico()
}