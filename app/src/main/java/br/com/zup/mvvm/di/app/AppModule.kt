package br.com.zup.mvvm.di.app

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import br.com.zup.mvvm.AppApplication
import br.com.zup.mvvm.BuildConfig
import br.com.zup.mvvm.room.AppDatabase
import br.com.zup.mvvm.service.APIClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(app: Application): Context {
        return app.applicationContext
    }

    @Singleton
    @Provides
    fun provideEntryPointUrl(): String {
        return BuildConfig.HOST
    }

    @Singleton
    @Provides
    fun provideApiClient(url: String): APIClient {
        return APIClient(url)
    }

    @Provides
    @Singleton
    fun providesSharedPreferences(application: Application): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }

    @Provides
    @Singleton
    fun providesSodexoApplication(application: Application): AppApplication {
        return application as AppApplication
    }

    @Provides
    @Singleton
    internal fun providesRoomDb(app: Application): AppDatabase {
        return (app as AppApplication).getAppDb()
    }
}
