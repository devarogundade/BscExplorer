package dev.arogundade.library.data.repository

import dev.arogundade.library.remote.BscClient
import dev.arogundade.library.remote.SafeCall
import javax.inject.Inject

class StatRepository @Inject constructor(
    private val bscClient: BscClient
) {

    suspend fun getValidators(key: String) = SafeCall.execute {
        bscClient.getValidators(key = key).body()?.result
    }

}