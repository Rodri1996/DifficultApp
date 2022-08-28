package ar.com.phm2022.aplicacion.services

import ar.com.phm2022.aplicacion.dominio.*
import ar.com.phm2022.aplicacion.repositorios.UsuarioRepositoryV2
import ar.com.phm2022.aplicacion.serializadores.UsuarioLogueadoDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class UsuarioService {

    var idCompra:Long=0
    var idItem:Long=0
    @Autowired lateinit var usuarioRepository:UsuarioRepositoryV2
    //val articuloRepository:ArticuloRepository=ArticuloRepository()

    fun agregarItemAlCarrito(item: Item, idUsuario:Long): Iterable<Item> {
        //articuloRepository.updateLotes(item)
        var usuario=usuarioRepository.findById(idUsuario).get()
        var  itemIdentificado=this.identificarItem(item)
        return usuario.sumarAlCarrito(itemIdentificado)
    }

    private fun identificarItem(item:Item):Item{
        item.id=this.idItem
        this.idItem=this.idItem+1
        return item
    }

    fun getItems(idUsuario: Long): Iterable<Item> {
        var usuario=usuarioRepository.findById(idUsuario).get()
        return usuario.carritoDeCompras
    }

    fun postCompraHecha(idUsuario: Long,compra:Compra): Iterable<Compra>{
        var usuario=usuarioRepository.findById(idUsuario).get()
        this.actualizarCompra(compra)
        usuario.confirmarCompra(compra)
        return usuario.comprasHechas
     }

    private fun actualizarCompra(compra:Compra){
        compra.fechaCompra= LocalDate.now()
        this.asignarId(compra)
    }

    private fun asignarId(compra: Compra) {
        compra.id=this.idCompra
        this.idCompra+=1
    }


    fun getCompras(idUsuario:Long): Iterable<Compra> {
        var usuario=usuarioRepository.findById(idUsuario).get()
        return usuario.comprasHechas
    }

    /* TODO: Cuidado,uno no siempre quiere actualizar todos los datos
    fun putUsuario(idUsuario: Long,bodyUsuario: Usuario): Usuario {
        var usuarioEncontrado=usuarioRepository.findById(idUsuario)
        var usuarioActualizado=usuarioEncontrado.actualizar(bodyUsuario)
        return usuarioRepository.save(usuarioActualizado)
    }

     */

    /*
    fun getTotalCarrito(idUsuario: Long): Double {
        return usuarioRepository.calcularTotalCarrito(idUsuario)
     }
*/
     fun getUsuarioRegistrado(credenciales: Credencial): UsuarioLogueadoDTO {
         var nombreUsuario=credenciales.usuario
         var contrasenia=credenciales.contraseña
         var usuarioEncontrado= usuarioRepository.findByUsuario(nombreUsuario).get()
         return UsuarioLogueadoDTO(
            usuarioEncontrado.id,
            usuarioEncontrado.nombre,
            usuarioEncontrado.carritoDeCompras.size,
            usuarioEncontrado.foto
         )}

    fun getCarrito(idUsuario: Long): CarritoDTO {
        var usuario=usuarioRepository.findById(idUsuario).get()
        return usuario.getCompraRealizada()
    }
}
