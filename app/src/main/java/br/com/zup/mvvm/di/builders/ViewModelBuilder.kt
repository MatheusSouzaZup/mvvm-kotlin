package br.com.zup.mvvm.di.builders

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.zup.mvvm.di.ViewModelKey
import br.com.zup.mvvm.viewmodel.MainViewModel
import br.com.zup.mvvm.viewmodel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by rafaelneiva on 12/06/18.
 */

@Module
abstract class ViewModelBuilder {

    // Main
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel


    // ViewModel Factory
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

}
