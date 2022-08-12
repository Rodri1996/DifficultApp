package `tests de dominio`

import ar.com.phm2022.aplicacion.dominio.AltoTransito
import ar.com.phm2022.aplicacion.dominio.Lote
import ar.com.phm2022.aplicacion.dominio.Piso
import ar.com.phm2022.aplicacion.dominio.TransitoNormal
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.LocalDate

@DisplayName("Dado un piso")
class PisoTests {

    @Test()
    @DisplayName("Si es de tipo Alto Transito su precio final es su precio base con un incremento del 20%")
    fun calcularPrecioPisoAltoTransito(){
        val pisoAltoTransito = Piso(100.00)
        pisoAltoTransito.tipo = AltoTransito()
        Assertions.assertEquals(120.00,pisoAltoTransito.precio())
    }

    @Test()
    @DisplayName("Si es de tipo Transito Normal su precio final es igual a su precio base")
    fun calcularPrecioPisoTransitoNormal(){
        val pisoTransitoNormal = Piso(100.00)
        pisoTransitoNormal.tipo = TransitoNormal()
        Assertions.assertEquals(100.00,pisoTransitoNormal.precio())
    }

    @Test
    @DisplayName("Se puede descontar unidades disponibles en uno de sus lotes")
    fun descontarUnidadesDisponiblesEnLote(){
        val unLote= Lote(LocalDate.now(),1).apply { numero=1111 }
        val unPiso= Piso(100.00)
        unPiso.agregarLote(unLote)
        unPiso.descontarUnidadesDisponibles(1111)
        Assertions.assertEquals(0,unLote.unidadesDisplonibles)
    }
}