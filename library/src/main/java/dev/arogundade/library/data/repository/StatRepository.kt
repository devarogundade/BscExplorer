package dev.arogundade.library.data.repository

import dev.arogundade.library.remote.clients.TransactionClient
import dev.arogundade.library.remote.SafeCall
import dev.arogundade.library.remote.clients.StatClient
import javax.inject.Inject

class StatRepository @Inject constructor(
    private val statClient: StatClient
) {

    suspend fun getValidators(key: String) = SafeCall.execute {
        statClient.getValidators(key = key).body()?.result
    }

}