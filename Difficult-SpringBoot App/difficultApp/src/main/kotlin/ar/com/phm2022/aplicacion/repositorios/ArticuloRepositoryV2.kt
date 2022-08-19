package ar.com.phm2022.aplicacion.repositorios

import ar.com.phm2022.aplicacion.dominio.Articulo
import ar.com.phm2022.aplicacion.dominio.Lote
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.repository.CrudRepository
import java.util.*

interface ArticuloRepositoryV2:CrudRepository<Articulo,Long> {

    @EntityGraph(attributePaths = ["lotes"])
    fun findByPuntaje(puntaje:Int):Iterable<Articulo>

    @EntityGraph(attributePaths = ["lotes"])
    override fun findAll(): MutableIterable<Articulo>

    @EntityGraph(attributePaths = ["lotes"])
    override fun findById(id: Long): Optional<Articulo>
}
