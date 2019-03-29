package br.com.zup.zupapp.di.app

import android.app.Application
import br.com.zup.mvvm.AppApplication
import br.com.zup.zupapp.di.builders.ActivityBuilder
import br.com.zup.zupapp.di.builders.ViewModelBuilder
import br.com.zup.zupapp.di.builders.FragmentBuilder
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by rafaelneiva on 12/06/18.
 */
@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidSupportInjectionModule::class,
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