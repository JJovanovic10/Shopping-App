package `Simple-Shop-App`.services

class ProductService(private val products: Map<String, Double>) {

    fun dispalProducts(){

        println("Available products: ")
//        for((k,v) in products){
//            println("Name: $k, price: $v")
//        }
        products.forEach{ (name, price) ->
            println("- $name: $price RSD")
        }
    }

}