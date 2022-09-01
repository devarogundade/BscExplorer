package dev.arogundade.library.data.repository

import dev.arogundade.library.remote.BscClient
import dev.arogundade.library.remote.SafeCall.execute
import dev.arogundade.library.utils.Status
import javax.inject.Inject

class TransactionRepository @Inject
constructor(private val bscClient: BscClient) {

    suspend fun checkTransaction(txHash: String, key: String) = execute {
        bscClient.checkTransaction(txHash = txHash, key = key).body()?.result?.status == "1"
    }

}