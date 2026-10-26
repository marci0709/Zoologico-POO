package zoologico

abstract class Animal {
    abstract val nombre: String
    abstract val dieta: String

    // Método abstracto: cada animal lo implementa a su manera
    abstract fun emitirSonido()

    // Método concreto: lo heredan todos tal cual
    fun presentarse() {
        println("Soy $nombre y mi dieta es $dieta")
    }
}

class Leon : Animal() {
    override val nombre = "León"
    override val dieta = "carnívoro"

    override fun emitirSonido() {
        println("¡Roooaaar!")
    }
}

class Loro : Animal(), Volador {
    override val nombre = "Loro"
    override val dieta = "frugívoro"
    override val alturaMaxima = 100

    override fun emitirSonido() {
        println("¡Hola, hola!")
    }

    override fun volar() {
        println("El loro vuela entre los árboles (altura máxima: $alturaMaxima m)")
    }
}

class Aguila : Animal(), Volador {
    override val nombre = "Águila"
    override val dieta = "carnívoro"
    override val alturaMaxima = 3000

    override fun emitirSonido() {
        println("¡Kiiii!")
    }

    override fun volar() {
        println("El águila planea sobre las montañas (altura máxima: $alturaMaxima m)")
    }
}