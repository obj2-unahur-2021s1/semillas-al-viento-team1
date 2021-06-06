package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
class SemillasTest : DescribeSpec({
    describe(("Semillas al viento"))
    {
        val plantaDeMenta = Menta(3, 2.60f)
        val plantaSojaComun = Soja(2020, 3.60f, false)
        val plantaSojaTransgenica = Soja(2019, 4.6f, true)
        val parcela1 = Parcela(5, 4, 10)
        val parcela2 = Parcela(3, 4, 4)
        val agricultor1 = Agricultora([])
        val agricultor2= Agricultora([parcela1])

        parcela1.plantar(plantaDeMenta)
        parcela1.plantar(plantaSojaComun)
        parcela2.plantar(plantaSojaTransgenica)
        parcela2.plantar(plantaSojaComun)
        it("Si dan semillas")
        {
            plantaDeMenta.daSemillas().shouldBeTrue()
            plantaSojaComun.daSemillas().shouldBeTrue()
            plantaSojaTransgenica.daSemillas().shouldBeFalse()
        }
        it("Son fuertes")
        {
            plantaDeMenta.esFuerte().shouldBeFalse()
            plantaSojaComun.esFuerte().shouldBeFalse()
            plantaSojaTransgenica.esFuerte().shouldBeTrue()
        }
        describe("Requerimientos de parcelas")
        {
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
        describe("Requerimientos de agricultores")
        {
            agricultor1.parcelasSemilleras().shouldBe([parcela1,parcela2])

        }

    }
})