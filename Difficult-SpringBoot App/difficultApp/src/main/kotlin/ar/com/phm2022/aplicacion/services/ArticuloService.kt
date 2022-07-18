package services

import ar.com.phm2022.aplicacion.dominio.Articulo
import org.springframework.stereotype.Service
import ar.com.phm2022.aplicacion.repositorios.ArticuloRepository
import dominio.Lote

@Service
class ArticuloService {

    val articuloRepository: ArticuloRepository = ArticuloRepository()

    fun getArticulos(): Iterable<Articulo> = articuloRepository.findAll()
    fun filtrarArticulosPorPuntuacion(puntaje: Int): Iterable<Articulo> {
        return articuloRepository.buscarArticulos(puntaje)
    }

    fun getArticulo(idArticulo: Long): Articulo {
        return articuloRepository.find(idArticulo)
    }

    fun getLotes(idArticulo: Long): MutableList<Lote> {
        return articuloRepository.allLotes(idArticulo)
    }

}