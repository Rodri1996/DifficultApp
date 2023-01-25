
import { Alert, Snackbar } from '@mui/material'
import { PropTypes } from 'prop-types'
import { Component } from 'react'
import { Articulo } from '../../dominio/Articulo'
import { Item } from '../../dominio/Item'
import { LoteRow } from '../secundarios/LoteRow'
import { articuloService } from '../services/ArticuloService'


export class DetalleDelProducto extends Component{
    
    constructor(props) {
        super(props)
        this.state = {
            articulo: new Articulo,
            lotes:[],
            cantidadElegida:0,
            item:new Item(),
            errorMesagge: {open: false,vertical: 'top',horizontal: 'right',message: ""}
        }
    }

    async componentDidMount(){
        let idArticulo = this.getId()
        try {
            let unArticulo = await articuloService.findArticulo(idArticulo)
            this.actualizarArticulo(unArticulo.data)
            let lotes = await articuloService.findLotes(idArticulo)
            this.actualizarLotes(lotes)
        } catch (error) {
            let message = error.response.data.message
            if(message!=null){
                this.setState({
                    errorMesagge: {open:true, vertical: 'top', horizontal: 'right', message: message}
                })
            }
        }
    }

    getId(){
        return this.props.match.params.id
    }
   
    actualizarArticulo(unArticulo){
        this.setState({
            articulo: unArticulo
        })
    }

    actualizarLotes(lotes){
        this.setState({
            lotes: lotes
        })
    }

    sumarAlCarrito=()=>{
        if(this.state.cantidadElegida>=0){
            let itemNuevo=this.crearItemNuevo()
            console.log(itemNuevo)
        }else{
            this.setState({
                errorMesagge:{open: true,vertical: 'top',horizontal: 'right',message: "Ingrese una cantidad mayor o igual a cero"}
            })
        }
    }

    crearItemNuevo(){
        const itemNuevo=new Item()
        itemNuevo.idArticulo=this.getId()
        itemNuevo.cantidad=this.state.cantidadElegida
        itemNuevo.loteElegido=localStorage.getItem("loteElegido")
        return itemNuevo
    }

    updateCantidadElegida=(event)=>{
        const cantidad=event.target.value
        this.setStateCantidad(cantidad)
    }
    
    setStateCantidad(cantidad){
        this.setState({
            cantidadElegida:cantidad
        })
    }

    closeAlter=()=>{
        this.setState({
            errorMesagge:{open: false,vertical: 'top',horizontal: 'right',message: ""}
        })
    }

    render(){
        const miArticulo = this.state.articulo
        const vertical = this.state.errorMesagge.vertical
        const horizontal = this.state.errorMesagge.horizontal
        const open = this.state.errorMesagge.open
        const errorMessage = this.state.errorMesagge.message
        return(
            <div className="box is-flex bx-detalle">
                <Snackbar anchorOrigin={{ vertical, horizontal }} open={open} autoHideDuration={4000} onClose={this.closeAlter}>
                    <Alert severity="error" sx={{ width: '100%' }} onClose={this.closeAlter}>
                        {errorMessage}
                    </Alert>
                </Snackbar>
                <div className="card is-flex is-flex-direction-column is-align-items-center	w-30 is-justify-content-space-evenly">
                    <figure className="image is-128x128">
                        <img src={miArticulo.imagen}></img>
                    </figure>
                    <div className="card-content">
                        <div className="content">
                            <h4 className='is-4'>{miArticulo.nombre}</h4>
                            {miArticulo.descripcion}
                        </div>
                    </div>
                </div>
                <div className="box is-flex is-flex-wrap-wrap w-70">
                        <div className="content is-flex w-50">
                            <ul type="1">
                                <li><h4 className='is-4'>${miArticulo.precio}</h4></li>
                                <li>Origen: {miArticulo.paisDeOrigen}</li>
                                <li>Tipo: {miArticulo.tipo}</li>
                                <li>Medidas: {miArticulo.medidas} cm</li>
                                <li>Terminacion: {miArticulo.terminacion}</li>
                                <li>Volumen: {miArticulo.litros} lts</li>
                            </ul>
                        </div>
                    <div className="table w-50 overflow-y-scroll max-height-200">
                        <table>
                                <thead>
                                    <tr>
                                        <th>Lote</th>
                                        <th>Cantidad</th>
                                        <th>Seleccion</th>
                                    </tr>
                                </thead>
                                { this.state.lotes.map( (lote)=>
                                    <LoteRow key={lote.numero} lote={lote}></LoteRow>)
                                }
                        </table>
                    </div>
                    <div className='is-flex-grow-1 is-flex is-flex-direction-column is-align-items-end	'>
                            <div className="control">
                                <label className="label">Cantidad</label>
                                <input className="input" type="number" placeholder="Elija la cantidad" onChange={(event)=>this.updateCantidadElegida(event)}></input>
                            </div>
                            <button className="button is-primary" onClick={this.sumarAlCarrito}>Agregar al carrito</button>
                    </div>        
                </div>
            </div>
        )
    }

    static get propTypes() {
        return {
            history: PropTypes.object,
            match: PropTypes.object
        }
    }
}