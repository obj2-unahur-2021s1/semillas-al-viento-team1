package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
class SemillasTest : DescribeSpec({
    describe("Un planta")
    {
        val plantaDeMenta=Menta(3,2.60)
        val plantaSojaComun=Soja(2020,3.60,true)
        val plantaSojaTransgenica=Soja(2019,4.6,false)
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
    }








})