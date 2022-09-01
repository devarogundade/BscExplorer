package dev.arogundade.library.remote.clients

import dev.arogundade.library.data.models.response.BscResponse
import dev.arogundade.library.data.models.stat.Price
import dev.arogundade.library.data.models.stat.Validator
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

    @GET("api")
    suspend fun lastPrice(
        @Query("module") module: String = "stats",
        @Query("action") action: String = "bnbprice",
        @Query("apikey") key: String,
    ): Response<BscResponse<Price>>

}