package `tests de dominio`

import ar.com.phm2022.aplicacion.dominio.AltoTransito
import ar.com.phm2022.aplicacion.dominio.Piso
import ar.com.phm2022.aplicacion.dominio.TransitoNormal
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigDecimal

@DisplayName("Dado un piso")
class IncrementoSegunTipoPisoTests {
    //TODO: Este test da en amarillo porque hasta que no se solucione el calculo del incremento segun el piso, va a  seguir dando mal
    @DisplayName("Si es de tipo Alto Transito,a su precio base se le hace un incremento")
    @Test
    fun precioConIncremeentoAltoTransito(){
        val pisoAltoTransito= Piso(BigDecimal("100.00"),AltoTransito())
        Assertions.assertEquals(BigDecimal("120.0"),pisoAltoTransito.precio())
    }

    @DisplayName("Si es de tipo Transito Normal,a su precio base NO se le hace ningun incremento")
    @Test
    fun precioSinIncrementoTransitoNormal(){
        val pisoTransitoNormal= Piso(BigDecimal("100.00"),TransitoNormal())
        Assertions.assertEquals(BigDecimal("100.0"),pisoTransitoNormal.precio())
    }
}