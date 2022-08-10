package ar.com.phm2022.aplicacion.repositorios

import ar.com.phm2022.aplicacion.dominio.Articulo
import org.springframework.data.repository.CrudRepository

interface ArticuloRepositoryV2:CrudRepository<Articulo,Long> {
}
