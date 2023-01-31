import React from 'react'
import { Alert, Snackbar } from '@mui/material'
import { useState } from 'react'
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
            console.info(history.location.pathname)
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

    return(
        <section className='is-flex is-flex-direction-column box-loguin'>
            <Snackbar anchorOrigin={{ vertical, horizontal }} open={open} autoHideDuration={4000} onClose={handleClose}>
                    <Alert onClose={handleClose} severity="error" sx={{ width: '100%' }}>
                        {errorMessage.message}
                    </Alert>
                </Snackbar>
            <h1><b>Difficult App</b></h1>
            <input className="input is-primary" type="text" placeholder="Ingrese su nombre de usuario" onChange={(event)=>{setUsuario(event.target.value)}}></input>
            <input className="input is-primary" type="password" placeholder="Ingrese su contraseña" onChange={(event)=>{setPassword(event.target.value)}}></input>
            <button className="button is-primary" onClick={iniciarSesion}><b>Iniciar sesion</b></button>
        </section>
    )
}