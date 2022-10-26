package ar.com.phm2022.aplicacion.dominio

import com.fasterxml.jackson.annotation.JsonIgnore
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
    @OneToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    var lotes:MutableList<Lote> = mutableListOf()
    @OneToMany(fetch = FetchType.LAZY)
    val productos:MutableSet<Producto> = mutableSetOf()
    var imagen=""
    var nombre:String=""
    var descripcion:String=""

    //Template method
    @JsonProperty
    fun precio():Double{
        return precioSegunElArticulo()*descuento()
    }

    //Obligamos a cada sub clase que herede de Articulo a sobreescribir este metodo
    abstract fun precioSegunElArticulo():Double

    //Obligamos a cada sub clase que herede de Articulo a sobreescribir este metodo
    abstract fun descuento():Double
    fun traerLotes():Iterable<Lote>{
        return this.lotes
    }
    fun agregarLote(lote: Lote){
        lotes.add(lote)
    }

    fun descontarUnidadesDisponibles(numeroLote: Long,cantidad:Int){
        var lote = this.findLote(numeroLote)
        lote.descontarUnidades(cantidad)
        this.updateLote(lote)
    }

    fun findLote(numeroLote: Long): Lote {
        return lotes.first { it.numero == numeroLote }
    }
    fun updateLote(loteActualizado: Lote){
        var loteAEliminar=findLote(loteActualizado.numero)
        this.lotes.remove(loteAEliminar)
        this.lotes.add(loteActualizado)
    }
}
