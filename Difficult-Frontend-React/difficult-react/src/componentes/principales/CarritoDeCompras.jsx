import React, { Component } from 'react'
import { ItemRow } from '../secundarios/ItemRow'
import { usuarioService } from '../services/UsuarioService'

export class Carrito extends Component{

    state={
        items:[],
        precioTotalDelCarrito:0
    }

    async componentDidMount(){
        const usuario=usuarioService.findUser()
        const idUsuario=usuario.id
        const items=await usuarioService.getItems(idUsuario)
        const carritoPrecioTotal=await usuarioService.getCarritoPrecioTotal(idUsuario)
        this.setearItems(items)
        this.setearCarritoPrecioTotal(carritoPrecioTotal)
        console.info(this.state.precioTotalDelCarrito)
    }

    setearCarritoPrecioTotal=(carritoPrecioTotal)=>{
        this.setState({
            precioTotalDelCarrito:carritoPrecioTotal.data
        })
    }

    setearItems=(items)=>{
        this.setState({
            items:items
        })
    }

    render(){
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
                            this.state.items.map(
                                (item)=>
                                    <ItemRow
                                        key={item.id}
                                        item={item}
                                    />
                            )
                        }
                    </table>
                </section>
                    <p><b>Total: </b>$ {this.state.precioTotalDelCarrito}</p>
                <section className="bx-item center-x">
                    <button className="button pry-button">Comprar</button>
                    <button className="button snd-button">Limpiar el carrito</button>
                </section>
            </section>
        )
    }
}