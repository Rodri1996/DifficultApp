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
}