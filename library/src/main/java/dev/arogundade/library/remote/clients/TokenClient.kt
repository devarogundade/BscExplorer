package dev.arogundade.library.remote.clients

import dev.arogundade.library.data.models.response.BscResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TokenClient {

    @GET("api")
    suspend fun getTokenCirculatingSupply(
        @Query("module") module: String = "stats",
        @Query("action") action: String = "tokenCsupply",
        @Query("contractaddress") contractAddress: String,
        @Query("apikey") key: String
    ): Response<BscResponse<Double>>

    @GET("api")
    suspend fun getTokenTotalSupply(
        @Query("module") module: String = "stats",
        @Query("action") action: String = "tokensupply",
        @Query("contractaddress") contractAddress: String,
        @Query("apikey") key: String
    ): Response<BscResponse<Double>>

}