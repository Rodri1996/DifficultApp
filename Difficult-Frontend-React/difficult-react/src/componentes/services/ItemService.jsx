class ItemService{

    constructor(){
        this.contador=0
    }

    agregarId(newItem){
        newItem.id=this.contador
        this.contador=this.contador+1
        return newItem
    }
}

export const itemService=new ItemService()