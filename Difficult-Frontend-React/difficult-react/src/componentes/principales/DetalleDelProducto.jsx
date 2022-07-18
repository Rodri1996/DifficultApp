import React, { Component } from 'react'

import { PropTypes } from 'prop-types'
import { articuloService } from '../services/ArticuloService'
import { Articulo } from '../../dominio/Articulo'
import { LoteRow } from '../secundarios/LoteRow'

export class DetalleDelProducto extends Component{

    state={
       articulo:new Articulo(),
       lotes:[],
       loteElegido:0
    }

    async componentDidMount(){
        const idArticulo=this.props.match.params.id
        await this.setArticulo(idArticulo)
        await this.setItems(idArticulo)
    }

    async setArticulo(idArticulo){
        const articuloTraido=await articuloService.findArticulo(idArticulo)
        this.setState({
            articulo:articuloTraido.data
        })
    }

    async setItems(idArticulo){
        const lotes=await articuloService.findLotes(idArticulo)
        this.setState({
            lotes:lotes
        })
        console.log(this.state.lotes)
    }
   
    render(){     
        const articulo=this.state.articulo
        return(
                <section className="bx-item detalle">
                    <section className="bx-item column detalle-col-desc">
                        <section className="bx-item"> 
                            <img className="img" src={articulo.imagen}></img>
                        </section>    
                        <section className="bx-item detalle-desc">
                        <h3>{articulo.nombre}</h3>
                        <p>{articulo.descripcion}</p>
                        </section>
                    </section>
                    <section className="bx-item column">
                        <p className="pry-title detalle-precio">$ {articulo.precio}</p>  
                        <section className="bx-item">
                            <section className="bx-item column detalle-info">
                                <p className="margin-p"><b>Origen: </b>{articulo.paisDeOrigen}</p>
                                {/* <p className="margin-p"><b>Tipo: </b>{articulo.tipo}</p> */}
                                <p className="margin-p"><b>Medidas: </b>{articulo.medidas}</p>
                                <p className="margin-p"><b>Terminacion: </b>{articulo.terminacion}</p>
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
                            <input className="input"></input>
                        </div>
                            <button className="button pry-button">Agregar al carrito</button>
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