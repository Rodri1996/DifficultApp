import axios from 'axios'
import { Compra } from '../../dominio/Compra'
import { Item } from '../../dominio/Item'
import { Usuario } from '../../dominio/Usuario'

class UsuarioService{

    constructor(){
        this.usuarioTraido = new Usuario 
    }

    findUser(){
        let usuarioLogeado = JSON.parse(localStorage.getItem("usuarioLogeado"))
        return usuarioLogeado
    }

    async getCarritoCompras(idUsuario){
        const carritoCompras=await axios.get(`http://localhost:8080/items/${idUsuario}`)
        console.info(carritoCompras.data)
        return carritoCompras.data.map((item)=>Item.fromJson(item))
    }

    async getComprasHechas(idUsuario){
        const comprasJson = await axios.get(`http://localhost:8080/compras/${idUsuario}`)
        return comprasJson.data.map((item)=>Compra.fromJson(item))
    }

    async getCantidadItemsCarrito(){
        let usuario = this.findUser()
        let idUsuario = usuario.id
        console.log(idUsuario)
        return await axios.get(`http://localhost:8080/cantidadItems/${idUsuario}`)
    }

    // VER UNA MEJOR MANERA DE TRAER AL USUARIO Y GUARDARLO PARA USARLO EN TODA LA APLICACION DESPUES
    async getUsuarioLogueado(usuario,contraseña){
        let usuarioLogueadoJson = await axios.post('http://localhost:8080/usuario',Usuario.toJson(usuario,contraseña))
        return Usuario.fromJson(usuarioLogueadoJson)
    }

    async getCarritoPrecioTotal(usuarioId){
        const carritoPrecioTotal = await axios.get(`http://localhost:8080/totalCarrito/${usuarioId}`)
        return carritoPrecioTotal
    }

    async postItem(idUsuario,newItem){
        await axios.post("http://localhost:8080/item/"+idUsuario,Item.toJson(newItem))
    }

    async postCompraNueva(usuarioId){
        console.log(usuarioId)
        return await axios.post(`http://localhost:8080/compra/${usuarioId}`)
    }
}

export const usuarioService= new UsuarioService()