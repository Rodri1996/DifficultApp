import React, { Component } from 'react'

import { PropTypes } from 'prop-types'
import { articuloService } from '../services/ArticuloService'
import { Articulo } from '../../dominio/Articulo'
import { LoteRow } from '../secundarios/LoteRow'
import { usuarioService } from '../services/UsuarioService'
import { Usuario } from '../../dominio/Usuario'
import { Item } from '../../dominio/Item'

export class DetalleDelProducto extends Component{

    state={
       articulo:new Articulo(),
       usuario:new Usuario(),
       lotes:[],
       loteElegido:0,
       cantArticulosElegido:0,
       idArticulo:0
    }

    async componentDidMount(){
        const usuario=usuarioService.findUser()
        this.setIdArticulo()
        await this.setArticulo(this.state.idArticulo)
        await this.setLotes(this.state.idArticulo)
        this.setUsuario(usuario)
    }


    setIdArticulo=()=>{
        const idArticulo=this.props.match.params.id
        this.setState({
            idArticulo:idArticulo
        })
    }

    setUsuario=(usuario)=>{
        this.setState({
            usuario:usuario
        })
    }

    async setArticulo(){
        const articuloTraido=await articuloService.findArticulo(this.state.idArticulo)
        this.setState({
            articulo:articuloTraido.data
        })
    }

    async setLotes(){
        const lotes=await articuloService.findLotes(this.state.idArticulo)
        this.setState({
            lotes:lotes
        })
    }

    cambiarValorInput=(event)=>{
        const cantidad = event.target.value
        this.setContraseĆ±aUsuario(cantidad)
    }
   
    setContraseĆ±aUsuario=(cantidad)=>{
        this.setState({
            cantArticulosElegido:cantidad
        })
    }

    sumarAlCarrito=async()=>{
        const idUsuario=this.state.usuario.id
        const newItem=this.crearNewItem()
        await usuarioService.postItem(idUsuario,newItem)
        this.setLotes()
    }

    crearNewItem(){
        const newItem=new Item()
        newItem.articulo=this.state.articulo.id
        newItem.cantidad=this.state.cantArticulosElegido
        return newItem
    }

    funcion=(numero)=>{
        console.log("lote elegido: "+numero)
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
                                                        opcion={this.funcion}
                                                    />
                                            )
                                        }
                                    
                                </table>
                            </section>
                        </section>
                        <section className="bx-item column detalle-cantidad">
                        <div className="label-input detalle-input">
                            <label>Cantidad</label>
                            <input className="input" onChange={this.cambiarValorInput}></input>
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