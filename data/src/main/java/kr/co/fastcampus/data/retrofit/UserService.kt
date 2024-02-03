package kr.co.fastcampus.data.retrofit

import kr.co.fastcampus.data.model.CommonResponse
import kr.co.fastcampus.data.model.UserDTO
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

/**
 * @author soohwan.ok
 */
interface UserService {

    @POST("users/login")
    suspend fun login(
        @Body requestBody: RequestBody
    ):CommonResponse<String>

    @POST("users/sign-up")
    suspend fun signUp(
        @Body requestBody: RequestBody
    ):CommonResponse<Long>

    @GET("users/my-page")
    suspend fun getMyPage():CommonResponse<UserDTO>

    @PATCH("users/my-page")
    suspend fun patchMyPage(
        @Body requestBody:RequestBody
    ):CommonResponse<Long>

}