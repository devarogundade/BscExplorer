package dev.arogundade.library.remote.clients

import dev.arogundade.library.data.models.response.BscResponse
import dev.arogundade.library.data.models.transaction.TransactionStatus
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TransactionClient {

    @GET("api")
    suspend fun checkTransaction(
        @Query("module") module: String = "transaction",
        @Query("action") action: String = "gettxreceiptstatus",
        @Query("txhash") txHash: String,
        @Query("apikey") key: String,
    ): Response<BscResponse<TransactionStatus>>

}