package `tests de dominio`

import ar.com.phm2022.aplicacion.dominio.Lote
import ar.com.phm2022.aplicacion.dominio.Piso
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.LocalDate

@DisplayName("Dado un producto con lotes")
class ProductoAntiguedadTests {

    var fechaAntiguaLimite=LocalDate.now().minusMonths(4)

    @DisplayName("Si alguno de sus lotes es antiguo,se le aplica un descuento a su precio base")
    @Test
    fun descuentoPorLoteAntiguo(){
        val productoConAlgunLoteAntiguo=Piso(100.00)
        var fechaPosteriorAlLimite=fechaAntiguaLimite.minusDays(1)
        val loteAntiguo=Lote(fechaPosteriorAlLimite,0)
        productoConAlgunLoteAntiguo.agregarLote(loteAntiguo)
        Assertions.assertEquals(90.00,productoConAlgunLoteAntiguo.precio())
    }

    @DisplayName("Si alguno de sus lotes NO es antiguo,NO se le aplica ningun descuento a su precio base")
    @Test
    fun descuentoPorLoteNoAntiguo(){
        val productoConNingunLoteAntiguo=Piso(100.00)
        val loteAntiguo=Lote(fechaAntiguaLimite,0)
        productoConNingunLoteAntiguo.agregarLote(loteAntiguo)
        Assertions.assertEquals(100.00,productoConNingunLoteAntiguo.precio())
    }
}