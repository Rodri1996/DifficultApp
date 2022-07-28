package ar.com.phm2022.aplicacion.dominio

import java.time.LocalDate

class Compra {
    var id:Long=0
    var ordenDeCompra:Long=0
    var fechaCompra:LocalDate= LocalDate.now()
    var cantArticulos:Int=0
    var importeTotal:Double=0.00
}