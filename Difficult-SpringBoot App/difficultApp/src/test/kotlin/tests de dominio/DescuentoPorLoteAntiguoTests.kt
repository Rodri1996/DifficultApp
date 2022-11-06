package `tests de dominio`

import ar.com.phm2022.aplicacion.dominio.Lote
import ar.com.phm2022.aplicacion.dominio.Pintura
import ar.com.phm2022.aplicacion.dominio.Piso
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.LocalDate

@DisplayName("Dado un producto con lotes")
class DescuentoPorLoteAntiguoTests {

    var fechaAntiguaLimite=LocalDate.now().minusMonths(4)
    var fechaAnteriorAFechaLimite=fechaAntiguaLimite.minusDays(1)
    val loteAntiguo=Lote(fechaAnteriorAFechaLimite,0)

    @DisplayName("Si es piso y tiene algun lote antiguo,se le aplica un descuento a su precio base")
    @Test
    fun descuentoPiso(){
        val pisoConLoteAntiguo=Piso(
            100.00,
        "",
        "",
        "",
        0)
        pisoConLoteAntiguo.agregarLote(loteAntiguo)
        Assertions.assertEquals(90.00,pisoConLoteAntiguo.precio())
    }

    @DisplayName("Si es pintura y tiene algun lote antiguo, se le aplica un descuento a su precio base")
    @Test
    fun descuentoPintura(){
        val pinturaConLoteAntiguo=Pintura(100.00,"","","",0)
        pinturaConLoteAntiguo.agregarLote(loteAntiguo)
        Assertions.assertEquals(90.00,pinturaConLoteAntiguo.precio())
    }
}