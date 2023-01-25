import { Snackbar } from '@material-ui/core'
import { Alert } from '@mui/material'
import React, { useState } from 'react'
import { useHistory } from "react-router-dom"
import { usuarioService } from '../services/UsuarioService'

export const Login =()=> {
    const [usuario,setUsuario] = useState('')
    const [password,setPassword] = useState('')
    const history = useHistory()
    const [errorMessage, setErrorMessage] = React.useState({
        open: false,
        vertical: 'top',
        horizontal: 'right',
        message: ""
    })
    const { vertical, horizontal, open } = errorMessage

    const iniciarSesion = async () =>{
        try {
            let usuarioTraido = await usuarioService.getUsuarioLogueado(usuario,password)
            localStorage.setItem("usuarioLogeado",JSON.stringify(usuarioTraido.data))
            history.push('/home')
        } catch (error) {
            let message = error.response.data.message
            if(message!=null){
                setErrorMessage({open:true, vertical: 'top', horizontal: 'right', message: message})
            }
        }
    }

    const handleClose = () => {
        setErrorMessage({ ...errorMessage, open: false })
    }

    // PROBAR HACER UNA FORMULARIO DE INICIO DE SESION SACADO DE OTRO FRAMEWORK <> DE BULMA
    return(
        <section className="bx-item login column">
                <Snackbar anchorOrigin={{ vertical, horizontal }} open={open} autoHideDuration={4000} onClose={handleClose}>
                    <Alert onClose={handleClose} severity="error" sx={{ width: '100%' }}>
                        {errorMessage.message}
                    </Alert>
                </Snackbar>
                <p className="pry-title">Difficult</p>
                <div className="label-input">
                    <label>Usuario</label>
                    <input className="input" onChange={(event)=>{setUsuario(event.target.value)}}></input>
                </div>
                <div className="label-input">
                    <label>Contraseña</label>
                    <input className="input" type={"password"} onChange={(event)=>{setPassword(event.target.value)}}></input>
                </div>
                <button  className="button pry-button" onClick={iniciarSesion}>Ingresar</button>
        </section>
    )
}