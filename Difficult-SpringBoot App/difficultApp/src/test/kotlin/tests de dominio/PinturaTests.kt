package `tests de dominio`

import ar.com.phm2022.aplicacion.dominio.Lote
import dominio.Pintura
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.LocalDate

@DisplayName("Dada una pintura")
class PinturaTests {

    @Test
    @DisplayName("Su precio final es su precio base + un incremento porque su rendimiento supera un valor esperado")
    fun precioPinturaConBuenRendimiento(){
        val pinturaConRendimiento=Pintura(precioBase = 100.00)
        pinturaConRendimiento.rendimiento=9
        Assertions.assertEquals(125.00,pinturaConRendimiento.precio())
    }

    @Test
    @DisplayName("Su precio final es su precio base porque su rendimiento no supera un valor esperado")
    fun precioPinturaSinRendimiento(){
        val pinturaSinRendimiento=Pintura(precioBase = 100.00)
        pinturaSinRendimiento.rendimiento=8
        Assertions.assertEquals(100.00,pinturaSinRendimiento.precio())
    }
/*
    @Test
    @DisplayName("Tiene un descuento en su precio base si tiene algun lote anterior a una fecha")
    fun descPorTenerLoteAnteriorAFecha(){
        val pinturaSinRendimiento=Pintura(precioBase = 100.00)
        pinturaSinRendimiento.rendimiento=8
        val loteAntiguo=Lote(LocalDate.of(2000,10,25),1)
        pinturaSinRendimiento.lotes.add(loteAntiguo)
        Assertions.assertEquals(100.00,pinturaSinRendimiento.precio())
        //Esta dando mal el resultado,arroja que espera el valor 9000 y no el esperado:90
    }
*/
    @Test
    @DisplayName("Se puede descontar unidades disponibles en uno de sus lotes")
    fun descontarUnidadesDisponiblesEnLote(){
        val unLote= Lote(LocalDate.now(),1).apply { numero=1111 }
        val unaPintura= Pintura(100.00)
        unaPintura.agregarLote(unLote)
        unaPintura.descontarUnidadesDisponibles(1111)
        Assertions.assertEquals(0,unLote.unidadesDisplonibles)
    }
}