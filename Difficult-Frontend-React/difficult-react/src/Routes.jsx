
import { BrowserRouter, Route } from 'react-router-dom'
import { Carrito } from './componentes/principales/CarritoDeCompras'
import { DetalleDelProducto } from './componentes/principales/DetalleDelProducto'
import { Home } from './componentes/principales/Home'
import { Login } from './componentes/principales/Login'
import { PerfilDeUsuario } from './componentes/principales/Usuario'


export const DifficultRoutes = () => 
    <BrowserRouter>
        <Route exact={true} path="/" component={Login} />
        <Route exact={true} path="/home" component={Home} />
        <Route exact={true} path="/carrito" component={Carrito} />
        <Route exact={true} path="/perfil" component={PerfilDeUsuario} />
        <Route path="/detalle/:id" component={DetalleDelProducto} />
    </BrowserRouter>