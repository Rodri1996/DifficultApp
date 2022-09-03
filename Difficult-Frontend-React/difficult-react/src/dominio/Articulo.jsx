export class Articulo{

    constructor(){
        this.id=0
        this.paisDeOrigen=""
        this.puntaje=0
        this.imagen=""
        this.precioBase=0
        this.nombre=""
        this.descripcion=""
        this.rendimiento=0
        this.litros=0
        this.tipo=""
        this.precio=0
        this.medidas=""
        this.terminacion=""
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