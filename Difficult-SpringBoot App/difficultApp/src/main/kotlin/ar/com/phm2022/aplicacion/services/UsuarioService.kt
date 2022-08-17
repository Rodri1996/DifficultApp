package ar.com.phm2022.aplicacion.services

import ar.com.phm2022.aplicacion.dominio.CarritoDTO
import ar.com.phm2022.aplicacion.dominio.Item
import ar.com.phm2022.aplicacion.dominio.Usuario
import ar.com.phm2022.aplicacion.repositorios.UsuarioRepositoryV2
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UsuarioService {

    @Autowired lateinit var usuarioRepository:UsuarioRepositoryV2
    //val articuloRepository:ArticuloRepository=ArticuloRepository()

    fun agregarItemAlCarrito(item: Item, idUsuario:Long): Iterable<Item> {
        //articuloRepository.updateLotes(item)
        var usuario=usuarioRepository.findById(idUsuario).get()
        usuario.sumarAlCarrito(item)
        return usuario.carritoDeCompras
    }
    /*
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

        fun getUsuarioRegistrado(credenciales: Credencial): UsuarioLogueadoDTO {
            var nombreUsuario=credenciales.usuario
            var contraseña=credenciales.contraseña
            var usuarioEncontrado= usuarioRepository.findByUsuarioAndContraseña(nombreUsuario,contraseña)
            return UsuarioLogueadoDTO(
                    usuarioEncontrado.id,
                    usuarioEncontrado.nombre,
                    usuarioEncontrado.carritoDeCompras.size,
                    usuarioEncontrado.foto
            )
        }
    */
    fun getCarrito(idUsuario: Long): CarritoDTO {
        var usuario=usuarioRepository.findById(idUsuario)
        return usuario.get().getCarritoDTO()
    }
}
