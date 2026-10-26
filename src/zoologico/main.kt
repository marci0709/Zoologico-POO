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

fun main() {
    construirZoologico()
}