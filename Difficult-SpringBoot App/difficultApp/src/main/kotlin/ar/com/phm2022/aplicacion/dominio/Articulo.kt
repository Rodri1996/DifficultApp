package ar.com.phm2022.aplicacion.dominio

import com.fasterxml.jackson.annotation.JsonProperty
import dominio.Lote

abstract class Articulo(){
    var id:Long=0
    var paisDeOrigen:String=""
    var puntaje:Int=0
    var lotes:MutableList<Lote> = mutableListOf()
    var imagen=""

    @JsonProperty
    abstract fun precio():Double

    fun agregarLote(lote: Lote){
        lote.id+=1
        lotes.add(lote)
    }

    fun descontarUnidadesDisponibles(numeroLote: Int){
        val loteBuscado=lotes.first { it.numero == numeroLote }
        loteBuscado.descontarUnidades()
    }
}
