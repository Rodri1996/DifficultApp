package ar.com.phm2022.aplicacion.dominio

import java.math.BigDecimal
import javax.persistence.Entity

@Entity
class Piso(precioBase: BigDecimal,@Transient var tipo: TipoPiso) : Producto(precioBase) {
    var medidas=""
    var terminacion=""
    //Resolver el error que surge al calcular el incremento segun el tipo de piso
    override fun incremento():BigDecimal{
        return BigDecimal("1.00")//tipo.incremento(this.precioBase)
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
