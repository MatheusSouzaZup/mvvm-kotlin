package br.com.zup.mvvm.di.builders

import br.com.zup.mvvm.di.Activity
import br.com.zup.mvvm.view.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {

    // Main
    @Activity
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity


}