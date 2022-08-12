package ar.com.phm2022.aplicacion

import ar.com.phm2022.aplicacion.repositorios.ArticuloRepositoryV2
import ar.com.phm2022.aplicacion.dominio.Pintura
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DifficultBootstrap:InitializingBean{

    @Autowired lateinit var articuloRepository:ArticuloRepositoryV2
    lateinit var aldaBlanco: Pintura
    override fun afterPropertiesSet() {
        println("************************************************************************")
        println("Running initialization")
        println("************************************************************************")

        aldaBlanco= Pintura(2356.55)
        articuloRepository.save(aldaBlanco)

    }

}
