package coder.mtk.retrofit1.api

import coder.mtk.retrofit1.model.BoyItem
import retrofit2.Call
import retrofit2.http.GET

interface BoyApiInterface {
    @GET ("king")
    fun getBoy():Call <ArrayList<BoyItem>>
}