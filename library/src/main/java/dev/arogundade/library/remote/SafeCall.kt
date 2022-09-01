package dev.arogundade.library.remote

import dev.arogundade.library.utils.Status

object SafeCall {
    suspend fun <T> execute(request: suspend () -> T): Status<T> {
        return try {
            Status.Success(request())
        } catch (e: Exception) {
            Status.Failure(e)
        }
    }
}