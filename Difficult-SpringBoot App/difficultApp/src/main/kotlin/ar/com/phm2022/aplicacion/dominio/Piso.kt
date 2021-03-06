package dominio

import ar.com.phm2022.aplicacion.dominio.Producto

class Piso(precioBase: Double) : Producto(precioBase) {
    var tipo:TipoPiso=TransitoNormal()
    var medidas=""
    var terminacion=""

    override fun precio() = super.precio() + incremento()

    override fun incremento():Double{
        return tipo.incremento(this.precioBase)
    }
}

interface TipoPiso{
    fun incremento(precioBase: Double):Double
}

class TransitoNormal:TipoPiso{

    override fun incremento(precioBase: Double): Double = 0.00
}

class AltoTransito:TipoPiso{

    override fun incremento(precioBase: Double): Double = precioBase*0.2

}
