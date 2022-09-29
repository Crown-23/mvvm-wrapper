package jetpack.mvvm.base

import jetpack.mvvm.http.ApiException

/**
 * Description：BaseRepository
 */
abstract class BaseRepository {
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