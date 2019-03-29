package br.com.zup.zupapp.di.app

import android.app.Application
import android.content.Context
import android.os.Build
import br.com.zup.mvvm.AppApplication
import br.com.zup.mvvm.BuildConfig
import br.com.zup.mvvm.R
import br.com.zup.zupapp.service.APIClient
import br.com.zup.zupapp.service.AppAPI

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

    @Singleton
    @Provides
    fun provideSunriseSunsetAPI(apiClient: APIClient): AppAPI {
        return apiClient.retrofit.create(AppAPI::class.java)
    }

}
