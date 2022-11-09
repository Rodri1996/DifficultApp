package `tests de dominio`

import ar.com.phm2022.aplicacion.dominio.Combo
import ar.com.phm2022.aplicacion.dominio.Pintura
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigDecimal

@DisplayName("Dado un combo con productos")
class PrecioComboTests {

    @DisplayName("Su precio se calcula en base a sus productos")
    @Test
    fun precioComboConProductos(){
        val comboConProductos = Combo()
        val unProducto = Pintura(BigDecimal("100.00"),0)
        comboConProductos.agregarProducto(unProducto)
        Assertions.assertEquals(BigDecimal("102.0"),comboConProductos.precio())
    }
}