import React, { Component } from 'react'
import { Usuario } from '../../dominio/Usuario'
import { CompraRow } from '../secundarios/TableRow'
import { usuarioService } from '../services/UsuarioService'

export class PerfilDeUsuario extends Component{

    state={
        usuario:new Usuario(),
        compras:[]
    }

    async componentDidMount(){
        //TODO: Ver que sacar al usuario del local storage se haga una unica vez. Q lo haga el service del usuario
        const usuario=usuarioService.findUser()
        const compras= await usuarioService.getComprasHechas(usuario.id)
        this.setUsuario(usuario)
        this.setComprasHechas(compras)
        console.info(this.state.compras)
    }

    setUsuario=(usuario)=>{
        this.setState({
            usuario:usuario
        })
    }

    setComprasHechas=(compras)=>{
        this.setState({
            compras:compras
        })
    }

    render(){
        const usuario=this.state.usuario
        return(
            <section className="bx-item column perfil">
                <h1>Perfil de usuario</h1>
                <section className="bx-item">
                    <img className="img mt-5" src={usuario.foto}></img>
                    
                        <div className="label-input lbl-medium">
                            <label>Nombre</label>
                            <input className="input"></input>
                            <label>Apellido</label>
                            <input className="input"></input>
                        </div>
                        <div className="label-input lbl-medium">
                            <label>Edad</label>
                            <input className="input"></input>
                            <label>Saldo</label>
                            <input className="input"></input>
                        </div>
                </section>
                    <h3 className="mt-5">Compras realizadas</h3>
                <section className="table-container">
                    <table>
                        <thead>
                            <tr className="table-header">
                                <th>Orden de compra</th>
                                <th>Fecha</th>
                                <th>Cantidad de articulos</th>
                                <th>Importe total</th>
                            </tr>
                        </thead>
                        {   
                            this.state.compras.map(
                                (compra)=>
                                    <CompraRow
                                        key={compra.id}
                                        compra={compra}
                                    />
                            )
                        }    
                    </table>
                </section>
            </section>
        )
    }
}