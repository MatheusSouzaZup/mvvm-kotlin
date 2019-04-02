package br.com.zup.mvvm.di.app

import br.com.zup.mvvm.service.APIClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ServiceModule {
    @Provides
    @Singleton
    internal fun providesService(client: APIClient): APIClient {
        return client.retrofit.create(APIClient::class.java)
    }
}