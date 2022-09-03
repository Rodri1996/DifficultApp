import { PropTypes } from 'prop-types'
import React from 'react'
import { Item } from '../../dominio/Item'

export function ItemRow(props){
    const item = props.item

    // const [articulo, setArticulo] = useState({})

    // useEffect(
    //     async()=>{
    //     const articuloTraido= await articuloService.findArticulo(item.idArticulo)
    //     console.log(articuloTraido)
    //     setArticulo(articuloTraido.data)
    // }
    // ,[])

    return(
        <tbody>
            <tr className="table-tr">
                <td>{item.nombreArticulo}</td>
                <td>{item.descripcion}</td>
                <td>{item.lote}</td>
                <td>{item.cantidad}</td>
                <td><b>$ </b>{item.precio}</td>
            </tr>
        </tbody>
    )
}

ItemRow.propTypes = {
    item:PropTypes.instanceOf(Item),
    //history: PropTypes.object
}