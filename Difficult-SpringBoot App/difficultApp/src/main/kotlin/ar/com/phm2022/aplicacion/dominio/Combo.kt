package ar.com.phm2022.aplicacion.dominio

import javax.persistence.Entity

@Entity
class Combo(
    nombre: String,
    descripcion: String,
    paisDeOrigen: String,
    puntaje: Int ) : Articulo(
                        nombre,
                        descripcion,
                        paisDeOrigen,
                        puntaje ) {
    val PORCT_DESCUENTO=15.00
    val VALOR=20.00

    override fun precio(): Double {
        return (totalDePreciosDeLosProductos()+valorPorCadaProducto())*descuento()
    }
    private fun valorPorCadaProducto(): Double {
        return VALOR*cantidadDeProductos()
    }

    fun cantidadDeProductos()=productos.size
    fun descuento(): Double {
        return 1.00-(PORCT_DESCUENTO/100.00)
    }
    private fun totalDePreciosDeLosProductos():Double{
        return productos.fold(0.00) { acum, producto -> acum + producto.precio() }
    }

    fun agregarProducto(producto: Producto){
        productos.add(producto)
    }
}