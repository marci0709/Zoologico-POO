package zoologico

import kotlin.math.PI

open class Recinto(open var largo: Int = 200, open var ancho: Int = 150, open var alto: Int = 100) {

    init {
        println("Creando recinto...")
    }

    constructor(numeroDeAnimales: Int) : this() {
        // 600,000 cm^3 por animal + 10% extra de espacio
        val espacioNecesario = numeroDeAnimales * 600_000 * 1.1
        alto = (espacioNecesario / (largo * ancho)).toInt()
    }

    open var volumen: Double
        get() = ancho * alto * largo / 1_000_000.0   // 1,000,000 cm^3 = 1 m^3
        set(valor) {
            alto = (valor * 1_000_000 / (ancho * largo)).toInt()
        }

    open val tipo = "terrestre"

    // Cada animal terrestre necesita 0.6 m^3
    open val capacidad: Int
        get() = (volumen / 0.6).toInt()

    fun imprimirTamano() {
        println("Tipo: $tipo")
        println("Recinto: Largo $largo cm, Ancho $ancho cm, Alto $alto cm")
        println("Volumen: $volumen m³ | Capacidad: $capacidad animales")
    }
}

class RecintoAviario(override var alto: Int, var diametro: Int) :
    Recinto(alto = alto, ancho = diametro, largo = diametro) {

    // Cilindro: π * r² * h
    override var volumen: Double
        get() = PI * (ancho / 2.0) * (ancho / 2.0) * alto / 1_000_000.0
        set(valor) {
            alto = (valor * 1_000_000 / (PI * (ancho / 2.0) * (ancho / 2.0))).toInt()
        }

    override val tipo = "aviario"

    // Las aves necesitan 1 m^3 cada una
    override val capacidad: Int
        get() = volumen.toInt()
}