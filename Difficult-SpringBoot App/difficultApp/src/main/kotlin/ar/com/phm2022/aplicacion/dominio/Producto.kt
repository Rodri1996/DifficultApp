package ar.com.phm2022.aplicacion.dominio

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonSubTypes
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Inheritance
import javax.persistence.InheritanceType

@JsonSubTypes(
        JsonSubTypes.Type(value = Piso::class, name = "PISO"),
        JsonSubTypes.Type(value = Pintura::class, name = "PINT")
)
@Inheritance(strategy= InheritanceType.JOINED)
@Entity
abstract class Producto (@JsonIgnore var precioBase: BigDecimal): Articulo() {

    //Template method
    override fun precio(): BigDecimal {
        return (precioBase*incremento()*descuento()).setScale(2, RoundingMode.UP);
    }
    abstract fun incremento():BigDecimal
    fun descuento():BigDecimal = if(tieneAlgunLoteAntiguo()) BigDecimal("0.9") else BigDecimal("1.00")
    private fun tieneAlgunLoteAntiguo():Boolean = lotes.any { it.fechaDeIngreso < fechaLimite()}
    private fun fechaLimite()=LocalDate.now().minusMonths(4)
}

