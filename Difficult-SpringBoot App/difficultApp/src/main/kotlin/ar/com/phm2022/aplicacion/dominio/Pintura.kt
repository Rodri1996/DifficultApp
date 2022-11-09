package ar.com.phm2022.aplicacion.dominio

import ar.com.phm2022.aplicacion.dominio.Producto
import java.math.BigDecimal
import javax.persistence.Entity

@Entity
class Pintura(precioBase: BigDecimal,var rendimiento:Int) : Producto(precioBase) {
    var litros:Int=0
    var color:String=""
    override fun incremento():BigDecimal = if (esConsiderable()) BigDecimal("1.25") else BigDecimal("1.00")
    fun esConsiderable() = rendimiento > 8

}