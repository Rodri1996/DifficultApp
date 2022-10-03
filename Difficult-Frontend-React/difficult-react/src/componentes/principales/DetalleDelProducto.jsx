import { Component } from 'react'

import { PropTypes } from 'prop-types'
import { articuloService } from '../services/ArticuloService'
import { Articulo } from '../../dominio/Articulo'
import { LoteRow } from '../secundarios/LoteRow'
import { Item } from '../../dominio/Item'
import { usuarioService } from '../services/UsuarioService'

export class DetalleDelProducto extends Component{
    
    state={
        articulo:new Articulo(),
        lotes:[],
        cantidadElegida:0,
    }

    async componentDidMount(){
        const idArticulo=this.getId()
        await this.getArticulo(idArticulo)
        await this.getLotesArticulo(idArticulo)
        console.info(this.state.articulo)
    }
    
    getId(){
        return this.props.match.params.id
    }
    
    async getArticulo(idArticulo){
        let articuloEncontrado=await articuloService.findArticulo(idArticulo)
        this.updateArticulo(articuloEncontrado)
    }

    async getLotesArticulo(idArticulo){
        const lotesDelArticulo=await articuloService.findLotes(idArticulo)
        this.setState({
            lotes:lotesDelArticulo
        })
        console.info(this.state.lotes)
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

    sumarAlCarrito=async()=>{
        let itemNuevo=this.crearItemNuevo()
        const usuario=usuarioService.findUser()
        this.setStateCantidad(0)
        // let idArticulo=this.getId()
        // await this.getArticulo(idArticulo)
        await usuarioService.postItem(usuario.id,itemNuevo)
    }
    
    crearItemNuevo(){
        const itemNuevo=new Item()
        itemNuevo.articulo=this.getId()
        itemNuevo.cantidad=this.state.cantidadElegida
        itemNuevo.loteElegido=localStorage.getItem("loteElegido")
        return itemNuevo
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
                                <p className={`margin-p ${articuloPosta.medidas}`}><b>Medidas: </b>{articuloPosta.medidas} cm</p>
                                <p className={`margin-p ${articuloPosta.terminacion}`}><b>Terminacion: </b>{articuloPosta.terminacion}</p>
                                <p className={`margin-p ${articuloPosta.litros}`}><b>Litros: </b>{articuloPosta.litros} lts</p>
                                <p className={`margin-p ${articuloPosta.rendimiento}`}><b>Litros: </b>{articuloPosta.rendimiento}</p>
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