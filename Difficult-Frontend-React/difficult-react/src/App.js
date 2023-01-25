
import './App.css'
import { Header } from './componentes/secundarios/Header'
import { DifficultRoutes } from './Routes'
import 'bulma/css/bulma.min.css'

function App() {

  return (
    <div className='bx-principal'>
      <Header></Header>
      <DifficultRoutes/>
      <footer className='myFooter'>Difficult App/2022</footer>
    </div>
  )
}

export default App
