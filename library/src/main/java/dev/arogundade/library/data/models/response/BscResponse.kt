package dev.arogundade.library.data.models.response

data class BscResponse<T>(
    val status: String,
    val message: String,
    val result: T?
)