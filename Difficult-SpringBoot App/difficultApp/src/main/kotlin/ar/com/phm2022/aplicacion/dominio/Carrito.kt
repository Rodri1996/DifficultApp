package ar.com.phm2022.aplicacion.dominio

class Carrito {
    val items:MutableList<Item> = mutableListOf()

    fun agregar(item: Item){
        items.add(item)
    }
}