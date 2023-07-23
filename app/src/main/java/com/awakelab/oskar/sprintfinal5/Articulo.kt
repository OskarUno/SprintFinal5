package com.awakelab.oskar.sprintfinal5

data class Articulo(
    val id: String,
    val nombre: String,
    val tipo: String,
    val precio: Int,
    val imgUrl: String
)

class Tienda {

    companion object {
        fun getTienda(): List<Articulo> {
            val tienda = mutableListOf<Articulo>()
            tienda.add(
                Articulo(
                    "1",
                    "Merrel",
                    "Zapatilla Mujer Wildwood",
                    29900,
                    "https://zapatoscl.vtexassets.com/arquivos/ids/510445-280-280?v=637344113208170000&width=280&height=280&aspect=true"
                )
            )
            tienda.add(
                Articulo(
                    "2",
                    "Hush Puppies",
                    "Zapatilla Cuero Mujer Space",
                    39990,
                    "https://zapatoscl.vtexassets.com/arquivos/ids/545312-280-280?v=637369851789730000&width=280&height=280&aspect=true"
                )
            )
            return tienda
        }
    }
}
