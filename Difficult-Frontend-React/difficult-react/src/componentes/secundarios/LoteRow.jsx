
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
                <tr>
                        <td>{lote.numero}</td>
                        <td>{lote.unidadesDisplonibles}</td>
                        <td><label className="checkbox" onClick={opcionMarcada}><input type="checkbox"></input></label></td>
                </tr>
           </tbody>         
                
    )
}

LoteRow.propTypes = {
    lote:PropTypes.instanceOf(Lote)
}