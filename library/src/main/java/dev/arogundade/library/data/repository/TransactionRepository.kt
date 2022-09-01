package dev.arogundade.library.data.repository

import dev.arogundade.library.remote.SafeCall.execute
import dev.arogundade.library.remote.clients.TransactionClient
import javax.inject.Inject

class TransactionRepository @Inject
constructor(private val transactionClient: TransactionClient) {

    suspend fun checkTransaction(txHash: String, key: String) = execute {
        transactionClient.checkTransaction(txHash = txHash, key = key).body()?.result?.status == "1"
    }

}