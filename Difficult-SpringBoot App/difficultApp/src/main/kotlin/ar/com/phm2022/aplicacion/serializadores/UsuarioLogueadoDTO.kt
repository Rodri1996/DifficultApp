package ar.com.phm2022.aplicacion.serializadores

import ar.com.phm2022.aplicacion.dominio.Item

data class UsuarioLogueadoDTO(val id:Long,val nombre:String,val items:Int,val foto:String){
}