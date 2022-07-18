import React from 'react'
import './App.css'

// import { Home } from './componentes/principales/Home'
// import { DetalleDelProducto } from './componentes/principales/DetalleDelProducto'
// import { Carrito } from './componentes/principales/CarritoDeCompras'
// import { PerfilDeUsuario } from './componentes/principales/Usuario'
import { Header } from './componentes/secundarios/Header'
import { DifficultRoutes } from './Routes'
// import { Login } from './componentes/principales/Login'

function App() {
  return (
    <div className='bx-principal'>
      <Header></Header>
      {/* <DetalleDelProducto></DetalleDelProducto> */}
      {/* <PerfilDeUsuario></PerfilDeUsuario> */}
      {/* <Login></Login> */}
      {/* <Carrito></Carrito> */}
      {/* <Home></Home> */}
      <DifficultRoutes/>
      <footer className='footer'>Difficult App/2022</footer>
    </div>
  )
}

export default App
