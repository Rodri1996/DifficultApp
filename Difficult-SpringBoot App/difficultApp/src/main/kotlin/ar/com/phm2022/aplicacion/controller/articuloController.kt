package ar.com.phm2022.aplicacion.controller

import ar.com.phm2022.aplicacion.dominio.Articulo
import ar.com.phm2022.aplicacion.dominio.Lote
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import ar.com.phm2022.aplicacion.services.ArticuloService

@RestController
@CrossOrigin
class ArticulosController {

    @Autowired lateinit var articuloService: ArticuloService
    @GetMapping("/articulos")
    @Operation( summary ="Traemos todos los articulos registrados")
    fun getArticulos():Iterable<Articulo>{
        return articuloService.getArticulos()
    }
/*
    @GetMapping("/articulos/{puntaje}")
    @Operation( summary ="Traemos todos los articulos registrados con cierto nivel de puntuacion")
    fun getArticulosConCiertaPuntuacion(@PathVariable puntaje:Int):Iterable<Articulo>{
        return articuloService.filtrarArticulosPorPuntuacion(puntaje)
    }

    @GetMapping("/articulo/{idArticulo}")
    @Operation( summary ="Se trae un articulo registrado")
    fun getArticulo(@PathVariable idArticulo:Long):Articulo{
        return articuloService.getArticulo(idArticulo)
    }

    @GetMapping("/lotes/{idArticulo}")
    @Operation( summary ="Se traen los lotes de un articulo")
    fun getLotes(@PathVariable idArticulo:Long):MutableList<Lote>{
        var lotes= articuloService.getLotes(idArticulo)
        var lote=lotes.find { it.numero==2222 }
        if (lote != null) {
            println("unidades (controller): "+ lote.unidadesDisplonibles)
        }
        return  lotes
    }
 */
}
