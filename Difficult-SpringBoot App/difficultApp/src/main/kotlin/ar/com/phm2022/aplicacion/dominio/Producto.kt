package ar.com.phm2022.aplicacion.dominio

import java.time.LocalDate

abstract class Producto (var precioBase: Double): Articulo() {


    //Ver cómo hacer en las clases Piso y Pintura para NO usar el super.precio()
    override fun precio()=precioBase*this.aplicaDescuento()

    private fun aplicaDescuento(): Double{
        var valorRestante=if(this.tieneLoteAntiguo()){
            this.precioBase*0.9
        }else{
            1.00
        }
        return valorRestante
    }

    private fun tieneLoteAntiguo():Boolean{
        return this.lotes.any { it.fechaDeIngreso < LocalDate.now().minusMonths(4)}
    }

    abstract fun incremento():Double
}

