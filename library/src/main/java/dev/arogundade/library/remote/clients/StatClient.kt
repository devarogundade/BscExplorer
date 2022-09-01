package dev.arogundade.library.remote.clients

import dev.arogundade.library.data.models.account.Balance
import dev.arogundade.library.data.models.account.InternalTransaction
import dev.arogundade.library.data.models.account.Transaction
import dev.arogundade.library.data.models.response.BscResponse
import dev.arogundade.library.data.models.stat.Validator
import dev.arogundade.library.data.models.transaction.TransactionStatus
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StatClient {

    @GET("api")
    suspend fun getValidators(
        @Query("module") module: String = "stats",
        @Query("action") action: String = "validators",
        @Query("apikey") key: String,
    ): Response<BscResponse<List<Validator>>>

}