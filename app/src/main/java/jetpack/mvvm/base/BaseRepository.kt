package jetpack.mvvm.base

import jetpack.mvvm.http.ApiClient
import jetpack.mvvm.http.ApiException

/**
 * Description：BaseRepository
 */
abstract class BaseRepository {
    protected fun <T> apiService(tClass: Class<T>): T {
        return ApiClient.createService(tClass)
    }

    @Throws(Exception::class)
    protected suspend fun <T> request(block: suspend () -> BaseData<T>): T {
        val baseData = block()
        if (baseData.errorCode == 0) {
            if (baseData.data == null) {
                throw Exception("baseData.data is null!")
            }
            return baseData.data
        } else {
            throw ApiException(baseData.errorCode, baseData.errorMsg)
        }
    }
}