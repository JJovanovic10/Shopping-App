package `Simple-Shop-App`.models

class ShoppingCart {

    val cartItems = mutableListOf<String>()

    fun addProduct(product: String){
        cartItems.add(product)
    }

    fun removeProduct(product: String){
        try{
            cartItems.remove(product)
        } catch (e: Exception){
            println("There's no such product")
        }
    }

    fun clearCart(){
        cartItems.clear()
    }

    fun returnCartItems() : List<String>{

//        val listOfItems = mutableListOf<String>()
//
//        listOfItems.addAll(cartItems)
//
//
//        return listOfItems

        return cartItems
    }

}