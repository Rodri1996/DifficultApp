import React, { Component } from 'react'
import { PropTypes } from 'prop-types'
import { usuarioService } from "../services/UsuarioService"

export class Login extends Component{
    
    state={
        usuario: '',
        contraseña: ''
    }

    getUsuario = async ()=>{
        const usuario = this.state.usuario
        const contraseña = this.state.contraseña
        const usuarioLogueado = await usuarioService.getUsuarioLogueado(usuario,contraseña)
        console.info(usuarioLogueado)
        localStorage.setItem("usuarioLogeado",JSON.stringify(usuarioLogueado.data))
        this.props.history.push('/home')
    }
    
    cambiarNombreDeUsuario = (event) => {
        const nombreUsuario = event.target.value
        this.setNombreUsuario(nombreUsuario)
    }

    setNombreUsuario=(nombreUsuario)=>{
        this.setState({
            usuario:nombreUsuario
        })
    }

    cambiarPasswordDeUsuario=(event)=>{
        const passwordUsuario = event.target.value
        this.setContraseñaUsuario(passwordUsuario)
    }

    setContraseñaUsuario=(passwordUsuario)=>{
        this.setState({
            contraseña:passwordUsuario
        })
    }

    render(){
        return(
            <section className="bx-item login column">
                <p className="pry-title">Difficult</p>
                <div className="label-input">
                    <label>Usuario</label>
                    <input className="input" onChange={this.cambiarNombreDeUsuario}></input>
                </div>
                <div className="label-input">
                    <label>Contraseña</label>
                    <input className="input" type={"password"} 
                        onChange={this.cambiarPasswordDeUsuario}></input>
                </div>
                <button  className="button pry-button"
                    onClick={this.getUsuario}>Ingresar</button>
            </section>
        )
    }

    static get propTypes() {
        return {
          history: PropTypes.object,
        }
    }
}