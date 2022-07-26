import axios from 'axios'
import { Compra } from '../../dominio/Compra'
import { Item } from '../../dominio/Item'
import { Usuario } from '../../dominio/Usuario'

//const REST_SERVER_URL = 'http://localhost:8080'

class UsuarioService{

    constructor(){
        const usuarioString=localStorage.getItem("usuarioLogeado")
        this.usuario = Usuario.fromJson(JSON.parse(usuarioString))
    }

    findUser(){
        return this.usuario
    }

    async getComprasHechas(idUsuario){
        const comprasJson = await axios.get(`http://localhost:8080/compras/${idUsuario}`)
        return comprasJson.data.map((item)=>Compra.fromJson(item))
    }

    async getItems(idUsuario){
        const itemsJson = await axios.get(`http://localhost:8080/items/${idUsuario}`)
        return itemsJson.data.map((item)=>Item.fromJson(item))
    }

    async getUsuarioLogueado(usuario,contraseña){
        //const usuarioLogueadoJson = await axios.get(`${REST_SERVER_URL}/usuario`,Usuario.toJson(usuario,contraseña))
        const usuarioLogueadoJson = await axios.post('http://localhost:8080/usuario',Usuario.toJson(usuario,contraseña))
        return Usuario.fromJson(usuarioLogueadoJson)
    }

    async getCarritoPrecioTotal(usuarioId){
        const carritoPrecioTotal = await axios.get(`http://localhost:8080/totalCarrito/${usuarioId}`)
        return carritoPrecioTotal
    }

    async postItem(idUsuario,newItem){
        await axios.post("http://localhost:8080/item/"+idUsuario,Item.toJson(newItem))
    }
}

export const usuarioService= new UsuarioService()