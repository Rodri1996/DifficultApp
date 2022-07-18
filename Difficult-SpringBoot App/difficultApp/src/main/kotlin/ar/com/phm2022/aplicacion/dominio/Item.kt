package ar.com.phm2022.aplicacion.dominio

import dominio.Piso

class Item (var articulo:Piso, var cantidad:Int, var loteElegido:Int){
    var id: Long = 0
    //TODO:Ver como hacer para que el articulo sea de tipo Articulo y cada vez que se instancie un item,pueda apuntar a un obj distinto
/*
    var articulo = Piso(0.00)
    var articulo=Piso(0.00)
    var cantidad:Int=0
    var loteElegido:Int=0
    */
}
