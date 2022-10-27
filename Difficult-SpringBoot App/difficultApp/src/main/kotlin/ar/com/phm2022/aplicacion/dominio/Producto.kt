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
abstract class Producto (@JsonIgnore var precioBase: Double): Articulo() {
    //Template method
    override fun precio(): Double {
        return (precioBase + this.incremento())*descuento()
    }
    abstract fun incremento():Double
    fun descuento():Double{
        var valorRestante=if(this.tieneLoteAntiguo()){
            0.9
        }else{
            1.00
        }
        return valorRestante
    }
    private fun tieneLoteAntiguo():Boolean{
        return this.lotes.any { it.fechaDeIngreso < LocalDate.now().minusMonths(4)}
    }
}

