package ar.com.phm2022.aplicacion.dominio

import ar.com.phm2022.aplicacion.repositorios.ArticuloRepository
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import ar.com.phm2022.aplicacion.dominio.Articulo
import javax.persistence.OneToOne

@Entity
class Item (@Id var id: Long,@OneToOne var articulo:Articulo, @Column(length = 5) var cantidad:Int,@Column(length = 4) var loteElegido:Int){

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
