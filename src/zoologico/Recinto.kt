package zoologico

class Recinto(var largo: Int = 200, var ancho: Int = 150, var alto: Int = 100) {

    // Bloque init: se ejecuta al crear cada objeto
    init {
        println("Creando recinto...")
    }

    // Constructor secundario: calcula el alto según la cantidad de animales
    constructor(numeroDeAnimales: Int) : this() {
        // 600,000 cm^3 por animal + 10% extra de espacio
        val espacioNecesario = numeroDeAnimales * 600_000 * 1.1
        alto = (espacioNecesario / (largo * ancho)).toInt()
    }

    // Propiedad con getter y setter
    var volumen: Double
        get() = ancho * alto * largo / 1_000_000.0   // 1,000,000 cm^3 = 1 m^3
        set(valor) {
            alto = (valor * 1_000_000 / (ancho * largo)).toInt()
        }

    fun imprimirTamano() {
        println("Recinto: Largo $largo cm, Ancho $ancho cm, Alto $alto cm")
        println("Volumen: $volumen m³")
    }
}