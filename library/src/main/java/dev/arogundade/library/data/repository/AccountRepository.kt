package dev.arogundade.library.data.repository

import dev.arogundade.library.remote.BscClient
import dev.arogundade.library.remote.SafeCall.execute
import dev.arogundade.library.utils.Sort
import javax.inject.Inject

class AccountRepository @Inject
constructor(private val bscClient: BscClient) {

    suspend fun getBnbBalance(address: String, key: String) = execute {
        bscClient.getBnbBalance(address = address, key = key).body()?.result
    }

    suspend fun getBnbBalance(address: List<String>, key: String) = execute {
        bscClient.getBnbBalance(address = address, key = key).body()?.result
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
        bscClient.getTransactions(
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
        bscClient.getInternalTransactions(
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