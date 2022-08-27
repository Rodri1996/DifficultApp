package ar.com.phm2022.aplicacion.dominio

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSubTypes
import javax.persistence.*

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
    //TODO: cómo hacer para que los productos de un combo se puedan agregar al @EntityGraph del metodo findAll()
    //TODO: ver por que usando el CascadeType.ALL se soluciona el problema de "object references an unsaved transient instance - save the transient instance before flushing: ar.com.phm2022.aplicacion.dominio.Lote"
    @OneToMany(cascade = [CascadeType.ALL],fetch = FetchType.LAZY)
    var lotes:MutableList<Lote> = mutableListOf()
    @OneToMany(fetch = FetchType.LAZY)
    val productos:MutableSet<Producto> = mutableSetOf()
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
