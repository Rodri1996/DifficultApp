package ar.com.phm2022.aplicacion.dominio

import ar.com.phm2022.aplicacion.dominio.Producto
import javax.persistence.Entity

@Entity
class Pintura(precioBase: Double,
              nombre: String,
              descripcion: String,
              paisDeOrigen: String,
              puntaje: Int ) : Producto(precioBase,
                                        nombre,
                                        descripcion,
                                        paisDeOrigen,
                                        puntaje ) {
    var rendimiento:Int=0
    var litros:Int=0
    var color:String=""
    override fun incremento():Double = if (esConsiderable()) 1.25 else 1.00
    fun esConsiderable() = rendimiento > 8

}