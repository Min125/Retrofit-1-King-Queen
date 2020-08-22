package coder.mtk.retrofit1.api

import coder.mtk.retrofit1.model.BoyItem
import coder.mtk.retrofit1.model.GirlItem
import retrofit2.Call
import retrofit2.http.GET

interface GirlApiInterface {
    @GET("queen")
    fun getGirl(): Call<ArrayList<GirlItem>>
}