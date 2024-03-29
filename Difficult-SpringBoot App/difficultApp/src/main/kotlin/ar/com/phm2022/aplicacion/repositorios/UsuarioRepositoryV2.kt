package ar.com.phm2022.aplicacion.repositorios

import ar.com.phm2022.aplicacion.dominio.Usuario
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UsuarioRepositoryV2: CrudRepository<Usuario,Long> {

    //TODO:Hacer que busque a un usuario por usuario y contrasenia
    @EntityGraph(attributePaths = ["carritoDeCompras"])
    fun findByUsuarioAndContrasenia(usuario:String,contrasenia:String):Optional<Usuario>

    //TODO:Solucionar el nuevo error que figura aca
    @EntityGraph(attributePaths = ["carritoDeCompras","comprasHechas"])
    override fun findById(id: Long): Optional<Usuario>
}