package `Simple-Shop-App`.services

import `Simple-Shop-App`.models.Seller
import `Simple-Shop-App`.models.ShoppingCart
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class InvoiceService(
    private val shoppingCart: ShoppingCart,
    private val productList: Map<String, Double>,
    private val seller : Seller
) {

    fun generateInvoice(){

        if(shoppingCart.returnCartItems().isEmpty()){
            println("Your shopping cart is empty, can't generate invoice")
            return
        }

        var totalPrice = 0.0
        println("Your invoice:")
        println("Informations about seller: Name: ${seller.name}, Contact: ${seller.contact}")
        val currentTime = LocalDateTime.now()
        println("Invoice issuance time: ${currentTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm"))}")


        shoppingCart.returnCartItems().forEach() { product ->
            val price = productList[product] ?: 0.0
            println("- $product: $price RSD")
            totalPrice += price
        }

        println("Total price is: $totalPrice RSD")

//        shoppingCart.clearCart()

    }


}