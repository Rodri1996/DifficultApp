package ar.com.phm2022.aplicacion.dominio

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonSubTypes
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
abstract class Producto (
    @JsonIgnore var precioBase: Double,
    nombre: String,
    descripcion: String,
    paisDeOrigen: String,
    puntaje: Int ): Articulo(
                            nombre,
                            descripcion,
                            paisDeOrigen,
                            puntaje ) {
    //Template method
    override fun precio(): Double {
        return (precioBase*incremento())*descuento()
    }
    abstract fun incremento():Double
    fun descuento():Double = if(tieneAlgunLoteAntiguo()) 0.9 else 1.00
    private fun tieneAlgunLoteAntiguo():Boolean = lotes.any { it.fechaDeIngreso < fechaLimite()}
    private fun fechaLimite()=LocalDate.now().minusMonths(4)
}

