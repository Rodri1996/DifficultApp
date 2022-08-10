package ar.com.phm2022.aplicacion.dominio

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Lote (var fechaDeIngreso:LocalDate,var unidadesDisplonibles:Int) {

    var numero:Int=0
    @Id
    @GeneratedValue
    var id:Long=0

    fun descontarUnidades(cantidad:Int) {
        unidadesDisplonibles=unidadesDisplonibles-cantidad
        println("unidades disponibles: "+unidadesDisplonibles)
    }
}
