import { PropTypes } from 'prop-types'
//import { withRouter } from 'react-router-dom'
import { useHistory } from "react-router"
import { Articulo } from '../../dominio/Articulo'

export function Card(props){
    const history = useHistory()
    const articulo= props.articulo
    const cambiarDeComponente=()=>{
        const id=props.articulo.id
        history.push(`/detalle/${id}`)
    }
    
    return(
        // <section className="bx-item column card">
        //     <img className="img center-y" src={articulo.imagen}></img>
        //     <div className="bx-item bg-terciario"><span className="margin-p">{articulo.nombre}</span></div>
        //     <h3 className="margin-p"><b>$ {articulo.precio}</b></h3>
        //     <p className="margin-p"><b>Origen: {articulo.paisDeOrigen}</b></p>
        //     <span className="margin-p">{articulo.descripcion}</span>
        //     <button className="button pry-button" onClick={cambiarDeComponente}>Agregar al carrito</button>
        // </section> 
        <div className="card" id='myCard'>
            <header className="card-header">
                <p className="card-header-title">
                    {articulo.nombre}
                </p>
            </header>
            <div className="card-image">
                <figure className="image is-4by3">
                    <img src={articulo.imagen} alt="Placeholder image"></img>
                </figure>
            </div>
            <div className="card-content">
                <div className="content">
                    <h1 className="is-h1">$ {articulo.precio}</h1>
                    <p>Origen: {articulo.paisDeOrigen}</p>
                    <p>{articulo.descripcion}</p>
                </div>
            </div>
            <button className="button pry-button is-primary is-medium" onClick={cambiarDeComponente}>Agregar al carrito</button>
        </div>
    )
}

Card.propTypes = {
    articulo:PropTypes.instanceOf(Articulo),
    //history: PropTypes.object
}

//export default withRouter(Card)