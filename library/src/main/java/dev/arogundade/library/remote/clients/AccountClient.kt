package dev.arogundade.library.remote.clients

import dev.arogundade.library.data.models.account.Balance
import dev.arogundade.library.data.models.account.InternalTransaction
import dev.arogundade.library.data.models.account.Transaction
import dev.arogundade.library.data.models.response.BscResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AccountClient {

    @GET("api")
    suspend fun getBnbBalance(
        @Query("module") module: String = "account",
        @Query("action") action: String = "balance",
        @Query("address") address: String,
        @Query("apikey") key: String,
    ): Response<BscResponse<Long>>

    @GET("api")
    suspend fun getBnbBalance(
        @Query("module") module: String = "account",
        @Query("action") action: String = "balancemulti",
        @Query("address") address: List<String>,
        @Query("tag") tag: String = "latest",
        @Query("apikey") key: String,
    ): Response<BscResponse<List<Balance>>>

    @GET("api")
    suspend fun getTransactions(
        @Query("module") module: String = "account",
        @Query("action") action: String = "txlist",
        @Query("startblock") startBlock: Int,
        @Query("endblock") endBlock: Int,
        @Query("page") page: Int,
        @Query("offset") perPage: Int,
        @Query("sort") sort: String,
        @Query("address") address: String,
        @Query("apikey") key: String,
    ): Response<BscResponse<List<Transaction>>>

    @GET("api")
    suspend fun getInternalTransactions(
        @Query("module") module: String = "account",
        @Query("action") action: String = "txlistinternal",
        @Query("startblock") startBlock: Int,
        @Query("endblock") endBlock: Int,
        @Query("page") page: Int,
        @Query("offset") perPage: Int,
        @Query("sort") sort: String,
        @Query("address") address: String,
        @Query("apikey") key: String,
    ): Response<BscResponse<List<InternalTransaction>>>

}