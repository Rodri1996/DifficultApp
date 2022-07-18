export class Lote{

    constructor(){
        this.fechaDeIngreso=""
        this.unidadesDisplonibles=0
        this.numero=0
    }

    static fromJson(loteJson){
        const lote=Object.assign(
            new Lote(),
            loteJson,
            {}
        )
        return lote
    }
}