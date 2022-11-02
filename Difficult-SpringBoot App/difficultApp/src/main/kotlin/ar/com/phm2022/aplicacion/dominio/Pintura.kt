package ar.com.phm2022.aplicacion.dominio

import ar.com.phm2022.aplicacion.dominio.Producto
import javax.persistence.Entity

@Entity
class Pintura(precioBase: Double) : Producto(precioBase) {
    var rendimiento:Int=0
    var litros:Int=0
    var color:String=""
    val FACTOR_INCREMENTAL=1.25
    override fun incremento():Double{
        return if (esConsiderable()) FACTOR_INCREMENTAL else 1.00
    }
    fun esConsiderable() = rendimiento > 8

}