package `Simple-Shop-App`

import `Simple-Shop-App`.models.Seller
import `Simple-Shop-App`.models.ShoppingCart
import `Simple-Shop-App`.services.CartService
import `Simple-Shop-App`.services.InvoiceService
import `Simple-Shop-App`.services.ProductService

fun main(){

    val productList = mapOf<String, Double>(
        "apple" to 120.00,
        "orange" to 140.00,
        "milk" to 160.00,
        "chocolate" to 170.00,
        "pizza" to 240.00,
        "whole chicken" to 600.00
    )

    val shoppingCart = ShoppingCart()
    val seller = Seller("John Doe", "johndoe@example.com")

    val productService = ProductService(productList)
    val cartService = CartService(shoppingCart, productList)
    val invoiceService = InvoiceService(shoppingCart, productList, seller)

    var lock = true
    while(lock){
        println("\nWelcome to shopping app\n")
        println("1. List all products")
        println("2. Add product do cart")
        println("3. Show cart items")
        println("4. End your shopping")
        println("5. Exit")
        print("Choose an option: ")

        when(readlnOrNull()?.toIntOrNull()){
            1 -> productService.dispalProducts()
            2 -> {
                println("Input name of products u want to add: ")
                val input = readlnOrNull() ?: ""
                val products = input.split(",")

                products.forEach {product ->
                    val trimmedProduct = product.trim() // Trims spaces
                    if(productList.containsKey(trimmedProduct)){
                        shoppingCart.addProduct(trimmedProduct)
                        println("Product $trimmedProduct added successfully")
                    } else {
                        println("Product $trimmedProduct doesn't exist")
                    }
                }
            }
            3 -> cartService.showCart()
            4 -> {
                invoiceService.generateInvoice()
                shoppingCart.clearCart()
            }
            5 -> {
                println("Thanks! See you next time")
                lock = false
            }
            else -> println("Unknown command")
        }
    }



}