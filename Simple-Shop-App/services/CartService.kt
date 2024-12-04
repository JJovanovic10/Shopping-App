package `Simple-Shop-App`.services

import `Simple-Shop-App`.models.ShoppingCart

class CartService(
    private val shoppingCart: ShoppingCart,
    private val productList: Map<String, Double>
) {

    fun showCart(){

        if(shoppingCart.returnCartItems().isEmpty()){
            println("Your shopping cart is empty")
            return
        }

        var totalPrice = 0.0
        println("Items in cart: ")
        shoppingCart.returnCartItems().forEach() { product ->
            val price = productList[product] ?: 0.0
            println("- $product: $price RSD")
            totalPrice += price
        }

//        for(item in shoppingCart.getCartItems()){
//            val price = productList[item] ?: 0.0
//            println("- $item: $price")
//            totalPrice += price
//        }


        println("Total price is: $totalPrice RSD")
    }

}