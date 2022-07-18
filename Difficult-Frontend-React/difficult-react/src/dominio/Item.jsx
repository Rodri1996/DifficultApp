export class Item{

    constructor(){
        this.id=0
        this.articulo=""
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
}