package ar.com.phm2022.aplicacion.services

import ar.com.phm2022.aplicacion.dominio.Compra
import ar.com.phm2022.aplicacion.dominio.Item
import ar.com.phm2022.aplicacion.repositorios.ArticuloRepository
import ar.com.phm2022.aplicacion.repositorios.UsuarioRepository
import ar.com.phm2022.aplicacion.serializadores.UsuarioLogueadoDTO
import dominio.Credencial
import dominio.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService {

    val usuarioRepository:UsuarioRepository=UsuarioRepository()
    val articuloRepository:ArticuloRepository=ArticuloRepository()

    fun addItem(item: Item,idUsuario:Long): Usuario {
        articuloRepository.updateLotes(item)
        return usuarioRepository.addItem(item,idUsuario)
    }

    fun getItems(idUsuario: Long): Iterable<Item> {
        return usuarioRepository.allItems(idUsuario)
    }

    fun postCompraHecha(idUsuario: Long): Compra {
        return usuarioRepository.postCompra(idUsuario)
    }

    fun getCompras(idUsuario:Long): Iterable<Compra> {
        return usuarioRepository.allCompras(idUsuario)
    }

    fun putUsuario(idUsuario: Long,usuarioActualizado:Usuario): Usuario {
        return usuarioRepository.updateUsuario(idUsuario,usuarioActualizado)
    }

    fun getUsuarioRegistrado(credenciales: Credencial): UsuarioLogueadoDTO {
        var usuarioEncontrado= usuarioRepository.findUser(credenciales)
        return UsuarioLogueadoDTO(
            usuarioEncontrado.id,
            usuarioEncontrado.nombre,
            usuarioEncontrado.carritoDeCompras.size,
            usuarioEncontrado.foto
        )
    }

    fun getTotalCarrito(idUsuario: Long): Double {
        return usuarioRepository.calcularTotalCarrito(idUsuario)
    }

}