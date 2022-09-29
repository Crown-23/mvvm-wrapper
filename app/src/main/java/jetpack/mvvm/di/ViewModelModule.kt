package jetpack.mvvm.di

import jetpack.mvvm.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

/**
 * Description：
 */
val viewModelModule = module {
    viewModelOf(::HomeViewModel)
}