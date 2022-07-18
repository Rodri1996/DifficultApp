package `tests de dominio`

import dominio.Combo
import dominio.Lote
import dominio.Piso
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.LocalDate

@DisplayName("Dado un combo con productos")
class CombosTests {

    @Test
    @DisplayName("Podemos calcular su precio como la sumatoria de precios de cada producto que contiene")
    fun calcularPrecioDeCombo(){
        val combo1= Combo()
        val producto1=Piso(100.00)
        combo1.productos.add(producto1)
        Assertions.assertEquals(102.00,combo1.precio())
    }

    @Test
    @DisplayName("Se puede descontar unidades disponibles en uno de sus lotes")
    fun descontarUnidadesDisponiblesEnLote(){
        val unLote=Lote(LocalDate.now(),1).apply { numero=1111 }
        val unCombo=Combo()
        unCombo.agregarLote(unLote)
        unCombo.descontarUnidadesDisponibles(1111)
        Assertions.assertEquals(0,unLote.unidadesDisplonibles)
    }
}