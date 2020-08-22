package coder.mtk.retrofit1.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BoyApiClient {
    private  val BASE_URL =  "https://ucsmonywaonlinevote.000webhostapp.com/api/"
    private var retrofir : Retrofit? = null

    init {
        if (retrofir == null){
            retrofir = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
    val postApiService = retrofir!!.create(BoyApiInterface::class.java)
}