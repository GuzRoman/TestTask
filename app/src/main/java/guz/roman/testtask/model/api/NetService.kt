package guz.roman.testtask.model.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import guz.roman.testtask.model.data.BusinessesModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

const val CLIENT_ID = "6N5Y6fE8whfvrsiEowT1Tg"
const val KEY = "DRFG5OcTZ81g7qNT9NJeL8wrKFBgGcZINq8xDXXA2c7NjuMmx574L_yxUlXygkmo-X4opLE2WfGj1UkH69WF3LAHQBO3g-ecPL4nNqglu-eXKVJFwrNsyUaTgH6qX3Yx"
const val BASE_URL = "https://api.yelp.com/v3/businesses/"

//search?term=delis&latitude=37.786882&longitude=-122.399972"

interface NetService {

    @GET("search")
    suspend fun getClosest(
        @Header( "Authorization") key: String = "Bearer " + KEY,
        @Query("term") term: String = "restaurants",
        @Query("latitude") latitude: String,
        @Query("longitude") longitude: String
    ): BusinessesModel

    companion object {
        operator fun invoke(): NetService {
            val requestInterceptor = Interceptor { chain ->

                val url = chain.request()
                    .url
                    .newBuilder()
                    .build()

                val requirest = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(requirest)

            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(NetService::class.java)
        }
    }
}