package ar.com.phm2022.aplicacion.repositorios

import ar.com.phm2022.aplicacion.dominio.Articulo
import ar.com.phm2022.aplicacion.dominio.Item
import dominio.*
import java.time.LocalDate


class ArticuloRepository{

    val articulos:MutableList<Articulo> = mutableListOf()
    var idAsignado:Long=0
    var loteAcmeBeteado1=Lote(LocalDate.now(),2).apply {
        numero=2222
    }
    var loteAcmeBeteado2=Lote(LocalDate.now(),3).apply {
        numero=3672
    }
    var loteAcmeBeteado3=Lote(LocalDate.now(),2).apply {
        numero=6543
    }
    var loteAcmeBeteado4=Lote(LocalDate.now(),2).apply {
        numero=2342
    }

    constructor(){
        //Instancias
        val piso1=Piso(2536.55).apply {
            nombre="Acme rustico"
            descripcion="Porcelanato rustico marca Acme "
            medidas = "36x36"
            puntaje=2
            paisDeOrigen="Argentina"
            tipo = TransitoNormal()
            terminacion="semi satinado"
            imagen="https://http2.mlstatic.com/D_NQ_NP_683356-MLA40823382226_022020-O.webp"
        }
        val piso2=Piso(1987.37).apply {
            nombre="Acme arena"
            descripcion="Porcelanato arena marca Acme "
            puntaje=3
            medidas = "36x36"
            tipo = TransitoNormal()
            terminacion="semi satinado"
            imagen="https://http2.mlstatic.com/D_NQ_NP_781266-MLA43542325744_092020-O.webp"
        }
        val pintura1=Pintura(8836.77).apply {
            nombre="Adla blanco"
            descripcion="Pintura para interiores color rojo marla adla con volumen (lts): "
            puntaje=4
            litros=20
            imagen="https://http2.mlstatic.com/D_NQ_NP_994199-MLA32710382980_102019-O.webp"
        }
        val piso3=Piso(2996.99).apply {
            nombre="Acme beteado"
            descripcion="Porcelanato beteado marca Acme "
            puntaje=3
            medidas = "56x56"
            tipo = TransitoNormal()
            terminacion="satinado"
            imagen="https://http2.mlstatic.com/D_NQ_NP_735549-MLA47349243915_092021-O.webp"
        }
        piso3.agregarLote(loteAcmeBeteado1)
        piso3.agregarLote(loteAcmeBeteado2)
        piso3.agregarLote(loteAcmeBeteado3)
        piso3.agregarLote(loteAcmeBeteado4)
        guardar(piso1)
        guardar(piso2)
        guardar(piso3)
        guardar(pintura1)
    }

    fun findAll():Iterable<Articulo>{
        return this.articulos
    }

    fun guardar(articulo: Articulo){
        articulo.id=this.idAsignado
        this.idAsignado=this.idAsignado+1
        this.articulos.add(articulo)
    }

    fun buscarArticulos(puntajeBuscado: Int): Iterable<Articulo> {
        return articulos.filter { it.puntaje == puntajeBuscado }
    }

    fun find(idArticulo: Long): Articulo {
        return articulos.first{it.id==idArticulo }
    }

    fun allLotes(idArticulo: Long): MutableList<Lote> {
        var articulo=find(idArticulo)
        return articulo.lotes
    }

    fun updateLotes(item: Item) {
        var articulo=find(item.idArticulo)
        println("id del articulo: "+item.idArticulo)
        articulo.descontarUnidadesDisponibles(item.loteElegido,item.cantidad)
    }
}