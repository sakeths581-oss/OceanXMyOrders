package com.example.oceanxmyorders

data class Order(
    val vehicle: String,
    val date: String,
    val orderId: String,
    val pickup: String,
    val drop: String,
    val price: String
)