package ar.com.phm2022.aplicacion.services

import ar.com.phm2022.aplicacion.dominio.Compra
import ar.com.phm2022.aplicacion.dominio.Item
import ar.com.phm2022.aplicacion.repositorios.ArticuloRepository
import ar.com.phm2022.aplicacion.repositorios.UsuarioRepository
import ar.com.phm2022.aplicacion.serializadores.UsuarioLogueadoDTO
import ar.com.phm2022.aplicacion.dominio.CarritoDTO
import ar.com.phm2022.aplicacion.dominio.Credencial
import ar.com.phm2022.aplicacion.dominio.Usuario
import ar.com.phm2022.aplicacion.repositorios.UsuarioRepositoryV2
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UsuarioService {

    @Autowired lateinit var usuarioRepository:UsuarioRepositoryV2
    //val articuloRepository:ArticuloRepository=ArticuloRepository()

    /*
    fun addItem(item: Item,idUsuario:Long): Usuario {
        articuloRepository.updateLotes(item)
        return usuarioRepository.addItem(item,idUsuario)
    }

    fun getItems(idUsuario: Long): Iterable<Item> {
        return usuarioRepository.allItems(idUsuario)
    }

    fun postCompraHecha(idUsuario: Long,compra:Compra): Iterable<Compra>{
        usuarioRepository.postCompra(idUsuario,compra)
        return mutableListOf()
    }

    fun getCompras(idUsuario:Long): Iterable<Compra> {
        return usuarioRepository.allCompras(idUsuario)
    }

    fun putUsuario(idUsuario: Long,usuarioActualizado: Usuario): Usuario {
        return usuarioRepository.updateUsuario(idUsuario,usuarioActualizado)
    }

    fun getTotalCarrito(idUsuario: Long): Double {
        return usuarioRepository.calcularTotalCarrito(idUsuario)
    }

    fun getCarrito(idUsuario: Long): CarritoDTO {
        return usuarioRepository.findCarrito(idUsuario)
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

     */
}