/*
package ar.com.phm2022.aplicacion

import dominio.AltoTransito
import ar.com.phm2022.aplicacion.dominio.Articulo
import dominio.Piso
import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Service
import ar.com.phm2022.aplicacion.repositorios.ArticuloRepository

@Service
class DifficultBootstrap:InitializingBean{

    val repoArticulos: ArticuloRepository=ArticuloRepository()

    private lateinit var acmeRustico: Piso

    override fun afterPropertiesSet() {
        println("************************************************************************")
        println("Running initialization")
        println("************************************************************************")
        val articuloInventado=Piso(100.00)
        repoArticulos.guardar(articuloInventado)
    //this.initArticulos()
    }

    fun initArticulos(){
        acmeRustico = Piso(100.00).apply {
            nombre="Acme rustico"
            descripcion="Porcelanato rustico semi satinado marca acme 36x36"
            medidas = "36x36"
            tipo = AltoTransito()
            terminacion="satinado"
        }
        println("voy a guardar el articulo")
        this.guardarArticulo(acmeRustico)
    }

    fun guardarArticulo(articulo: Articulo) {
        repoArticulos.guardar(articulo)
        println("¡Articulo con Id: " + articulo.id + " creado y almacenado!")

    }
}
*/