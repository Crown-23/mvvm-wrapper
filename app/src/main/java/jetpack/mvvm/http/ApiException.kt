package jetpack.mvvm.http

/**
 * Description：ApiException
 */
class ApiException(val code: Int, val msg: String) : Exception()