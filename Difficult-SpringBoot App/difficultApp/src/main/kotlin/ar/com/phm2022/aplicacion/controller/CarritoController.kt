package ar.com.phm2022.aplicacion.controller

import ar.com.phm2022.aplicacion.dominio.Item
import ar.com.phm2022.aplicacion.services.CarritoService
import io.swagger.v3.oas.annotations.Operation

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class CarritoController {

    val carritoService:CarritoService=CarritoService()
/*
    @PostMapping("/item")
    @Operation(summary ="Se agrega un nuevo item al carrito de compras")
    fun addItem(@RequestBody item:ar.com.phm2022.aplicacion.dominio.Item):ar.com.phm2022.aplicacion.dominio.Item{
        return carritoService.add(item)
    }
*/
    @GetMapping("/allItems")
    @Operation(summary = "Se traen todos los items del carrito de compras")
    fun getAllItems():Iterable<Item>{
        return carritoService.getAllItems()
    }

    @DeleteMapping("/item/{id}")
    @Operation(summary = "Borramos un item seleccionado")
    fun deleteItem(@PathVariable id:Long):Any{
        return carritoService.deleteItem(id)
    }

    @DeleteMapping("/allItems")
    @Operation(summary = "Borramos todos los items del carrito")
    fun deleteItem(){
        return carritoService.deleteAllItems()
    }
}