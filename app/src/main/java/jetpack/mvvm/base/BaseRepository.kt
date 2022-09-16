package jetpack.mvvm.base

import jetpack.mvvm.http.ApiClient

/**
 * Description：BaseRepository
 */
abstract class BaseRepository {
    protected fun <T> apiService(tClass: Class<T>): T {
        return ApiClient.createService(tClass)
    }
}