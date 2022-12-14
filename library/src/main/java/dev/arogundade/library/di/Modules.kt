package dev.arogundade.library.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.arogundade.library.remote.clients.AccountClient
import dev.arogundade.library.remote.clients.StatClient
import dev.arogundade.library.remote.clients.TokenClient
import dev.arogundade.library.remote.clients.TransactionClient
import dev.arogundade.library.utils.Keys.BSC_BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object Modules {

    @Provides
    @Singleton
    fun retrofit(): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(60L, TimeUnit.SECONDS)
            .build()

        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BSC_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun accountClient(retrofit: Retrofit): AccountClient {
        return retrofit.create(AccountClient::class.java)
    }

    @Provides
    @Singleton
    fun transactionClient(retrofit: Retrofit): TransactionClient {
        return retrofit.create(TransactionClient::class.java)
    }

    @Provides
    @Singleton
    fun tokenClient(retrofit: Retrofit): TokenClient {
        return retrofit.create(TokenClient::class.java)
    }

    @Provides
    @Singleton
    fun statClient(retrofit: Retrofit): StatClient {
        return retrofit.create(StatClient::class.java)
    }

}