package jetpack.mvvm.di

import jetpack.mvvm.http.api.HomeService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Description：
 */
val networkModule = module {
    // Long live components can be easily described as [single] definitions.
    // For medium and short live components we can have several approaches:[factory],[scope]
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://www.wanandroid.com")
            .build()
    }

    single {
        get<Retrofit>().create(HomeService::class.java)
    }

}