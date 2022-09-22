package jetpack.mvvm.http.api

import jetpack.mvvm.base.BaseData
import jetpack.mvvm.model.HotkeyModel
import retrofit2.http.GET

/**
 * Description：HomeService
 */
interface HomeService {
    @GET("hotkey/json")
    suspend fun hotkeys(): BaseData<List<HotkeyModel>>

    @GET("banner/json")
    suspend fun banners(): BaseData<List<Any>>
}