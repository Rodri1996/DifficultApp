import React, { Component } from 'react'
import { Card } from "../secundarios/Card"
import { articuloService } from "../services/ArticuloService"

export class Home extends Component{

    state={
        articulos:[]
    }

    async componentDidMount(){
        const articulosTraidos=await articuloService.allArticulos()
        this.setArticulos(articulosTraidos)
    }

    setArticulos=(articulosTraidos)=>{
        this.setState({
            articulos:articulosTraidos
        })
        console.info(this.state.articulos)
    }

    render(){
        return(
            <section className="bx-item home">
                <section className="bx-item column home-filtros">
                    <h2>Filtros</h2>
                    <h3>Puntaje</h3>
                        <span><input type="checkbox" id="" name="" value="5"></input> 5 puntos </span>
                        <span><input type="checkbox" id="" name="" value="4"></input> 4 puntos o mas</span>
                        <span><input type="checkbox" id="" name="" value="3"></input> 3 puntos o mas </span>
                        <span><input type="checkbox" id="" name="" value="2"></input> 2 puntos o mas</span>
                        <span><input type="checkbox" id="" name="" value=""></input> Todos</span>
                    <h3>Origen</h3>
                        <span><input type="checkbox" id="" name="" value="Argentina"></input> Argentina </span>
                        <span><input type="checkbox" id="" name="" value="Brasil"></input> Brasil</span>
                        <span><input type="checkbox" id="" name="" value=""></input> Todos</span>
                </section>
                <section className="bx-item card-container">
                    {
                        this.state.articulos.map(
                            (articulo)=>
                                <Card articulo={articulo} key={articulo.id}/>
                        )
                    } 
                      
                </section>    
            </section>
        )
    }
}