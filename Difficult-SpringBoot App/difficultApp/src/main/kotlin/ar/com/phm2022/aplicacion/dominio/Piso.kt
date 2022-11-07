package ar.com.phm2022.aplicacion.dominio

import javax.persistence.Entity

@Entity
class Piso(precioBase: Double) : Producto(precioBase) {
    //TODO:Buscar como mapear la herencia y agregar al atributo "tipo" como parametro en el constructor de Piso()
    var tipo: TipoPiso = TransitoNormal()
    var medidas=""
    var terminacion=""

    //TODO:Modificar el metodo incremento para que devuelva un valor razonable el tipo de piso
    override fun incremento():Double{
        return tipo.incremento(this.precioBase)
    }
}

interface TipoPiso{
    fun incremento(precioBase: Double):Double
}

class TransitoNormal: TipoPiso {

    override fun incremento(precioBase: Double): Double = 1.00
}

class AltoTransito: TipoPiso {
    override fun incremento(precioBase: Double): Double = 1.2
}
