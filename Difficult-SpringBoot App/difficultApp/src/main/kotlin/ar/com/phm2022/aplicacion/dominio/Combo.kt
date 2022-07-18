package dominio

import ar.com.phm2022.aplicacion.dominio.Articulo
import ar.com.phm2022.aplicacion.dominio.Producto

class Combo: Articulo() {
    val PORCT_DESCUENTO=15.00
    val productos:MutableList<Producto> = mutableListOf()

    override fun precio()= (sumaDePreciosDeProductos() + valorPorCadaProducto())*descuento()

    private fun valorPorCadaProducto(): Double {
        return 20.00*productos.size
    }

    private fun descuento(): Double {
        return 1.00-(PORCT_DESCUENTO/100.00)
    }

    private fun sumaDePreciosDeProductos():Double{
        return productos.fold(0.00, { acum, producto -> acum + producto.precio() })
    }
}