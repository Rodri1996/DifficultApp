package dominio

import java.time.LocalDate

class Lote (var fechaDeIngreso:LocalDate,var unidadesDisplonibles:Int) {

    var numero:Int=0
    var id:Long=0

    fun descontarUnidades() {
        unidadesDisplonibles=unidadesDisplonibles-1
    }
}
