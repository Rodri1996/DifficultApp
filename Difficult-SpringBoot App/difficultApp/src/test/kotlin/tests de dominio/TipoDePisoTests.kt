package `tests de dominio`

import ar.com.phm2022.aplicacion.dominio.Piso
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Dado un piso")
class TipoDePisoTests {

    @DisplayName("Si es de tipo Alto Transito,a su precio base se le hace un incremento")
    @Test
    fun precioFinalPisoAltoTransito(){
        val pisoAltoTransito= Piso(100.00)
        Assertions.assertEquals(0.00,pisoAltoTransito.precio())
    }
}