package dominio

import ar.com.phm2022.aplicacion.dominio.Compra
import ar.com.phm2022.aplicacion.dominio.Item
import java.time.LocalDate

open class Credencial{
    var usuario:String=""
    var contraseña:String=""
}

class Usuario:Credencial() {
    var id:Long=0
    var nombre:String=""
    var apellido:String=""
    var edad:Int=0
    var saldo:Double=0.0
    var foto:String=""
    var ordenDeCompra:Long=0
    val carritoDeCompras:MutableList<Item> = mutableListOf()
    val comprasHechas:MutableList<Compra> = mutableListOf()

    fun sumarAlCarrito(item: Item) {
        carritoDeCompras.add(item)
    }

    fun confirmarCompra(compra: Compra):Compra{
        compra.ordenDeCompra=this.ordenDeCompra
        this.ordenDeCompra+=1
        comprasHechas.add(compra)
        carritoDeCompras.clear()
        return compra
    }

    fun calcularImporteTotal(): Double {
        return carritoDeCompras.fold(0.00, { acum, item -> acum + precioTotalArticulo(item)})
    }

    private fun precioTotalArticulo(item: Item): Double {
        return item.cantidad * item.precioArticulo()
    }

    private fun calcularCantidadArticulos(): Int {
        return carritoDeCompras.fold(0, { acum, item -> acum + item.cantidad })
    }

    fun update(usuarioActualizado: Usuario):Usuario{
        nombre=usuarioActualizado.nombre
        apellido=usuarioActualizado.apellido
        edad=usuarioActualizado.edad
        saldo=usuarioActualizado.saldo
        return this
    }

    fun getCarrito(): CarritoDTO{
        return CarritoDTO(
                this.carritoDeCompras,
                this.calcularImporteTotal(),
                this.calcularCantidadArticulos()
        )
    }
}

class CarritoDTO(var items:Iterable<Item>,var precioTotal:Double,var cantItems:Int){
}