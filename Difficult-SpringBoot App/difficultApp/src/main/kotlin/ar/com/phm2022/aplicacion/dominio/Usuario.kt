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

    val carritoDeCompras:MutableList<Item> = mutableListOf()
    val comprasHechas:MutableList<Compra> = mutableListOf()

    fun sumarAlCarrito(item: Item) {
        carritoDeCompras.add(item)
    }

    fun confirmarCompra():Compra{
        var compraRealizada=Compra().apply {
            ordenDeCompra+=1
            fechaCompra= LocalDate.now()
            cantArticulos=calcularCantidadArticulos()
            importeTotal=calcularImporteTotal()
        }
        comprasHechas.add(compraRealizada)
        carritoDeCompras.clear()
        return compraRealizada
    }

    private fun calcularImporteTotal(): Double {
        return carritoDeCompras.fold(0.00, { acum, item -> acum + precioTotalArticulo(item)})
    }

    private fun precioTotalArticulo(item: Item): Double {
        return item.cantidad * item.articulo.precio()
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
}