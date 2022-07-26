import React from 'react'
import { PropTypes } from 'prop-types'
import { Lote } from '../../dominio/Lote'

export function LoteRow(props){
    const lote = props.lote
    let flag=false

    const opcionMarcada=()=>{
        flag=!flag
        if(flag){
            localStorage.setItem("loteElegido",JSON.stringify(lote.numero))
        }else{
            localStorage.setItem("loteElegido",JSON.stringify(""))
        }
    }

    return(
        <tbody>
            <tr className="table-tr">
                <td>{lote.numero}</td>
                <td>{lote.unidadesDisplonibles}</td>
                <td><input type="checkbox" id="" name="" value="" onClick={opcionMarcada}></input></td>
            </tr>
        </tbody>
    )
}

LoteRow.propTypes = {
    lote:PropTypes.instanceOf(Lote),
    // getLoteElegido: PropTypes.func,
}