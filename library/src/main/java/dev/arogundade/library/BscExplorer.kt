package dev.arogundade.library

import android.content.Context
import dagger.hilt.android.EntryPointAccessors
import dev.arogundade.library.data.models.account.Balance
import dev.arogundade.library.data.models.account.InternalTransaction
import dev.arogundade.library.data.models.account.Transaction
import dev.arogundade.library.data.models.stat.Validator
import dev.arogundade.library.data.repository.AccountRepository
import dev.arogundade.library.data.repository.StatRepository
import dev.arogundade.library.data.repository.TransactionRepository
import dev.arogundade.library.exception.ApiKeyException
import dev.arogundade.library.exception.PerPageException
import dev.arogundade.library.utils.Sort
import dev.arogundade.library.utils.Status

class BscExplorer private constructor(builder: Builder, context: Context) {
    private var key: String
    private var perPage: Int
    private var startBlock: Int
    private var endBlock: Int
    private var sort: Sort

    init {
        key = builder.key
        perPage = builder.perPage
        startBlock = builder.startBlock
        endBlock = builder.endBlock
        sort = builder.sort
    }

    /*
    * switch between ascending and descending
    * */
    fun updateSorting(sort: Sort) {
        this.sort = sort
    }

    /*
    * explorer builder
    * */
    class Builder() {
        var key: String = ""
        var perPage = 10
        var startBlock = 0
        var endBlock = 99999999
        var sort: Sort = Sort.Descending

        fun setApiKey(key: String): Builder {
            this.key = key
            return this
        }

        fun setStartBlock(startBlock: Int): Builder {
            this.startBlock = startBlock
            return this
        }

        fun setEndBlock(endBlock: Int): Builder {
            this.endBlock = endBlock
            return this
        }

        fun setSorting(sort: Sort): Builder {
            this.sort = sort
            return this
        }

        fun setDefaultPerPage(perPage: Int): Builder {
            if (perPage !in 1..10000) throw PerPageException()
            this.perPage = perPage
            return this
        }

        fun build(context: Context): BscExplorer {
            if (key.isEmpty()) throw ApiKeyException()
            return BscExplorer(this, context)
        }
    }

    /*
    * for field injecting repositories
    * */
    private val hiltEntryPoint =
        EntryPointAccessors.fromApplication(context, BscExplorerProvider::class.java)

    /*
    * account module related functions
    * https://docs.bscscan.com/api-endpoints/accounts
    * */
    private fun accountRepository(): AccountRepository {
        return hiltEntryPoint.accountRepository()
    }

    /*
    * transaction module related functions
    * https://docs.bscscan.com/api-endpoints/stats
    * */
    private fun transactionRepository(): TransactionRepository {
        return hiltEntryPoint.transactionRepository()
    }

    /*
    * stat module related functions
    * https://docs.bscscan.com/api-endpoints/stats
    * */
    private fun statRepository(): StatRepository {
        return hiltEntryPoint.statRepository()
    }

    /*
    * get BNB balance for single BEP20 address
    * https://docs.bscscan.com/api-endpoints/accounts#get-bnb-balance-for-a-single-address
    * */
    suspend fun getBnbBalance(address: String): Status<Long?> {
        return accountRepository().getBnbBalance(address, key)
    }

    /*
    * get BNB balance for multiple BEP20 address
    * https://docs.bscscan.com/api-endpoints/accounts#get-bnb-balance-for-multiple-addresses-in-a-single-call
    * */
    suspend fun getBnbBalance(address: List<String>): Status<List<Balance>?> {
        return accountRepository().getBnbBalance(address, key)
    }

    /*
    * get list of normal transactions performed by a BEP20 address
    * https://docs.bscscan.com/api-endpoints/accounts#get-a-list-of-normal-transactions-by-address
    * */
    suspend fun getTransactions(
        address: String,
        page: Int
    ): Status<List<Transaction>?> {
        return accountRepository().getTransactions(
            address = address,
            key = key,
            perPage = perPage,
            startBlock = startBlock,
            endBlock = endBlock,
            sort = sort,
            page = page
        )
    }

    /*
    * get list of internal transactions performed by a BEP20 address
    * https://docs.bscscan.com/api-endpoints/accounts#get-a-list-of-internal-transactions-by-address
    * */
    suspend fun getInternalTransactions(
        address: String,
        page: Int
    ): Status<List<InternalTransaction>?> {
        return accountRepository().getInternalTransactions(
            address = address,
            key = key,
            perPage = perPage,
            startBlock = startBlock,
            endBlock = endBlock,
            sort = sort,
            page = page
        )
    }

    /*
    * check status of a transaction execution
    * https://docs.bscscan.com/api-endpoints/stats
    * */
    suspend fun checkTransaction(txHash: String): Status<Boolean> {
        return transactionRepository().checkTransaction(txHash, key)
    }

    /*
    * check status of a transaction execution
    * https://docs.bscscan.com/api-endpoints/stats-1#get-validators-list-on-the-bnb-smart-chain
    * */
    suspend fun getValidators(): Status<List<Validator>?> {
        return statRepository().getValidators(key)
    }

}