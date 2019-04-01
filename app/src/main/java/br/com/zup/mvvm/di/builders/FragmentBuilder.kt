package br.com.zup.mvvm.di.builders

import br.com.zup.mvvm.di.Fragment
import br.com.zup.mvvm.view.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBuilder {

    //Main
    @Fragment
    @ContributesAndroidInjector
    abstract fun bindMainFragment(): MainFragment


}