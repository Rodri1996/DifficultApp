package ar.com.phm2022.aplicacion.services

import ar.com.phm2022.aplicacion.dominio.Articulo
import org.springframework.stereotype.Service
import ar.com.phm2022.aplicacion.dominio.Lote
import ar.com.phm2022.aplicacion.repositorios.ArticuloRepositoryV2
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import java.util.*
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class ArticuloService {

    @Autowired lateinit var articuloRepository: ArticuloRepositoryV2

    @Transactional(readOnly = true)
    fun getArticulos(): Iterable<Articulo> = articuloRepository.findAll()

    fun getArticulo(idArticulo: Long): Articulo {
        return articuloRepository.findById(idArticulo).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "No existe ese articulo.Seleccione otro como reemplazo")
        }
    }
    fun filtrarArticulosPorPuntuacion(puntaje: Int): Iterable<Articulo> {
        return articuloRepository.findByPuntaje(puntaje)
    }

    fun getLotes(idArticulo: Long): Iterable<Lote> {
        var articulo= articuloRepository.findById(idArticulo)
        return articulo.get().traerLotes()
    }

}