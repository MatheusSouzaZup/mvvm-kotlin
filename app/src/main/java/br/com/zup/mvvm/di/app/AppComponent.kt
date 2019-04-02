package br.com.zup.mvvm.di.app

import android.app.Application
import br.com.zup.mvvm.AppApplication
import br.com.zup.mvvm.di.builders.ActivityBuilder
import br.com.zup.mvvm.di.builders.ViewModelBuilder
import br.com.zup.mvvm.di.builders.FragmentBuilder
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidSupportInjectionModule::class,
        RoomModule::class,
        ViewModelBuilder::class,
        ActivityBuilder::class,
        FragmentBuilder::class
    ]
)
interface AppComponent {

    fun inject(application: AppApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}