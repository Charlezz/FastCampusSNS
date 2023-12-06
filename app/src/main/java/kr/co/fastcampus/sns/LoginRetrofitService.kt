package kr.co.fastcampus.sns

import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * @author soohwan.ok
 */
interface LoginRetrofitService {

    @Headers("Content-Type:application/json;charset=UTF-8")
    @POST("users/login")
    suspend fun login(
        @Body requestBody:RequestBody
    ): NetworkResponse<String>
}