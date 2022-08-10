package ar.com.phm2022.aplicacion.services

import ar.com.phm2022.aplicacion.dominio.Articulo
import org.springframework.stereotype.Service
import ar.com.phm2022.aplicacion.repositorios.ArticuloRepository
import ar.com.phm2022.aplicacion.dominio.Lote
import ar.com.phm2022.aplicacion.repositorios.ArticuloRepositoryV2
import org.springframework.beans.factory.annotation.Autowired

@Service
class ArticuloService {

    @Autowired lateinit var articuloRepository: ArticuloRepositoryV2

    fun getArticulos(): Iterable<Articulo> = articuloRepository.findAll()
/*
    fun filtrarArticulosPorPuntuacion(puntaje: Int): Iterable<Articulo> {
        return articuloRepository.buscarArticulos(puntaje)
    }

    fun getArticulo(idArticulo: Long): Articulo {
        return articuloRepository.find(idArticulo)
    }

    fun getLotes(idArticulo: Long): MutableList<Lote> {
        return articuloRepository.allLotes(idArticulo)
    }
*/
}