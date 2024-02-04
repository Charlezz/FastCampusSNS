package kr.co.fastcampus.data.retrofit

import kr.co.fastcampus.data.model.CommonResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @author soohwan.ok
 */
interface BoardService {

    @POST("boards")
    suspend fun postBoard(
        @Body requestBody: RequestBody
    ):CommonResponse<Long>
}