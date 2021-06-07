package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
class SemillasTest : DescribeSpec({
    describe(("Semillas al viento"))
    {
        //Plantas
        val plantaDeMenta = Menta(3, 2.60f)
        val plantaSojaComun = Soja(2020, 3.60f, false)
        val plantaSojaTransgenica = Soja(2019, 4.6f, true)
        val plantaSojaComun2= Soja(2006,2.5f,false)
        val plantaSojaTransgenica2=Soja(2017,1.7f,true)
        val plantaDeMenta2= Menta(2010,3.8f)
        //Parcelas
        val parcela1 = Parcela(5, 4, 10)
        val parcela2 = Parcela(3, 4, 4)
        val parcela3 = Parcela(5, 7, 10)
        v
        //Agricultores
        val agricultor1 = Agricultora(mutableListOf(parcela1))

        val agricultor2= Agricultora(mutableListOf(parcela1,parcela2))



        it("Si dan semillas")
        {
            plantaDeMenta.daSemillas().shouldBeTrue()
            plantaSojaComun.daSemillas().shouldBeTrue()
            plantaSojaTransgenica.daSemillas().shouldBeFalse()
            plantaSojaComun2.daSemillas().shouldBeFalse()
            plantaDeMenta2.daSemillas().shouldBeTrue()
            plantaSojaTransgenica2.daSemillas().shouldBeFalse()
        }
        it("Son fuertes")
        {
            plantaDeMenta.esFuerte().shouldBeFalse()
            plantaSojaComun.esFuerte().shouldBeFalse()
            plantaSojaTransgenica.esFuerte().shouldBeTrue()
            plantaDeMenta2.esFuerte().shouldBeFalse()
            plantaSojaComun2.esFuerte().shouldBeFalse()
            plantaSojaTransgenica2.esFuerte().shouldBeTrue()
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
            parcela1.plantar(plantaSojaTransgenica)
            parcela2.plantar(plantaDeMenta)
            parcela2.plantar(plantaSojaComun)
            agricultor1.parcelasSemilleras().shouldBe(mutableListOf())
            agricultor2.parcelasSemilleras().shouldBe(mutableListOf(parcela2))

        }

    }
})