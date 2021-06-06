package ar.edu.unahur.obj2.semillasAlViento

abstract class Planta(val anioObtencionSemilla: Int, var altura: Float) {
//Se dice que una planta es fuerte si tolera más de 10 horas de sol al día, esto es igual
// para todas las plantas. El cálculo de las horas de sol que tolera depende exclusivamente de cada especie (ver más abajo).
  fun esFuerte() = this.horasDeSolQueTolera() > 10

  fun parcelaTieneComplicaciones(parcela: Parcela) =
    parcela.plantas.any { it.horasDeSolQueTolera() < parcela.horasSolPorDia }


  abstract fun horasDeSolQueTolera(): Int
  abstract fun daSemillas(): Boolean

}

class Menta(anioObtencionSemilla: Int, altura: Float) : Planta(anioObtencionSemilla, altura) {
  override fun horasDeSolQueTolera() = 6
  override fun daSemillas() = this.esFuerte() || altura > 0.4
}

class Soja(anioObtencionSemilla: Int, altura: Float, val esTransgenica: Boolean) : Planta(anioObtencionSemilla, altura) {
  override fun horasDeSolQueTolera(): Int  {
    // ¡Magia de Kotlin! El `when` es como un `if` pero más poderoso:
    // evalúa cada línea en orden y devuelve lo que está después de la flecha.
    val horasBase = when {
      altura < 0.5  -> 6
      altura < 1    -> 7
      else          -> 9
    }

    return if (esTransgenica) horasBase * 2 else horasBase
  }



  override fun daSemillas(): Boolean  {

    return !this.esTransgenica || this.esFuerte() || (this.anioObtencionSemilla > 2007 && this.altura > 1)
  }
}
