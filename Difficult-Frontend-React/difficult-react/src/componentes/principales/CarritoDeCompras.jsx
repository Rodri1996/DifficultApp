import { Component } from 'react'

export class Carrito extends Component{
    
    render(){
        return(
            <div className="box bx-detalle">
                <h1 className="title is-4">Carrito de compras</h1>
                <div className="max-height-200 overflow-y-scroll">
                    <table className="table table is-bordered">
                        <thead>
                            <tr>
                                <th>Producto</th>
                                <th>Descripcion</th>
                                <th>Lote</th>
                                <th>Cantidad</th>
                                <th>Precio</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>Pepe</td>
                                <td>70,00</td>
                                <td>3</td>
                                <td>$70,00</td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>Pepe</td>
                                <td>70,00</td>
                                <td>3</td>
                                <td>$70,00</td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>Pepe</td>
                                <td>70,00</td>
                                <td>3</td>
                                <td>$70,00</td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>Pepe</td>
                                <td>70,00</td>
                                <td>3</td>
                                <td>$70,00</td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>Pepe</td>
                                <td>70,00</td>
                                <td>3</td>
                                <td>$70,00</td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>Pepe</td>
                                <td>70,00</td>
                                <td>3</td>
                                <td>$70,00</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>Sarasa</td>
                                <td>100,00</td>
                                <td>1</td>
                                <td>$50,00</td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>Pepe</td>
                                <td>70,00</td>
                                <td>3</td>
                                <td>$70,00</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>Sarasa</td>
                                <td>100,00</td>
                                <td>1</td>
                                <td>$50,00</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <span className="tag is-info mt-2"><h5 className='title is-5'>Total: $1500,00</h5></span>
                <div className='is-flex is-justify-content-center'>
                    <button className="button is-primary">Comprar</button>
                    <button className="button is-danger is-outlined">Limpiar carrito</button>
                </div>
            </div>
        )
    }
}