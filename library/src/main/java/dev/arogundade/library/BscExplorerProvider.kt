package dev.arogundade.library

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.arogundade.library.data.repository.AccountRepository
import dev.arogundade.library.data.repository.TransactionRepository
import dev.arogundade.library.data.repository.StatRepository

@EntryPoint
@InstallIn(SingletonComponent::class)
interface BscExplorerProvider {

    fun accountRepository(): AccountRepository
    fun transactionRepository(): TransactionRepository
    fun statRepository(): StatRepository

}