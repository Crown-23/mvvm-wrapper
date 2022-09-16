package jetpack.mvvm.repository

import jetpack.mvvm.base.BaseData
import jetpack.mvvm.base.BaseRepository
import jetpack.mvvm.http.api.HomeService
import jetpack.mvvm.model.HotkeyModel

/**
 * Description：HomeRepository
 */
class HomeRepository : BaseRepository() {
    suspend fun hotkeys(): BaseData<List<HotkeyModel>> {
        return apiService(HomeService::class.java).hotkeys()
    }
}