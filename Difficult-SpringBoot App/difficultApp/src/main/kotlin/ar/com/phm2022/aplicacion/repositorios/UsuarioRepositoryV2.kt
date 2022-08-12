package ar.com.phm2022.aplicacion.repositorios

import ar.com.phm2022.aplicacion.dominio.Credencial
import ar.com.phm2022.aplicacion.dominio.Usuario
import org.springframework.data.repository.CrudRepository

interface UsuarioRepositoryV2: CrudRepository<Usuario,Long> {

    //fun findUser(credenciales: Credencial): Usuario
}