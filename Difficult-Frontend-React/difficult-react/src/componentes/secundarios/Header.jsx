// import { useEffect, useState } from 'react'
// import { useHistory } from "react-router-dom"

export const Header=()=>{

    // const history = useHistory('')
    // let [rutaActual,setRutaActual] = useState('')

    // useEffect(() => {
    //     setRutaActual(history.location.pathname)
    //     console.log(rutaActual)
    // })


        return(
            <nav id="navbar" role="navigation" aria-label="main navigation">
                <div className="navbar-brand">
                    <div className="navbar-title">  
                          <h1 className="title is-2">Difficult</h1>
                    </div>
                    {/* <a className="navbar-item" href="https://bulma.io">
                        <img src="https://bulma.io/images/bulma-logo.png" width="112" height="28"></img>
                    </a> */}
                    <a className="navbar-item">Home</a>
                    <a className="navbar-item">Carrito</a>
                    <a className="navbar-item">Perfil</a>
                </div>
            </nav>
        )

}

