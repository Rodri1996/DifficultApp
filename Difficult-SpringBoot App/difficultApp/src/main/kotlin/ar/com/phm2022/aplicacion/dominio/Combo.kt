package ar.com.phm2022.aplicacion.dominio

import java.math.BigDecimal
import java.math.MathContext
import javax.persistence.Entity

@Entity
class Combo() : Articulo() {
    val PORCT_DESCUENTO=15.00
    val VALOR=20.00

    override fun precio(): BigDecimal {
        return (subTotal()*descuento()).round(MathContext(4))
    }

    fun subTotal()=totalDePreciosDeLosProductos()+valorPorCadaProducto()
    private fun valorPorCadaProducto(): BigDecimal {
        var valorPorCadaProducto=VALOR*cantidadDeProductos()
        return BigDecimal(valorPorCadaProducto)
    }

    fun cantidadDeProductos()=productos.size
    fun descuento(): BigDecimal {
        var decremento=1.00-(PORCT_DESCUENTO/100.00)
        return BigDecimal(decremento)
    }
    private fun totalDePreciosDeLosProductos():BigDecimal{
        return productos.fold(BigDecimal("0.00")) { acum, producto -> acum + producto.precio() }
    }

    fun agregarProducto(producto: Producto){
        productos.add(producto)
    }
}