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

    fun descontarUnidadesDisponibles(numeroLote: Int,cantidad:Int){
        var lote = this.findLote(numeroLote)
        lote.descontarUnidades(cantidad)
        this.updateLote(lote)
    }

    fun findLote(numeroLote: Int):Lote{
        return lotes.first { it.numero == numeroLote }
    }
    fun updateLote(loteActualizado:Lote){
        var loteAEliminar=findLote(loteActualizado.numero)
        this.lotes.remove(loteAEliminar)
        this.lotes.add(loteActualizado)
    }
}
