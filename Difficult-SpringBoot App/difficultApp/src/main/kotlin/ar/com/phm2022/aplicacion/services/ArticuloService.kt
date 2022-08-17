package ar.com.phm2022.aplicacion.services

import ar.com.phm2022.aplicacion.dominio.Articulo
import org.springframework.stereotype.Service
import ar.com.phm2022.aplicacion.repositorios.ArticuloRepository
import ar.com.phm2022.aplicacion.dominio.Lote
import ar.com.phm2022.aplicacion.repositorios.ArticuloRepositoryV2
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

@Service
class ArticuloService {

    @Autowired lateinit var articuloRepository: ArticuloRepositoryV2

    fun getArticulos(): Iterable<Articulo> = articuloRepository.findAll()

    fun getArticulo(idArticulo: Long): Optional<Articulo> {
        return articuloRepository.findById(idArticulo)
    }
    fun filtrarArticulosPorPuntuacion(puntaje: Int): Iterable<Articulo> {
        return articuloRepository.findByPuntaje(puntaje)
    }

    fun getLotes(idArticulo: Long): Iterable<Lote> {
        var articulo= articuloRepository.findById(idArticulo)
        return articulo.get().lotes
    }

}