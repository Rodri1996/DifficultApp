package ar.com.phm2022.aplicacion.dominio

import javax.persistence.Entity

@Entity
class Piso(precioBase: Double) : Producto(precioBase) {
    //TODO:Buscar como mapear la herencia
    var tipo: TipoPiso = TransitoNormal()
    var medidas=""
    var terminacion=""


    override fun incremento():Double{
        //return tipo.incremento(this.precioBase)
        return 0.00
    }
}

interface TipoPiso{
    fun incremento(precioBase: Double):Double
}

class TransitoNormal: TipoPiso {

    override fun incremento(precioBase: Double): Double = 0.00
}

class AltoTransito: TipoPiso {

    override fun incremento(precioBase: Double): Double = precioBase*0.2

}
