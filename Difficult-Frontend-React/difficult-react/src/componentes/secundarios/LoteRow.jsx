import React from 'react'
import { PropTypes } from 'prop-types'
import { Lote } from '../../dominio/Lote'

export function LoteRow(props){
    const lote = props.lote

    return(
        <tbody>
            <tr className="table-tr">
                <td>{lote.numero}</td>
                <td>{lote.unidadesDisplonibles}</td>
                <td><input type="checkbox" id="" name="" value=""></input></td>
            </tr>
        </tbody>
    )
}

LoteRow.propTypes = {
    lote:PropTypes.instanceOf(Lote)
}