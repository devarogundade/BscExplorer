package dev.arogundade.library

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.arogundade.library.data.repository.AccountRepository
import dev.arogundade.library.data.repository.StatRepository
import dev.arogundade.library.data.repository.TokenRepository
import dev.arogundade.library.data.repository.TransactionRepository

@EntryPoint
@InstallIn(SingletonComponent::class)
interface BscExplorerProvider {

    fun accountRepository(): AccountRepository
    fun transactionRepository(): TransactionRepository
    fun tokenRepository(): TokenRepository
    fun statRepository(): StatRepository

}