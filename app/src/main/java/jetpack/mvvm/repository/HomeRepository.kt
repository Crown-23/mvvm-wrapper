package jetpack.mvvm.repository

import jetpack.mvvm.base.BaseRepository
import jetpack.mvvm.http.api.HomeService
import jetpack.mvvm.model.HotkeyModel

/**
 * Description：HomeRepository
 */
class HomeRepository : BaseRepository() {
    suspend fun hotkeys(): List<HotkeyModel> {
        return request {
            apiService(HomeService::class.java).hotkeys()
        }
    }

    suspend fun banners(): List<Any> {
        return request {
            apiService(HomeService::class.java).banners()
        }
    }
}