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

    var identificador:Long=0
    var idItem:Long=0
    @Autowired lateinit var usuarioRepository:UsuarioRepositoryV2
    @Autowired lateinit var itemRepository:ItemRepository
    @Autowired lateinit var compraRepository:CompraRepository
    @Autowired lateinit var loteRepository:LoteRepository
    var numeroDeCompra:Long=0
    //val articuloRepository:ArticuloRepository=ArticuloRepository()

    private fun getUsuario(idUsuario:Long):Usuario{
        return usuarioRepository.findById(idUsuario).get()
    }
    @Transactional
    fun agregarItemAlCarrito(item: Item, idUsuario:Long){
        var usuario=this.getUsuario(idUsuario)
        usuario.sumarAlCarrito(item)
        this.usuarioRepository.save(usuario)
        var lote=loteRepository.findById(item.loteElegido).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "No existe ese lote.Seleccione otro como reemplazo")
        }
        lote.descontarUnidades(item.cantidad)
        loteRepository.save(lote)
    }
    fun getItems(idUsuario: Long): Iterable<ItemDTO> {
        var usuario=getUsuario(idUsuario)
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
    fun postCompra(idUsuario: Long){
        var usuario=this.getUsuario(idUsuario)
        var compra=this.modelarCompra(usuario)
        compraRepository.save(compra)
        var compraPersistida=compraRepository.findById(compra.id).get()
        usuario.confirmarCompra(compraPersistida)
        usuarioRepository.save(usuario)
     }

    private fun modelarCompra(usuario: Usuario):Compra{
        var compra=Compra().apply {
            id=identificador
            ordenDeCompra=numeroDeCompra
            fechaCompra=LocalDate.now()
            cantArticulos=usuario.carritoDeCompras.map { it.cantidad }.fold(0, { acum, precioTotal -> acum + precioTotal})
            importeTotal=usuario.carritoDeCompras.map { it.precioTotalArticulo() }.fold(0.00, { acum, precioTotal -> acum + precioTotal})
        }
        this.incrementarContadores()
        return compra
    }

    private fun incrementarContadores(){
        this.numeroDeCompra=this.numeroDeCompra+1
        this.identificador=this.identificador+1
    }
    fun getCompras(idUsuario:Long): Iterable<Compra> {
        var usuario=this.getUsuario(idUsuario)
        return usuario.comprasHechas
    }

    /* TODO: Cuidado,uno no siempre quiere actualizar todos los datos
    fun putUsuario(idUsuario: Long,bodyUsuario: Usuario): Usuario {
        var usuarioEncontrado=usuarioRepository.findById(idUsuario)
        var usuarioActualizado=usuarioEncontrado.actualizar(bodyUsuario)
        return usuarioRepository.save(usuarioActualizado)
    }

     */
     fun findUsuario(credenciales: Credencial):UsuarioLogueadoDTO {
         var usuario=credenciales.usuario
         var contrasenia=credenciales.contrasenia
         var usuarioEncontrado= usuarioRepository.findByUsuarioAndContrasenia(usuario,contrasenia).orElseThrow {
             ResponseStatusException(HttpStatus.NOT_FOUND, "No existe un usuario registrado con esas credenciales. Ingrese credenciales válidas")
         }
        return UsuarioLogueadoDTO(usuarioEncontrado.id, usuarioEncontrado.nombre, usuarioEncontrado.carritoDeCompras.size, usuarioEncontrado.foto)
     }

}
