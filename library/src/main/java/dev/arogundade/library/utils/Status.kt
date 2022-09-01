package dev.arogundade.library.utils

sealed class Status<T>(val e: Exception?, val data: T?) {
    class Success<T>(data: T) : Status<T>(null, data)
    class Failure<T>(e: Exception?) : Status<T>(e, null)
}