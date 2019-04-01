package br.com.zup.mvvm.di.app

import br.com.zup.mvvm.room.AppDatabase
import br.com.zup.mvvm.room.example.ExampleDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    internal fun providesRecentLocationSearchDao(appDb: AppDatabase): ExampleDao {
        return appDb.exampleDao()
    }
}