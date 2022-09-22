package jetpack.mvvm.viewmodel

import androidx.lifecycle.*
import jetpack.mvvm.base.BaseViewModel
import jetpack.mvvm.model.HotkeyModel
import jetpack.mvvm.repository.HomeRepository
import java.lang.StringBuilder

/**
 * Description：HomeViewModel
 */
class HomeViewModel : BaseViewModel() {
    private val repository by lazy { HomeRepository() }

    private val hotkeyList = MutableLiveData<List<HotkeyModel>>()

    private var _hotkeyText: LiveData<String> = hotkeyList.distinctUntilChanged().map { createHotkeyText(it) }
    val hotkeyText: LiveData<String> = _hotkeyText

    fun hotkeys() {
        launch({
            hotkeyList.value = repository.hotkeys()
            repository.banners()
        })
    }

    private fun createHotkeyText(list: List<HotkeyModel>): String {
        val text = StringBuilder()
        for (key in list) {
            text.append("${key.name}\n")
        }
        return text.toString()
    }

}

