package zoologico

interface Volador {
    val alturaMaxima: Int      // sin valor: la clase lo define
    fun volar()                // sin cuerpo: la clase lo implementa

    // Método con cuerpo: las clases lo reciben ya hecho
    fun aterrizar() {
        println("Aterrizando suavemente")
    }
}