package ar.com.phm2022.aplicacion.dominio

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSubTypes
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.OneToMany

//TODO: Mapear la herencia

@JsonSubTypes(
        JsonSubTypes.Type(value = Producto::class, name = "PRO"),
        JsonSubTypes.Type(value = Combo::class, name = "COM")
)
@Inheritance(strategy= InheritanceType.JOINED)
@Entity
abstract class Articulo(){
    @Id
    @GeneratedValue
    var id:Long=0
    var paisDeOrigen:String=""
    var puntaje:Int=0
    //TODO: ver cómo solucionar la Inicializacion Peresoza y que cuando hayan objetos del dominio que usen los lotes,
    // la aplicacion no rompa
    @OneToMany()
    var lotes:MutableList<Lote> = mutableListOf()
    var imagen=""
    var nombre:String=""
    var descripcion:String=""

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

    fun findLote(numeroLote: Int): Lote {
        return lotes.first { it.numero == numeroLote }
    }
    fun updateLote(loteActualizado: Lote){
        var loteAEliminar=findLote(loteActualizado.numero)
        this.lotes.remove(loteAEliminar)
        this.lotes.add(loteActualizado)
    }
}
