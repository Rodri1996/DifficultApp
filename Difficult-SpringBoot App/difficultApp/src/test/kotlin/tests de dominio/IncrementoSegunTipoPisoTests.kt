package `tests de dominio`

import ar.com.phm2022.aplicacion.dominio.AltoTransito
import ar.com.phm2022.aplicacion.dominio.Piso
import ar.com.phm2022.aplicacion.dominio.TransitoNormal
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Dado un piso")
class IncrementoSegunTipoPisoTests {

    @DisplayName("Si es de tipo Alto Transito,a su precio base se le hace un incremento")
    @Test
    fun precioConIncremeentoAltoTransito(){
        val pisoAltoTransito= Piso(100.00)
        pisoAltoTransito.tipo=AltoTransito()
        Assertions.assertEquals(120.00,pisoAltoTransito.precio())
    }

    @DisplayName("Si es de tipo Transito Normal,a su precio base NO se le hace ningun incremento")
    @Test
    fun precioSinIncrementoTransitoNormal(){
        val pisoTransitoNormal= Piso(100.00)
        pisoTransitoNormal.tipo=TransitoNormal()
        Assertions.assertEquals(100.00,pisoTransitoNormal.precio())
    }
}