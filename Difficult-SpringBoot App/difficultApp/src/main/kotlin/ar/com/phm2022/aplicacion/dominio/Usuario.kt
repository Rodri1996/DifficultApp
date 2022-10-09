package ar.com.phm2022.aplicacion.dominio

import javax.persistence.*


class Credencial(var usuario:String, var contrasenia:String){   }

@Entity
class Usuario{
    @Id
    @GeneratedValue
    var id:Long=0
    @Column(length = 50)
    var nombre:String=""
    @Column(length = 50)
    var apellido:String=""
    var usuario:String=""
    var contrasenia:String=""
    @Column(length = 3)
    var edad:Int=0
    @Column(length = 8)
    var saldo:Double=0.0
    var foto:String=""
    @OneToMany(fetch = FetchType.LAZY)
    val carritoDeCompras:MutableList<Item> = mutableListOf()
    @OneToMany(fetch = FetchType.LAZY)
    val comprasHechas:MutableSet<Compra> = mutableSetOf()



    fun sumarAlCarrito(item: Item){
        carritoDeCompras.add(item)
    }

    fun confirmarCompra(compra:Compra){
        comprasHechas.add(compra)
        carritoDeCompras.clear()
    }


    fun update(usuarioActualizado: Usuario): Usuario {
        nombre=usuarioActualizado.nombre
        apellido=usuarioActualizado.apellido
        edad=usuarioActualizado.edad
        saldo=usuarioActualizado.saldo
        return this
    }

}

class CarritoDTO(var items:Iterable<Item>,var precioTotal:Double,var cantItems:Int){
}