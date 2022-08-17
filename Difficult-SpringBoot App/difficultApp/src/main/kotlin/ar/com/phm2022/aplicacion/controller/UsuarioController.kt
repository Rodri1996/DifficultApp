package ar.com.phm2022.aplicacion.controller

import ar.com.phm2022.aplicacion.dominio.Item
import ar.com.phm2022.aplicacion.services.UsuarioService
import ar.com.phm2022.aplicacion.dominio.CarritoDTO
import ar.com.phm2022.aplicacion.dominio.Compra
import ar.com.phm2022.aplicacion.dominio.Usuario
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class UsuarioController {

    @Autowired lateinit var usuarioService: UsuarioService


    //TODO:Revisar si esta bien hecho este requerimiento
    @GetMapping("/carrito/{idUsuario}")
    @Operation(summary ="Se trae el carrito de compras con los items, cant articulos y precio total")
    fun getCarritoCompras(@PathVariable idUsuario:Long): CarritoDTO {
        return usuarioService.getCarrito(idUsuario)
    }

    @PostMapping("/item/{idUsuario}")
    @Operation(summary ="Se quiere sumar un item al carrito de compras de un usuario")
    fun addItem(@RequestBody item: Item, @PathVariable idUsuario:Long):Iterable<Item>{
        return usuarioService.agregarItemAlCarrito(item,idUsuario)
    }

    @GetMapping("/items/{idUsuario}")
    @Operation(summary ="Se traen los items del carrito de compras de un usuario")
    fun getItems(@PathVariable idUsuario:Long):Iterable<Item>{
        var items=usuarioService.getItems(idUsuario)
        return items
    }
    @PostMapping("/compra/{idUsuario}")
    @Operation(summary ="Se agrega una compra hecha por un usuario")
    fun postCompras(@PathVariable idUsuario:Long,@RequestBody compra: Compra):Iterable<Compra>{
        return usuarioService.postCompraHecha(idUsuario,compra)
    }

    @GetMapping("/compras/{idUsuario}")
    @Operation(summary ="Se traen las compras hechas por un usuario")
    fun getCompras(@PathVariable idUsuario:Long):Iterable<Compra>{
        return usuarioService.getCompras(idUsuario)
    }
/*
    @PutMapping("/usuario/{idUsuario}")
    @Operation(summary ="Se actualizan todos los datos de un usuario")
    fun putUsuario(@PathVariable idUsuario:Long,@RequestBody usuarioActualizado: Usuario): Usuario {
        return usuarioService.putUsuario(idUsuario,usuarioActualizado)
    }
    
 */
/*
    @GetMapping("/totalCarrito/{idUsuario}")
    @Operation(summary ="Se trae el precio total de la posible compra del carrito")
    fun getTotalCarrito(@PathVariable idUsuario: Long):Double{
        return usuarioService.getTotalCarrito(idUsuario)
    }

    //TODO: Averiguar cómo generar una query para el metodo findUser(credenciales: Credencial) en UsuarioRepository
    @GetMapping("/usuario")
    @Operation(summary ="Se verifica que el usuario esta registrado y se lo trae")
    fun getUsuarioRegistrado(@RequestBody credenciales: Credencial):UsuarioLogueadoDTO{
        return usuarioService.getUsuarioRegistrado(credenciales)
    }
*/

}

