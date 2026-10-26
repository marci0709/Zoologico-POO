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

class Loro : Animal() {
    override val nombre = "Loro"
    override val dieta = "frugívoro"

    override fun emitirSonido() {
        println("¡Hola, hola!")
    }
}