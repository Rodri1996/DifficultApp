export class Compra{

    constructor(){
        this.id=0
        this.ordenDeCompra=0
        this.fechaCompra=""
        this.cantArticulos=0
        this.importeTotal=0
    }

    static fromJson(compraJson){
        const compra=Object.assign(
            new Compra(),
            compraJson,
            {}
        )
        return compra
    }

    static newCompra(cantidadItems,importeTotal){
        let compra=new Compra()
        compra.cantArticulos=cantidadItems
        compra.importeTotal=importeTotal
        return compra
    }

    static carritoToJson(carrito){
        return {
            cantArticulos:carrito.cantItems,
            importeTotal:carrito.precioTotal
        }
    }

    static compraToJson(compraNueva){
        return {
            cantArticulos:compraNueva.cantArticulos,
            importeTotal:compraNueva.importeTotal
        }
    }
}