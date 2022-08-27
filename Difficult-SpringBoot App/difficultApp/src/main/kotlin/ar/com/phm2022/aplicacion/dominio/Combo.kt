package ar.com.phm2022.aplicacion.dominio

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToMany

@Entity
class Combo: Articulo() {
    val PORCT_DESCUENTO=15.00


    override fun precio()= (sumaDePreciosDeProductos() + valorPorCadaProducto())*descuento()

    private fun valorPorCadaProducto(): Double {
        return 20.00*productos.size
    }

    private fun descuento(): Double {
        return 1.00-(PORCT_DESCUENTO/100.00)
    }

    private fun sumaDePreciosDeProductos():Double{
        return productos.fold(0.00) { acum, producto -> acum + producto.precio() }
    }
}