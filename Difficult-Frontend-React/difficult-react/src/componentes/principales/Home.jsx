import { Component } from 'react'
import { Card } from '../secundarios/Card'
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
            <div className="box is-flex home">
                <div className="box filtro-container">
                    <h4 className="title is-4">Filtros</h4>
                    <h5 className='title is-5'>Puntaje</h5>
                    <ul>
                        <li><label className="checkbox"><input type="checkbox"></input> 5 puntos </label></li>
                        <li><label className="checkbox"><input type="checkbox"></input> 4 puntos ó más </label></li>
                        <li><label className="checkbox"><input type="checkbox"></input> 3 puntos ó más </label></li>
                        <li><label className="checkbox"><input type="checkbox"></input> 2 puntos ó más </label></li>
                        <li><label className="checkbox"><input type="checkbox"></input> Todos </label></li>
                    </ul>
                    <h5 className='title is-5'>Origen</h5>
                    <ul>
                        <li><label className="checkbox"><input type="checkbox"></input> Argentina </label></li>
                        <li><label className="checkbox"><input type="checkbox"></input> Brasil </label></li>
                        <li><label className="checkbox"><input type="checkbox"></input> Todos </label></li>
                    </ul>
                </div>
                <div className="box is-flex is-flex-wrap-wrap card-container">
                    {this.state.articulos.map((unArticulo)=>
                        <Card articulo={unArticulo} key={unArticulo.id}></Card>
                    )}
                </div>    
            </div>
        )
    }
}