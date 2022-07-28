import React, { Component } from 'react'
import { Compra } from '../../dominio/Compra'
import { ItemRow } from '../secundarios/ItemRow'
import { usuarioService } from '../services/UsuarioService'

export class CarritoCompra{
    constructor(){
        this.items=[]
        this.cantItems=0
        this.precioTotal=0
    }

    static fromJson(carritoJson){
        let carrito=Object.assign(
            new CarritoCompra(),
            carritoJson,
            {}
        )
        return carrito
    }
}

export class Carrito extends Component{

    state={
        carrito:new CarritoCompra()
    }

    async componentDidMount(){
        const idUsuario= this.getIdUsuarioLogueado()
        let carrito = await usuarioService.getCarritoCompras(idUsuario)
        this.setCarritoDeCompras(carrito)
    }

    getIdUsuarioLogueado(){
        let usuarioLoegueado=usuarioService.findUser()
        return usuarioLoegueado.id
    }
  
    setCarritoDeCompras(carritoDeCompras){
        this.setState({carrito:carritoDeCompras})
    }

    comprar=async()=>{
        let carrito=this.state.carrito
        let idUsuario=this.getIdUsuarioLogueado()
        let compraNueva=Compra.carritoToJson(carrito)
        console.info(compraNueva)
        await usuarioService.postCompraNueva(compraNueva,idUsuario)
    }

    render(){
        const itemsCarrito=this.state.carrito.items
        const precioTotalCarrito=this.state.carrito.precioTotal
        return(
            <section className="bx-item column carrito">
                <h1>Carrito de compras</h1>
                <section className="table-container">
                    <table>
                        <thead>
                            <tr className="table-header">
                                <th>Producto</th>
                                <th>Descripcion</th>
                                <th>Lote</th>
                                <th>Cantidad</th>
                                <th>Precio</th>
                            </tr>
                        </thead>
                        {
                            itemsCarrito.map(
                                (item)=>
                                    <ItemRow
                                        key={item.id}
                                        item={item}
                                    />
                            )
                        }
                    </table>
                </section>
                    <p><b>Total: </b>$ {precioTotalCarrito}</p>
                <section className="bx-item center-x">
                    <button className="button pry-button" onClick={this.comprar}>Comprar</button>
                    <button className="button snd-button">Limpiar el carrito</button>
                </section>
            </section>
        )
    }
}