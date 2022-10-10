import { Component } from 'react'
import { recuperarMensajeError } from '../../utils/recuperarMensajeError'
import { ItemRow } from '../secundarios/ItemRow'
import { usuarioService } from '../services/UsuarioService'

export class Carrito extends Component{

    state={
        items:[],
        errorMessage:''
    }

    async componentDidMount(){
        try {
            const idUsuario= this.getIdUsuarioLogueado()
            let carrito = await usuarioService.getCarritoCompras(idUsuario)
            this.setState({
                items:carrito,
            })
            console.info(this.state.items)
        } catch (error) {
            let errorEncontrado=recuperarMensajeError(error)
            console.log(errorEncontrado)
            this.setearErrorMessage(errorMessage)
        }
    }

    setearErrorMessage(message){
        this.setState({
            errorMessage:message
        })
    }

    getIdUsuarioLogueado(){
        let usuarioLoegueado=usuarioService.findUser()
        return usuarioLoegueado.id
    }

    comprar=async()=>{
        //TODO: Hay dos try-catch en este componente.Revisar si se puede simplificar a uno solo cuando se va a buscar al usuario en getIdUsuarioLogueado()
        try {
            let idUsuario=this.getIdUsuarioLogueado()
            await usuarioService.postCompraNueva(idUsuario)
            this.setState({items:[]})
        } catch (error) {
            let errorEncontrado=recuperarMensajeError(error)
            console.log(errorEncontrado)
            this.setearErrorMessage(errorMessage)
        }
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