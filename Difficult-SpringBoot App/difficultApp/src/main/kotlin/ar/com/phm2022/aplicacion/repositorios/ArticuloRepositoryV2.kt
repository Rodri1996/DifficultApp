package ar.com.phm2022.aplicacion.repositorios

import ar.com.phm2022.aplicacion.dominio.Articulo
import ar.com.phm2022.aplicacion.dominio.Lote
import org.springframework.data.repository.CrudRepository

interface ArticuloRepositoryV2:CrudRepository<Articulo,Long> {

}
