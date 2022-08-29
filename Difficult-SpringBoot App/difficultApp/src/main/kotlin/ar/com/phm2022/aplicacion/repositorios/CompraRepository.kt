package ar.com.phm2022.aplicacion.repositorios

import ar.com.phm2022.aplicacion.dominio.Compra
import org.springframework.data.repository.CrudRepository

interface CompraRepository:CrudRepository<Compra,Long> {
}