package dev.arogundade.library.data.repository

import dev.arogundade.library.remote.SafeCall.execute
import dev.arogundade.library.remote.clients.TokenClient
import javax.inject.Inject

class TokenRepository @Inject constructor(
    private val tokenClient: TokenClient
) {

    suspend fun getTokenCirculatingSupply(contractAddress: String, key: String) = execute {
        tokenClient.getTokenCirculatingSupply(contractAddress = contractAddress, key = key)
            .body()?.result
    }

    suspend fun getTokenTotalSupply(contractAddress: String, key: String) = execute {
        tokenClient.getTokenTotalSupply(contractAddress = contractAddress, key = key)
            .body()?.result
    }

}