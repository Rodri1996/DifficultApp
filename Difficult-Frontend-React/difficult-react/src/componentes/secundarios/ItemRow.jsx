import React, {useEffect, useState } from 'react'
import { PropTypes } from 'prop-types'
import { Item } from '../../dominio/Item'
import { articuloService } from '../services/ArticuloService'

export function ItemRow(props){
    const item = props.item

    const [articulo, setArticulo] = useState({})

    useEffect(
        async()=>{
        const articuloTraido= await articuloService.findArticulo(item.idArticulo)
        console.log(articuloTraido)
        setArticulo(articuloTraido.data)
    }
    ,[])

    return(
        <tbody>
            <tr className="table-tr">
                <td>{articulo.nombre}</td>
                <td>{articulo.descripcion}</td>
                <td>{item.loteElegido}</td>
                <td>{item.cantidad}</td>
                <td><b>$ </b>{articulo.precio}</td>
            </tr>
        </tbody>
    )
}

ItemRow.propTypes = {
    item:PropTypes.instanceOf(Item),
    //history: PropTypes.object
}