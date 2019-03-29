package br.com.zup.zupapp.di.builders

import br.com.drmsolucoes.sunrisealarmclock.di.Fragment
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