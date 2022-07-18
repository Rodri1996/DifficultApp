import React from 'react'
import { PropTypes } from 'prop-types'
import { Item } from '../../dominio/Item'

export function ItemRow(props){
    const item = props.item
    return(
        <tbody>
            <tr className="table-tr">
                <td>{item.articulo}</td>
                <td>{item.cantidad}</td>
                <td>{item.loteElegido}</td>
            </tr>
        </tbody>
    )
}

ItemRow.propTypes = {
    item:PropTypes.instanceOf(Item),
    //history: PropTypes.object
}