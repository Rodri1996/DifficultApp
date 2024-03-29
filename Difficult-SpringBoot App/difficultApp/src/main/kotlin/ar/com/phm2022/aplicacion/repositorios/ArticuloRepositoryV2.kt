package ar.com.phm2022.aplicacion.repositorios

import ar.com.phm2022.aplicacion.dominio.Articulo
import ar.com.phm2022.aplicacion.dominio.Lote
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.repository.CrudRepository
import java.util.*

interface ArticuloRepositoryV2:CrudRepository<Articulo,Long> {

    @EntityGraph(attributePaths = ["lotes","productos"])
    fun findByPuntaje(puntaje:Int):Iterable<Articulo>

    @EntityGraph(attributePaths = ["lotes","productos"])
    //TODO: Ver como se hace para que no rompa por los productos del combo
    override fun findAll(): MutableIterable<Articulo>

    @EntityGraph(attributePaths = ["lotes","productos"])
    override fun findById(id: Long): Optional<Articulo>
}
