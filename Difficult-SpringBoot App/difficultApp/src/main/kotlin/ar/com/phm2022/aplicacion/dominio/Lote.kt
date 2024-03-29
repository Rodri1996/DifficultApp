package ar.com.phm2022.aplicacion.dominio

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Lote (var fechaDeIngreso:LocalDate,var unidadesDisplonibles:Int) {
    @Id
    @GeneratedValue
    var numero:Long=0
    fun descontarUnidadesDisponibles(unidadesDescontadas:Int) {
        unidadesDisplonibles -= unidadesDescontadas
    }
}
