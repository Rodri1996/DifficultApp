package ar.com.phm2022.aplicacion.dominio

import javax.persistence.Entity

@Entity
class Piso(precioBase: Double) : Producto(precioBase) {
    //TODO:Buscar como mapear la herencia
    //var tipo: TipoPiso = TransitoNormal()
    var medidas=""
    var terminacion=""

    //TODO:Modificar el metodo incremento para que devuelva un valor razonable el tipo de piso
    override fun incremento():Double{
        //return tipo.incremento(this.precioBase)
        return 1.00
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
