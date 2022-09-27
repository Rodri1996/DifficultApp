package ar.com.phm2022.aplicacion.services

import ar.com.phm2022.aplicacion.dominio.*
import ar.com.phm2022.aplicacion.repositorios.CompraRepository
import ar.com.phm2022.aplicacion.repositorios.ItemRepository
import ar.com.phm2022.aplicacion.repositorios.LoteRepository
import ar.com.phm2022.aplicacion.repositorios.UsuarioRepositoryV2
import ar.com.phm2022.aplicacion.serializadores.UsuarioLogueadoDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDate
import javax.transaction.Transactional



class ItemDTO(){
    var idItem:Long=0
    var nombreArticulo:String=""
    var descripcion:String=""
    var lote:Long=0
    var cantidad:Int=0
    var precio:Double=0.00
}

@Service
class UsuarioService {

    var compra:Long=0
    var idItem:Long=0
    @Autowired lateinit var usuarioRepository:UsuarioRepositoryV2
    @Autowired lateinit var itemRepository:ItemRepository
    @Autowired lateinit var compraRepository:CompraRepository
    @Autowired lateinit var loteRepository:LoteRepository
    var numeroDeCompra:Long=0
    //val articuloRepository:ArticuloRepository=ArticuloRepository()

    @Transactional
    fun agregarItemAlCarrito(item: Item, idUsuario:Long){
        //loteRepository.findById()
        var usuario=usuarioRepository.findById(idUsuario).get()
        usuario.sumarAlCarrito(item)
        this.usuarioRepository.save(usuario)
        var lote=loteRepository.findById(item.loteElegido).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "No existe ese lote.Seleccione otro como reemplazo")
        }
        lote.descontarUnidades(item.cantidad)
        loteRepository.save(lote)
    }

    private fun identificarItem(item:Item):Item{
        item.id=this.idItem
        this.idItem=this.idItem+1
        return item
    }

    fun getItems(idUsuario: Long): Iterable<ItemDTO> {
        var usuario=usuarioRepository.findById(idUsuario).get()
        var items=usuario.carritoDeCompras
        return items.map{this.createItemDTO(it)}
    }

    fun createItemDTO(item:Item):ItemDTO{
        var itemDTO=ItemDTO().apply {
            idItem=item.id
            nombreArticulo=item.articulo.nombre
            descripcion=item.articulo.descripcion
            lote=item.loteElegido
            cantidad=item.cantidad
            precio=0.00//item.articulo.precio()
        }
        return itemDTO
    }

    @Transactional
    fun postCompraHecha(idUsuario: Long){
        var usuario=usuarioRepository.findById(idUsuario).get()
        var compra=Compra().apply {
            id=compra
            ordenDeCompra=numeroDeCompra
            fechaCompra=LocalDate.now()
            cantArticulos=usuario.carritoDeCompras.size
            importeTotal=usuario.carritoDeCompras.map { it.precioTotalArticulo() }.fold(0.00, { acum, precioTotal -> acum + precioTotal})
        }
        this.numeroDeCompra= this.numeroDeCompra + 1
        this.compra=this.compra+1
        var idCompra=compra.id
        compraRepository.save(compra)
        var compraPersistida=compraRepository.findById(idCompra).get()
        usuario.confirmarCompra(compraPersistida)
        usuarioRepository.save(usuario)
     }

    private fun updateAndSaveCompraHecha(compra:Compra){
        compra.fechaCompra= LocalDate.now()
        this.compraRepository.save(compra)
    }

    private fun asignarId(compra: Compra) {
        compra.id=this.compra
        this.compra+=1
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
     fun getUsuarioRegistrado(credenciales: Credencial):UsuarioLogueadoDTO {
         var nombreUsuario=credenciales.usuario
         var contrasenia=credenciales.contrasenia
         var usuarioEncontrado= usuarioRepository.findByUsuarioAndContrasenia(nombreUsuario,contrasenia).orElseThrow {
             ResponseStatusException(HttpStatus.NOT_FOUND, "No existe un usuario registrado con esas credenciales")
         }
        return UsuarioLogueadoDTO(usuarioEncontrado.id, usuarioEncontrado.nombre, usuarioEncontrado.carritoDeCompras.size, usuarioEncontrado.foto)
     }

}
