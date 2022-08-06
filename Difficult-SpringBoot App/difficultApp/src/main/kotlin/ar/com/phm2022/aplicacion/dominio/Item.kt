package ar.com.phm2022.aplicacion.dominio

import ar.com.phm2022.aplicacion.repositorios.ArticuloRepository
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Item (@Column(length = 4) var idArticulo:Long, @Column(length = 5) var cantidad:Int,@Column(length = 4) var loteElegido:Int){
    @Id
    var id: Long = 0
    //TODO: El Item NO debe conocer un repositorio.Esto lo hice provisoriamente hasta solucionar el problema
    // cuando tenia una variable asi: var articulo:Articulo. El error aparecia porque Articulo es abstracto y no se podia
    // instanciar de él
    //@JsonIgnore
    //val articuloRepository: ArticuloRepository = ArticuloRepository()


    fun precioArticulo():Double{
      //  var articulo=articuloRepository.find(idArticulo)
      //  return articulo.precio()
        return 0.00
    }

}
