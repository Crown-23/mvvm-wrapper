package jetpack.mvvm.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jetpack.mvvm.http.ApiException
import kotlinx.coroutines.launch
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Description：BaseViewModel
 */
abstract class BaseViewModel : ViewModel() {
    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    protected fun launch(
        block: suspend () -> Unit,
        error: suspend (Int) -> Unit = {

        }
    ) {
        viewModelScope.launch {
            _dataLoading.value = true

            try {
                block.invoke()
            } catch (e: Exception) {
                when (e) {
                    is ApiException -> {
                        // TODO: use Toast to show errorMsg
                        error(e.code)
                    }
                    is ConnectException, is UnknownHostException, is SocketTimeoutException -> {
                        // TODO: use Toast to show exception message
                        Log.e("Exception", e.localizedMessage)
                    }
                }
            } finally {
                _dataLoading.value = false
            }
        }
    }
}