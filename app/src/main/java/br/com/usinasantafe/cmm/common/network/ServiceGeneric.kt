package br.com.usinasantafe.cmm.common.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ServiceGeneric {

    @GET("{classe}.php")
    fun getGeneric(@Path("classe") classe : String): Call<ResponseBody>

    @FormUrlEncoded
    @POST("{objeto}.php")
    fun postGeneric(@Path("objeto") objeto : String, @Field("dado") dado: String): Call<ResponseBody>
}