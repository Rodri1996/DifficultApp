export class Articulo{

    constructor(){
        this.precioBase=0
        this.idArticulo=0
        this.origen=""
        this.puntaje=0
        this.imagen=""
        this.nombre=""
        this.descripcion=""
        this.tipo=""
        this.medidas=""
        this.terminacion=""
        this.precio=0
    }

    static fromJson(articuloJson){
        const articulo = Object.assign(
            new Articulo(),
            articuloJson, 
            {}
        )
        return articulo
    }
}