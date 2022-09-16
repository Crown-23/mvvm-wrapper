package jetpack.mvvm.base

/**
 * Description：BaseData
 */
data class BaseData<T>(
    val data: T?,
    val errorCode: Int,
    val errorMsg: String
)
