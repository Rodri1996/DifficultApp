package ar.com.phm2022.aplicacion.services

import ar.com.phm2022.aplicacion.dominio.Item
import ar.com.phm2022.aplicacion.repositorios.CarritoRepository
import org.springframework.stereotype.Service

@Service
class CarritoService {

    var idAsignado:Long=0
    val carritoRepository:CarritoRepository=CarritoRepository()

    fun add(item: Item):Item{
        item.id=idAsignado
        idAsignado=idAsignado+1
        return carritoRepository.add(item)
    }

    fun getAllItems():Iterable<Item>{
        return carritoRepository.getItems()
    }

    fun deleteItem(id: Long):Any{
        return carritoRepository.delete(id)
    }

    fun deleteAllItems(){
        return carritoRepository.deleteItems()
    }

}