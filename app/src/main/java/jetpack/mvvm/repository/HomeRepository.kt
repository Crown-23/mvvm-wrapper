package jetpack.mvvm.repository

import jetpack.mvvm.base.BaseRepository
import jetpack.mvvm.http.api.HomeService
import jetpack.mvvm.model.HotkeyModel

/**
 * Description：HomeRepository
 */
class HomeRepository constructor(private val homeService: HomeService) : BaseRepository() {
    suspend fun hotkeys(): List<HotkeyModel> {
        return request {
            homeService.hotkeys()
        }
    }

    suspend fun banners(): List<Any> {
        return request {
            homeService.banners()
        }
    }
}