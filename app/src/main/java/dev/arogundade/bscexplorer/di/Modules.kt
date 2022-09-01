package dev.arogundade.bscexplorer.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.arogundade.bscexplorer.Constants.BSC_API_KEY
import dev.arogundade.library.BscExplorer
import dev.arogundade.library.utils.Sort
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Modules {

    @Provides
    @Singleton
    fun bscExplorer(@ApplicationContext context: Context): BscExplorer {
        return BscExplorer.Builder()
            .setApiKey(BSC_API_KEY)
            .setDefaultPerPage(30)
            .setSorting(Sort.Descending)
            .build(context)
    }

}