package ar.com.phm2022.aplicacion

import ar.com.phm2022.aplicacion.repositorios.ArticuloRepositoryV2
import ar.com.phm2022.aplicacion.dominio.Pintura
import ar.com.phm2022.aplicacion.dominio.Piso
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DifficultBootstrap:InitializingBean{

    @Autowired lateinit var articuloRepository:ArticuloRepositoryV2
    lateinit var aldaBlanco: Pintura
    lateinit var acmeRustico:Piso
    lateinit var acmeArena:Piso
    lateinit var acmeBeteado:Piso
    override fun afterPropertiesSet() {
        println("************************************************************************")
        println("Running initialization")
        println("************************************************************************")
        this.initPinturas()
        this.initPisos()
    }

    private fun initPisos(){
        //TODO:Agregarle el tipo de piso a c/u
        acmeRustico=Piso(2536.55).apply {
            descripcion="Porcelanato rustico marca Acme"
            imagen="https://http2.mlstatic.com/D_NQ_NP_683356-MLA40823382226_022020-O.webp"
            nombre="Acme rustico"
            paisDeOrigen="Argentina"
            puntaje=3

            medidas="36x36"
            terminacion="semi satinado"
        }
        acmeArena=Piso(1987.37).apply {
            descripcion="Porcelanato arena marca Acme"
            imagen="https://http2.mlstatic.com/D_NQ_NP_781266-MLA43542325744_092020-O.webp"
            nombre="Acme arena"
            paisDeOrigen="Argentina"
            puntaje=3
            medidas="36x36"
            terminacion="semi satinado"
        }
        acmeBeteado=Piso(2996.99).apply {
            descripcion="Porcelanato beteado marca Acme"
            imagen="https://http2.mlstatic.com/D_NQ_NP_735549-MLA47349243915_092021-O.webp"
            nombre="Acme beteado"
            paisDeOrigen="Argentina"
            puntaje=3
            medidas="56x56"
            terminacion="satinado"
        }
        this.articuloRepository.save(acmeRustico)
        this.articuloRepository.save(acmeArena)
        this.articuloRepository.save(acmeBeteado)
    }
    private fun initPinturas(){
        aldaBlanco= Pintura(2356.55).apply {
            descripcion="Pintura para interiores color "
            imagen="https://http2.mlstatic.com/D_NQ_NP_994199-MLA32710382980_102019-O.webp"
            nombre="Adla blanco"
            paisDeOrigen="Argentina"
            puntaje=3
            color="rojo"
            litros=20
            rendimiento=8
        }
        articuloRepository.save(aldaBlanco)
    }
}
