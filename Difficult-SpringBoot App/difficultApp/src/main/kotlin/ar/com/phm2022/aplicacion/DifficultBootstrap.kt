package ar.com.phm2022.aplicacion

import ar.com.phm2022.aplicacion.dominio.*
import ar.com.phm2022.aplicacion.repositorios.ArticuloRepositoryV2
import ar.com.phm2022.aplicacion.repositorios.UsuarioRepositoryV2
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class DifficultBootstrap:InitializingBean{

    //Repositorios:
    @Autowired lateinit var articuloRepository:ArticuloRepositoryV2
    @Autowired lateinit var usuarioRepository:UsuarioRepositoryV2
    //Pinturas:
    lateinit var aldaBlanco1: Pintura
    lateinit var aldaBlanco2: Pintura
    //Pisos:
    lateinit var acmeRustico:Piso
    lateinit var acmeArena:Piso
    lateinit var acmeBeteado:Piso
    //Combos:
    lateinit var combo1: Combo
    //Lotes:
    lateinit var loteAcmeBeteado1:Lote
    lateinit var loteAcmeArena1:Lote
    lateinit var loteAcmeRustico1:Lote
    lateinit var loteAldaBlanco1:Lote
    lateinit var loteAldaBlanco2:Lote
    //Usuarios:
    lateinit var usuario1:Usuario
    lateinit var usuario2:Usuario
    lateinit var usuario3:Usuario
    override fun afterPropertiesSet() {
        println("************************************************************************")
        println("Running initialization")
        println("************************************************************************")
        this.initLotes()
        this.initPinturas()
        this.initPisos()
        this.initCombos()
        this.initUsuarios()
    }

    private fun initLotes(){
        loteAcmeBeteado1=Lote(LocalDate.now(),3)
        loteAcmeArena1=Lote(LocalDate.now(),4)
        loteAcmeRustico1=Lote(LocalDate.now(),1)
        loteAldaBlanco1=Lote(LocalDate.now(),2)
        loteAldaBlanco2=Lote(LocalDate.now(),3)
    }

    private fun initUsuarios(){
        usuario1=Usuario().apply {
            nombre="Rodrigo"
            apellido="Nieto"
            edad=25
            saldo=5500.00
            usuario=""
            contraseña=""
            foto="https://w7.pngwing.com/pngs/551/362/png-transparent-iron-man-graphics-logo-iron-man-cdr-superhero-logo-thumbnail.png"
        }
        usuario2=Usuario().apply {
            nombre="Juan"
            apellido="Perez"
            edad=27
            saldo=3450.00
            usuario="Juan123"
            contraseña="1234"
            foto="https://w7.pngwing.com/pngs/946/911/png-transparent-hulk-vision-clint-barton-iron-man-captain-america-hulk-marvel-avengers-assemble-superhero-war-machine-thumbnail.png"
        }
        usuario3=Usuario().apply {
            nombre="Pedro"
            apellido="Gonzales"
            edad=30
            saldo=6050.00
            usuario="peter"
            contraseña="321"
            foto="https://w7.pngwing.com/pngs/552/173/png-transparent-captain-america-iron-man-spider-man-cartoon-chibi-captain-america-captain-america-illustration-comics-avengers-heroes-thumbnail.png"
        }
        usuarioRepository.save(usuario1)
        usuarioRepository.save(usuario2)
        usuarioRepository.save(usuario3)
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

        acmeBeteado.lotes.add(loteAcmeBeteado1)

        acmeRustico.lotes.add(loteAcmeRustico1)
        acmeArena.lotes.add(loteAcmeArena1)

        this.articuloRepository.save(acmeRustico)
        this.articuloRepository.save(acmeArena)
        this.articuloRepository.save(acmeBeteado)
    }
    private fun initPinturas(){
        aldaBlanco1= Pintura(2356.55).apply {
            descripcion="Pintura para interiores color "
            imagen="https://http2.mlstatic.com/D_NQ_NP_994199-MLA32710382980_102019-O.webp"
            nombre="Adla blanco"
            paisDeOrigen="Argentina"
            puntaje=3
            color="rojo"
            litros=20
            rendimiento=8
        }
        aldaBlanco2= Pintura(2500.50).apply {
            descripcion="Pintura para interiores color "
            imagen="https://http2.mlstatic.com/D_NQ_NP_994199-MLA32710382980_102019-O.webp"
            nombre="Adla "
            paisDeOrigen="Uruguay"
            puntaje=3
            color="verde"
            litros=20
            rendimiento=6
        }
        aldaBlanco1.lotes.add(loteAldaBlanco1)
        aldaBlanco2.lotes.add(loteAldaBlanco2)
        /*
        aldaBlanco2.lotes.add(loteAldaBlanco1)
         */
        articuloRepository.save(aldaBlanco1)
        articuloRepository.save(aldaBlanco2)
    }

    private fun initCombos(){
        combo1= Combo().apply {
            productos.add(aldaBlanco1)
            productos.add(acmeArena)
        }
        articuloRepository.save(combo1)
    }
}
