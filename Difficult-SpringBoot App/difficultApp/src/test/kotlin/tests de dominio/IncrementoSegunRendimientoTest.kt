package `tests de dominio`

import ar.com.phm2022.aplicacion.dominio.Pintura
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Dada una pintura")
class IncrementoSegunRendimientoTest {

    val PRECIO_BASE_PINTURA=100.00
    /*
    @BeforeEach
    fun init() {
        pereyra = new Flota => [
                agregarAuto(new Auto("ab028122", 2008))
        // ... se agregan más autos ... //
        ]
    }
     */

    @DisplayName("Si su rendimiento es bajo,no se le aplica un incremento a su precio base")
    @Test
    fun precioFinalPinturaRendimientoBajo(){
        val pinturaRendimientoBajo=Pintura(PRECIO_BASE_PINTURA,0)
        aplicarRendimiento(pinturaRendimientoBajo,8)
        Assertions.assertEquals(100.00,pinturaRendimientoBajo.precio())
    }

    @DisplayName("Si su rendimiento es alto,se le aplica un incremento a su precio base")
    @Test
    fun precioFinalPinturaRendimientoAlto(){
        val pinturaRendimientoAlto=Pintura(PRECIO_BASE_PINTURA,0)
        aplicarRendimiento(pinturaRendimientoAlto,9)
        Assertions.assertEquals(125.00,pinturaRendimientoAlto.precio())
    }

    fun aplicarRendimiento(pintura: Pintura,valor:Int){
        pintura.rendimiento=valor
    }
}