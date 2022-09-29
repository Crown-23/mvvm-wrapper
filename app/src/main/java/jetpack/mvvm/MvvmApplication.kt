package jetpack.mvvm

import android.app.Application
import jetpack.mvvm.di.networkModule
import jetpack.mvvm.di.repositoryModule
import jetpack.mvvm.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Description：Application
 */
class MvvmApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MvvmApplication)
            modules(networkModule)
            modules(repositoryModule)
            modules(viewModelModule)
        }
    }
}