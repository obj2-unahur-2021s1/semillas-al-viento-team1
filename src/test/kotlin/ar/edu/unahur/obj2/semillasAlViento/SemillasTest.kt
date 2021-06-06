package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.shouldBe
class SemillasTest : DescribeSpec({
    describe("Un planta")
    {
        val plantaDeMenta = Menta(3, 2.60)
        val plantaSojaComun = Soja(2020, 3.60, true)
        val plantaSojaTransgenica = Soja(2019, 4.6, false)
        it("Si dan semillas")
        {
            plantaDeMenta.daSemillas().shouldBe(true)
            plantaSojaComun.daSemillas().shouldBe(true)
            plantaSojaTransgenica.daSemillas().shouldBe(false)
        }
        it("Son fuertes")
        {
            plantaDeMenta.esFuerte().shouldBe(true)
            plantaSojaComun.esFuerte().shouldBe(true)
            plantaSojaTransgenica.esFuerte().shouldBe(false)
        }
        describe("parcela") {
            val parcela1 = Parcela(5, 4, 10)
            val parcela2 = Parcela(3, 4, 4)

            parcela1.plantar(plantaDeMenta)
            parcela1.plantar(plantaSojaComun)
            parcela2.plantar(plantaSojaTransgenica)
            parcela2.plantar(plantaSojaComun)

            it("superficie") {
                parcela1.superficie().shouldBe(20)
                parcela2.superficie().shouldBe(12)
            }
            it("cantidad maxima de plantas") {
                parcela1.cantidadMaximaPlantas().shouldBe(4)
                parcela2.cantidadMaximaPlantas().shouldBe(8)
            }
            
            it("tiene complicaciones") { //No existe la funcion para el test
                parcela1.tieneComplicaciones().shouldBeFalse()
                parcela1.plantar(plantaSojaTransgenica)
                parcela1.tieneComplicaciones().shouldBeTrue()
                parcela2.tieneComplicaciones().shouldBeTrue()
            }
        }
    }
})