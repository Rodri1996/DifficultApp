package ar.com.phm2022.aplicacion.repositorios

import ar.com.phm2022.aplicacion.dominio.Item
import org.springframework.data.repository.CrudRepository

interface ItemRepository: CrudRepository<Item,Long> {
}