import React, { Component } from 'react'

import { PropTypes } from 'prop-types'
import { articuloService } from '../services/ArticuloService'
import { Articulo } from '../../dominio/Articulo'
import { LoteRow } from '../secundarios/LoteRow'
import { Item } from '../../dominio/Item'

export class DetalleDelProducto extends Component{
    
    state={
        articulo:new Articulo(),
        lotes:[],
        cantidadElegida:0,
    }

    async componentDidMount(){
        const idArticulo=this.getId()
        const articuloEncontrado=await articuloService.findArticulo(idArticulo)
        this.getLotesArticulo(idArticulo)
        this.updateArticulo(articuloEncontrado)
        // console.log(this.state.articulo.data)
    }
    
    getId(){
        return this.props.match.params.id
    }
    
    async getLotesArticulo(idArticulo){
        const lotesDelArticulo=await articuloService.findLotes(idArticulo)
        this.setState({
            lotes:lotesDelArticulo
        })
    }
    
    updateArticulo(articuloEncontrado){
        this.setState({
            articulo:articuloEncontrado.data
        })
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

    sumarAlCarrito=()=>{
        const itemNuevo=new Item()
        itemNuevo.articulo=this.getId()
        itemNuevo.cantidad=this.state.cantidadElegida
        this.setStateCantidad(0)
        console.log(itemNuevo)
    }

    render(){     
        const articuloPosta=this.state.articulo
        return(
                <section className="bx-item detalle">
                    <section className="bx-item column detalle-col-desc">
                        <section className="bx-item"> 
                            <img className="img" src={articuloPosta.imagen}></img>
                        </section>    
                        <section className="bx-item detalle-desc">
                        <h3>{articuloPosta.nombre}</h3>
                        <p>{articuloPosta.descripcion}</p>
                        </section>
                    </section>
                    <section className="bx-item column">
                        <p className="pry-title detalle-precio">$ {articuloPosta.precio}</p>  
                        <section className="bx-item">
                            <section className="bx-item column detalle-info">
                                <p className="margin-p"><b>Origen: </b>{articuloPosta.paisDeOrigen}</p>
                                {/* <p className="margin-p"><b>Tipo: </b>{articulo.tipo}</p> */}
                                <p className="margin-p"><b>Medidas: </b>{articuloPosta.medidas}</p>
                                <p className="margin-p"><b>Terminacion: </b>{articuloPosta.terminacion}</p>
                            </section>
                            
                            <section className="table-container detalle-info">
                                <table>
                                    <thead>
                                        <tr className="table-header">
                                            <th>Lote</th>
                                            <th>Cantidad</th>
                                            <th>Seleccion</th>
                                        </tr>
                                    </thead>
                                        {
                                            this.state.lotes.map(
                                                (lote)=>
                                                    <LoteRow
                                                        key={lote.numero}
                                                        lote={lote}
                                                    />
                                            )
                                        }
                                    
                                </table>
                            </section>
                        </section>
                        <section className="bx-item column detalle-cantidad">
                        <div className="label-input detalle-input">
                            <label>Cantidad</label>
                            <input className="input" onChange={this.updateCantidadElegida} value={this.state.cantidadElegida}></input>
                        </div>
                            <button className="button pry-button" onClick={this.sumarAlCarrito}>Agregar al carrito</button>
                        </section>
                    </section>
                </section>
            )
    }

    static get propTypes() {
        return {
            history: PropTypes.object,
            match: PropTypes.object,
        }
    }
}