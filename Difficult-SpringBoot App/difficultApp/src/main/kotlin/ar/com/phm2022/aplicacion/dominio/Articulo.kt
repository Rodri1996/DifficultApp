package ar.com.phm2022.aplicacion.dominio

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSubTypes
import javax.persistence.*
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
    lateinit var nombre: String
    lateinit var descripcion: String
    lateinit var paisDeOrigen: String
    var puntaje: Int = 0
    @OneToMany(fetch = FetchType.LAZY)
    var lotes:MutableList<Lote> = mutableListOf()
    @OneToMany(fetch = FetchType.LAZY)
    val productos:MutableSet<Producto> = mutableSetOf()
    var imagen=""

    //Template method
    @JsonProperty
    abstract fun precio():Double
    fun agregarLote(lote: Lote){
        lotes.add(lote)
    }
    //TODO:Usar este metodo cuando se realiza una compra
    fun descontarUnidadesDisponibles(numeroLote: Long, cantidadADescontar:Int){
        var lote = this.findLote(numeroLote)
        lote.descontarUnidadesDisponibles(cantidadADescontar)
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
