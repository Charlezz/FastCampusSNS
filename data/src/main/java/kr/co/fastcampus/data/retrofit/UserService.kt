package kr.co.fastcampus.data.retrofit

import kr.co.fastcampus.data.model.CommonResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * @author soohwan.ok
 */
interface UserService {

    @POST("users/login")
    @Headers("Content-Type:application/json; charset=UTF8")
    suspend fun login(
        @Body requestBody: RequestBody
    ):CommonResponse<String>
}