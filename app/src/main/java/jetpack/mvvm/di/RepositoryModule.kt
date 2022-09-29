package jetpack.mvvm.di

import jetpack.mvvm.repository.HomeRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/**
 * Description：
 */
val repositoryModule = module {
    singleOf(::HomeRepository)
}