package ar.com.phm2022.aplicacion.dominio

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Compra {
    @Id
    var id:Long=0
    @Column(length = 5)
    var ordenDeCompra:Long=0
    var fechaCompra:LocalDate= LocalDate.now()
    @Column(length = 5)
    var cantArticulos:Int=0
    @Column(length = 10)
    var importeTotal:Double=0.00
}