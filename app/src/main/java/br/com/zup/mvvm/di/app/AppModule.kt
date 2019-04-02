package br.com.zup.mvvm.di.app

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import br.com.zup.mvvm.AppApplication
import br.com.zup.mvvm.BuildConfig
import br.com.zup.mvvm.room.AppDatabase
import br.com.zup.mvvm.service.APIClient
import br.com.zup.mvvm.service.AppAPI
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

    @Provides
    @Singleton
    fun provideApiClient(url: String): APIClient {
        return APIClient(url)
    }


    @Provides
    @Singleton
    fun privedeApi(apiClient: APIClient): AppAPI {
        return apiClient.retrofit.create(AppAPI::class.java)
    }

    @Provides
    @Singleton
    fun providesSharedPreferences(application: Application): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }

    @Provides
    @Singleton
    fun providesAppApplication(application: Application): AppApplication {
        return application as AppApplication
    }

    @Provides
    @Singleton
    internal fun providesRoomDb(app: Application): AppDatabase {
        return (app as AppApplication).getAppDb()
    }

}
