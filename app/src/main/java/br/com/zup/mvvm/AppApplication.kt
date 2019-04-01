package br.com.zup.mvvm

import android.app.Activity
import android.app.Application
import android.arch.persistence.room.Room
import br.com.zup.mvvm.di.app.DaggerAppComponent
import br.com.zup.mvvm.room.AppDatabase
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class AppApplication : Application(), HasActivityInjector {

    private var mAppDb: AppDatabase? = null

    companion object {
        @get:Synchronized
        lateinit var instance: AppApplication
    }

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector

    override fun onCreate() {
        super.onCreate()
        instance = this


        initInjector()
        initRoom()
    }

    private fun initRoom() {
        mAppDb = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "myapp-db")
            .fallbackToDestructiveMigration()
            .build()
    }

    private fun initInjector() {
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

    fun getAppDb(): AppDatabase {
        return mAppDb!!
    }

}