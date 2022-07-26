export class Item{

    constructor(){
        this.id=0
        this.articulo=0
        this.cantidad=0
        this.loteElegido=0
    }

    static fromJson(itemJson){
        const item=Object.assign(
            new Item(),
            itemJson,
            {}
        )
        return item
    }

    static toJson(newItem){
        console.log(newItem.articulo)
        return {
            idArticulo:newItem.articulo,
            cantidad:newItem.cantidad,
            loteElegido:newItem.loteElegido
        }
    }
}