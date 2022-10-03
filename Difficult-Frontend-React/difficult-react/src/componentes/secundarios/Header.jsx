
// import { useHistory } from "react-router"

export function Header(){

    // const history = useHistory()
    const irAHome=()=>{
        window.location.href = '/home'
    }

    return(
        <section className="header">
            <section className="pry-title title-header">
                Difficult
            </section>
            <div className='bx-item header-nav'>
                <div className='bx-item header-nav-items'>
                    <a href="url" className='a' onClick={irAHome}>Ir a Home</a>
                </div>
                <div className='bx-item header-nav-items'>
                    <a href="url" className='a'>0 Items</a>
                </div>
                <div className='bx-item header-nav-items'>
                    <a href="url" className='a'>Ingresar</a>
                </div>
            </div>
        </section>
    )
}