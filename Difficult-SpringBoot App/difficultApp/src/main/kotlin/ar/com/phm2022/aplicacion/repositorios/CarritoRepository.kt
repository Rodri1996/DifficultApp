package ar.com.phm2022.aplicacion.repositorios

import ar.com.phm2022.aplicacion.dominio.Item


class CarritoRepository {

    val items:MutableList<Item> = mutableListOf()

    fun add(item: Item):Item{
        items.add(item)
        return item
    }

    fun getItems(): Iterable<Item> {
        return items
    }

    fun delete(idBuscado: Long):Any{
        var item=items.first { it.id == idBuscado }
        items.remove(item)
        return items
    }

    fun deleteItems(){
        val listaVacia=items.clear()
        return listaVacia
    }
}