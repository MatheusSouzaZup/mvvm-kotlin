package br.com.zup.zupapp.di.builders

import br.com.drmsolucoes.sunrisealarmclock.di.Activity
import br.com.zup.mvvm.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {

    // Main
    @Activity
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity


}