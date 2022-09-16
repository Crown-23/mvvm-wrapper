package jetpack.mvvm.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Description：BaseViewModel
 */
abstract class BaseViewModel : ViewModel() {
    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    protected fun <T> launch(
        liveData: MutableLiveData<T>,
        block: suspend () -> BaseData<T>,
        error: suspend (Int) -> Unit = {

        }
    ) {
        viewModelScope.launch {
            _dataLoading.value = true

            try {
                val baseData = block()
                if (baseData.errorCode == 0) {
                    liveData.value = baseData.data
                } else {
                    // TODO: use Toast to show errorMsg
                    error(baseData.errorCode)
                }
            } catch (e: Exception) {
                // TODO: use Toast to show exception message
            } finally {
                _dataLoading.value = false
            }
        }
    }
}