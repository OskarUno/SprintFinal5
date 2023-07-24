package com.awakelab.oskar.sprintfinal5

data class Articulo(
    val idItem: String,
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
                    "Columbia",
                    "Botín Redmond™ V2 Mid WP",
                    103990,
                    "https://zapatoscl.vtexassets.com/arquivos/ids/371965-800-auto?v=637290905941000000&width=800&height=auto&aspect=true"
                )
            )
            tienda.add(
                Articulo(
                    "3",
                    "Hush Puppies",
                    "Botin Cuero Hombre Maxwell",
                    44990,
                    "https://zapatoscl.vtexassets.com/arquivos/ids/1021028-800-auto?v=638107233127870000&width=800&height=auto&aspect=true"
                )
            )
            tienda.add(
                Articulo(
                    "4",
                    "Rockford",
                    "Botín Hombre Egger",
                    59994,
                    "https://zapatoscl.vtexassets.com/arquivos/ids/1151028-800-auto?v=638207150888470000&width=800&height=auto&aspect=true"
                )
            )
            tienda.add(
                Articulo(
                    "5",
                    "Caterpillar",
                    "Botín Renovate WP Hombre",
                    35200,
                    "https://zapatoscl.vtexassets.com/arquivos/ids/1045741-800-auto?v=638113801174170000&width=800&height=auto&aspect=true"
                )
            )
            tienda.add(
                Articulo(
                    "6",
                    "Norseg",
                    "Botín de Seguridad Hombre New Corner",
                    59990,
                    "https://zapatoscl.vtexassets.com/arquivos/ids/173805-800-auto?v=637282248298830000&width=800&height=auto&aspect=true"
                )
            )
            tienda.add(
                Articulo(
                    "7",
                    "Merrell",
                    "Botin Hombre Wildwood Mid Waterproof",
                    69993,
                    "https://zapatoscl.vtexassets.com/arquivos/ids/1124630-800-auto?v=638175211374800000&width=800&height=auto&aspect=true"
                )
            )
            tienda.add(
                Articulo(
                    "8",
                    "Hush Puppies",
                    "Zapatilla Cuero Mujer Space",
                    18990,
                    "https://zapatoscl.vtexassets.com/arquivos/ids/545312-280-280?v=637369851789730000&width=280&height=280&aspect=true"
                )
            )
            tienda.add(
                Articulo(
                    "9",
                    "Columbia",
                    "Facer 75 MID Outdry",
                    169400,
                    "https://zapatoscl.vtexassets.com/arquivos/ids/1112388-800-auto?v=638161383186030000&width=800&height=auto&aspect=true"
                )
            )
            tienda.add(
                Articulo(
                    "10",
                    "Hush Puppies",
                    "Zapato Cuero Hombre Intee",
                    59990,
                    "https://zapatoscl.vtexassets.com/arquivos/ids/1022344-800-auto?v=638107247301870000&width=800&height=auto&aspect=true"
                )
            )
            return tienda
        }
    }
}
