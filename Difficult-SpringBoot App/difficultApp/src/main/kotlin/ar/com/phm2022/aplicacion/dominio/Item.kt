package ar.com.phm2022.aplicacion.dominio

import ar.com.phm2022.aplicacion.repositorios.ArticuloRepository
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import ar.com.phm2022.aplicacion.dominio.Articulo
import java.math.BigDecimal
import javax.persistence.OneToOne

@Entity
class Item (@Id var id: Long,@OneToOne var articulo:Articulo, @Column(length = 5) var cantidad:Int,@Column(length = 4) var loteElegido:Long){

    fun precioTotalArticulo():BigDecimal{
      return articulo.precio()* BigDecimal(cantidad)
    }
}
