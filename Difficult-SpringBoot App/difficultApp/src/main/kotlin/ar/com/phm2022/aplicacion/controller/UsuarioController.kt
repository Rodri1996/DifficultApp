package ar.com.phm2022.aplicacion.controller

import ar.com.phm2022.aplicacion.dominio.Compra
import ar.com.phm2022.aplicacion.dominio.Item
import ar.com.phm2022.aplicacion.serializadores.UsuarioLogueadoDTO
import ar.com.phm2022.aplicacion.services.UsuarioService
import dominio.Credencial
import dominio.Usuario
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.Objects

@RestController
@CrossOrigin
class UsuarioController {

    val usuarioService: UsuarioService = UsuarioService()

    @PostMapping("/item/{idUsuario}")
    @Operation(summary ="Se quiere sumar un item al carrito de compras de un usuario")
    fun addItem(@RequestBody item: Item, @PathVariable idUsuario:Long):Iterable<Item>{
        var usuario=usuarioService.addItem(item,idUsuario)
        return usuario.carritoDeCompras
    }

    @GetMapping("/items/{idUsuario}")
    @Operation(summary ="Se traen los items del carrito de compras de un usuario")
    fun addItem(@PathVariable idUsuario:Long):Iterable<Item>{
        var items=usuarioService.getItems(idUsuario)
        return items
    }

    @PostMapping("/compras/{idUsuario}")
    @Operation(summary ="Se agrega una compra hecha por un usuario")
    fun postCompras(@PathVariable idUsuario:Long):Compra{
        return usuarioService.postCompraHecha(idUsuario)
    }

    @GetMapping("/compras/{idUsuario}")
    @Operation(summary ="Se traen las compras hechas por un usuario")
    fun getCompras(@PathVariable idUsuario:Long):Iterable<Compra>{
        return usuarioService.getCompras(idUsuario)
    }

    @PutMapping("/usuario/{idUsuario}")
    @Operation(summary ="Se actualizan todos los datos de un usuario")
    fun putUsuario(@PathVariable idUsuario:Long,@RequestBody usuarioActualizado:Usuario):Usuario{
        return usuarioService.putUsuario(idUsuario,usuarioActualizado)
    }

    //TODO: cambiar a POST en lugar de GET. Averiguar si esto es realmente POST o GET
    @PostMapping("/usuario")
    @Operation(summary ="Se verifica que el usuario esta registrado y se lo trae")
    fun getUsuarioRegistrado(@RequestBody credenciales: Credencial):UsuarioLogueadoDTO{
        return usuarioService.getUsuarioRegistrado(credenciales)
    }

    @GetMapping("/totalCarrito/{idUsuario}")
    @Operation(summary ="Se trae el precio total de la posible compra del carrito")
    fun getTotalCarrito(@PathVariable idUsuario: Long):Double{
        return usuarioService.getTotalCarrito(idUsuario)
    }
}

