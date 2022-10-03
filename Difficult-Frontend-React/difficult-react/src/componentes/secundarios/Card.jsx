import { PropTypes } from 'prop-types'
//import { withRouter } from 'react-router-dom'
import { useHistory } from "react-router"
import { Articulo } from '../../dominio/Articulo'

export function Card(props){
    const history = useHistory()
    const articulo= props.articulo
    const cambiarDeComponente=()=>{
        const id=props.articulo.id
        console.log("id: "+id)
        history.push(`/detalle/${id}`)
    }
    
    return(
        <section className="bx-item column card">
            <img className="img center-y" src={articulo.imagen}></img>
            <div className="bx-item bg-terciario"><span className="margin-p">{articulo.nombre}</span></div>
            <h3 className="margin-p"><b>$ {articulo.precio}</b></h3>
            <p className="margin-p"><b>Origen: {articulo.paisDeOrigen}</b></p>
            <span className="margin-p">{articulo.descripcion}</span>
            <button className="button pry-button" onClick={cambiarDeComponente}>Agregar al carrito</button>
        </section> 
    )
}

Card.propTypes = {
    articulo:PropTypes.instanceOf(Articulo),
    //history: PropTypes.object
}

//export default withRouter(Card)