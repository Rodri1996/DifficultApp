package ar.com.phm2022.aplicacion.dominio

import ar.com.phm2022.aplicacion.dominio.Producto
import javax.persistence.Entity

@Entity
class Pintura(precioBase: Double) : Producto(precioBase) {
    var rendimiento:Int=0
    var litros:Int=0
    var color:String=""
    val PORCENTAJE_INCREMENTO=25.00/100.00
    override fun incremento():Double{
        var valor=if(rendimiento>8) { 1+PORCENTAJE_INCREMENTO } else { 1.00 }
        return valor
    }

}