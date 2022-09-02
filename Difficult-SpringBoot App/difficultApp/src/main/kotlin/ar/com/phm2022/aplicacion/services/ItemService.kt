package ar.com.phm2022.aplicacion.services

import ar.com.phm2022.aplicacion.controller.ItemJson
import ar.com.phm2022.aplicacion.dominio.Item
import ar.com.phm2022.aplicacion.repositorios.ItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ItemService {

    @Autowired lateinit var articuloService:ArticuloService
    @Autowired lateinit var itemRepository:ItemRepository
    var contador:Long=0

    fun addItem(itemJson:ItemJson){
        var articulo=articuloService.getArticulo(itemJson.idArticulo).get()
        var item=Item(itemJson.idItemJson,articulo,itemJson.cantidad,itemJson.loteElegido)
        itemRepository.save(item)
    }

    fun getItem(idItem:Long):Item{
        return itemRepository.findById(idItem).get()
    }
}