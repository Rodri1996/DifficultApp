package ar.com.phm2022.aplicacion.dominio

import ar.com.phm2022.aplicacion.repositorios.ArticuloRepository
import com.fasterxml.jackson.annotation.JsonIgnore


class Item (var idArticulo:Long, var cantidad:Int, var loteElegido:Int){
    var id: Long = 0
    //TODO:Buscar una alternativa mejor que USAR UNA REFERENCIA AL REPOSITORIO!! ES ASQUEROSO!!
    @JsonIgnore
    val articuloRepository: ArticuloRepository = ArticuloRepository()

    fun precioArticulo():Double{
        var articulo=articuloRepository.find(idArticulo)
        return articulo.precio()
    }

}
