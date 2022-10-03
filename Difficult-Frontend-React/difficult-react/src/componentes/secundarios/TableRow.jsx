
import { PropTypes } from 'prop-types'
import { Compra } from '../../dominio/Compra'

export function CompraRow(props){
    const compra = props.compra
    return(
        <tbody>
            <tr className="table-tr">
                <td>{compra.ordenDeCompra}</td>
                <td>{compra.fechaCompra}</td>
                <td>{compra.cantArticulos}</td>
                <td>${compra.importeTotal}</td>
            </tr>
        </tbody>
    )
}

CompraRow.propTypes = {
    compra:PropTypes.instanceOf(Compra),
    //history: PropTypes.object
}