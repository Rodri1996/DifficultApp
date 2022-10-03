import { Component } from 'react'
import { ItemRow } from '../secundarios/ItemRow'
import { usuarioService } from '../services/UsuarioService'

// export class CarritoCompra{
//     constructor(){
//         this.idItem=0
//         this.nombreArticulo=""
//         this.descripcion=""
//         this.lote=0
//         this.cantidad=0
//         this.precio=0
//     }

//     static fromJson(carritoJson){
//         let carrito=Object.assign(
//             new CarritoCompra(),
//             carritoJson,
//             {}
//         )
//         return carrito
//     }
// }

export class Carrito extends Component{

    state={
        items:[]
    }

    async componentDidMount(){
        const idUsuario= this.getIdUsuarioLogueado()
        let carrito = await usuarioService.getCarritoCompras(idUsuario)
        // let carrito = await usuarioService.getItems(idUsuario)
        this.setState({
            items:carrito
        })
        console.info(this.state.items)
    }

    getIdUsuarioLogueado(){
        let usuarioLoegueado=usuarioService.findUser()
        return usuarioLoegueado.id
    }

    comprar=async()=>{
        // let carrito=this.state.items
        let idUsuario=this.getIdUsuarioLogueado()
        // let compraNueva=Compra.carritoToJson(carrito)
        await usuarioService.postCompraNueva(idUsuario)
        await this.componentDidMount()
    }

    render(){
        const precioTotalCarrito=this.state.items.precioTotal
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
                                        key={item.idItem}
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