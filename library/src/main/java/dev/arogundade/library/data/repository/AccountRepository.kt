package dev.arogundade.library.data.repository

import dev.arogundade.library.remote.SafeCall.execute
import dev.arogundade.library.remote.clients.AccountClient
import dev.arogundade.library.utils.Sort
import javax.inject.Inject

class AccountRepository @Inject
constructor(private val accountClient: AccountClient) {

    suspend fun getBnbBalance(address: String, key: String) = execute {
        accountClient.getBnbBalance(address = address, key = key).body()?.result
    }

    suspend fun getBnbBalance(address: List<String>, key: String) = execute {
        accountClient.getBnbBalance(address = address, key = key).body()?.result
    }

    suspend fun getTransactions(
        address: String,
        key: String,
        perPage: Int,
        startBlock: Int,
        endBlock: Int,
        sort: Sort,
        page: Int
    ) = execute {
        accountClient.getTransactions(
            address = address,
            key = key,
            perPage = perPage,
            startBlock = startBlock,
            endBlock = endBlock,
            sort = sort.direction,
            page = page
        ).body()?.result
    }

    suspend fun getInternalTransactions(
        address: String,
        key: String,
        perPage: Int,
        startBlock: Int,
        endBlock: Int,
        sort: Sort,
        page: Int
    ) = execute {
        accountClient.getInternalTransactions(
            address = address,
            key = key,
            perPage = perPage,
            startBlock = startBlock,
            endBlock = endBlock,
            sort = sort.direction,
            page = page
        ).body()?.result
    }

}