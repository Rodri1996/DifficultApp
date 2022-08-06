package ar.com.phm2022.aplicacion.repositorios

import ar.com.phm2022.aplicacion.dominio.Compra
import ar.com.phm2022.aplicacion.dominio.Item
import ar.com.phm2022.aplicacion.dominio.CarritoDTO
import ar.com.phm2022.aplicacion.dominio.Credencial
import ar.com.phm2022.aplicacion.dominio.Usuario
import java.time.LocalDate

class UsuarioRepository {

    var idUsuario:Long=0
    var idItem:Long=0
    var idCompra:Long=0
    val usuariosRegistrados:MutableList<Usuario> = mutableListOf()

    constructor(){
        val usuario1= Usuario().apply {
            nombre="Rodrigo"
            apellido="Nieto"
            edad=25
            saldo=5500.00
            usuario=""
            contraseña=""
            foto="https://w7.pngwing.com/pngs/551/362/png-transparent-iron-man-graphics-logo-iron-man-cdr-superhero-logo-thumbnail.png"
        }
        val usuario2= Usuario().apply {
            nombre="Juan"
            apellido="Perez"
            edad=27
            saldo=3450.00
            usuario="Juan123"
            contraseña="1234"
            foto="https://w7.pngwing.com/pngs/946/911/png-transparent-hulk-vision-clint-barton-iron-man-captain-america-hulk-marvel-avengers-assemble-superhero-war-machine-thumbnail.png"
        }
        val usuario3= Usuario().apply {
            nombre="Pedro"
            apellido="Gonzales"
            edad=30
            saldo=6050.00
            usuario="peter"
            contraseña="321"
            foto="https://w7.pngwing.com/pngs/552/173/png-transparent-captain-america-iron-man-spider-man-cartoon-chibi-captain-america-captain-america-illustration-comics-avengers-heroes-thumbnail.png"
        }
        guardar(usuario1)
        guardar(usuario2)
        guardar(usuario3)
    }

    private fun guardar(usuario: Usuario) {
        usuario.id=idUsuario
        idUsuario+=1
        usuariosRegistrados.add(usuario)
    }

    fun addItem(item: Item,idUsuario:Long): Usuario {
        var usuario=getUsuario(idUsuario)
        item.id=idItem
        idItem+=1
        usuario.sumarAlCarrito(item)
        return usuario
    }

    fun allItems(idUsuario: Long): Iterable<Item> {
        var usuario=getUsuario(idUsuario)
        return usuario.carritoDeCompras
    }

    private fun getUsuario(idUsuario:Long): Usuario {
        return usuariosRegistrados.first { it.id == idUsuario }
    }

    fun postCompra(idUsuario: Long,compra:Compra):Iterable<Compra>{
        var usuario=getUsuario(idUsuario)
        compra.fechaCompra= LocalDate.now()
        compra.id=this.idCompra
        this.idCompra+=1
        var compraRealizada=usuario.confirmarCompra(compra)
        return mutableListOf()
    }

    fun allCompras(idUsuario:Long): Iterable<Compra> {
        var usuario=getUsuario(idUsuario)
        return usuario.comprasHechas
    }

    fun updateUsuario(idUsuario: Long,usuarioActualizado: Usuario): Usuario {
        var usuario=getUsuario(idUsuario)
        var usuarioPostActualizacion=usuario.update(usuarioActualizado)
        return usuarioPostActualizacion
    }

    fun findUser(credenciales: Credencial): Usuario {
        return usuariosRegistrados.first { it.usuario == credenciales.usuario && it.contraseña==credenciales.contraseña}
    }

    fun calcularTotalCarrito(idUsuario: Long): Double {
        var usuario=getUsuario(idUsuario)
        return usuario.calcularImporteTotal()
    }

    fun findCarrito(idUsuario: Long): CarritoDTO {
        var usuario=getUsuario(idUsuario)
        return usuario.getCarrito()
    }
}