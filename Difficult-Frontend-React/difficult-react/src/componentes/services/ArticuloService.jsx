import axios from 'axios'
import { Articulo } from "../../dominio/Articulo"
import { Lote } from '../../dominio/Lote'

class ArticuloService{
    
    async allArticulos(){
        const articulosJson= await axios.get('http://localhost:8080/articulos')
        return articulosJson.data.map((articuloJson)=>Articulo.fromJson(articuloJson))
    }

    async findArticulo(idArticulo){
        const articuloJson= await axios.get(`http://localhost:8080/articulo/${idArticulo}`)
        return Articulo.fromJson(articuloJson)
    }

    async findLotes(idArticulo){
        const lotesJson=await axios.get(`http://localhost:8080/lotes/${idArticulo}`)
        return lotesJson.data.map((lote)=> Lote.fromJson(lote))
    }
}

export const articuloService=new ArticuloService()