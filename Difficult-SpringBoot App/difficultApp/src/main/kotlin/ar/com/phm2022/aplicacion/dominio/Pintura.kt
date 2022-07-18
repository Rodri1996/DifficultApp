package dominio

import ar.com.phm2022.aplicacion.dominio.Producto

class Pintura(precioBase: Double) : Producto(precioBase) {
    var rendimiento:Int=0
    var litros:Int=0
    var color:String=""

    override fun precio(): Double {
        return super.precio() + this.incremento()
    }

    override fun incremento():Double{
        var valorAIncrementar=if(rendimiento>8){ precioBase*(25.00/100.00) }
        else{ 0.00 }
        return  valorAIncrementar
    }
}