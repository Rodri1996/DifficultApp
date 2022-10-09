export class Usuario{

    constructor(){
        this.id=""
        this.nombre=""
        this.items=0
        this.foto=""
        this.usuario=""
        this.contrasenia=""
    }

    static fromJson(usuarioLogueadoJson){
        const usuarioLogueado = Object.assign(
            new Usuario(),
            usuarioLogueadoJson, 
            {}
        )
        return usuarioLogueado
    }

    static toJson(usuario,contraseña){
        return {
            usuario:usuario,
            contrasenia:contraseña
        }
    }
}