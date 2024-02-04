package kr.co.fastcampus.data.retrofit

import kr.co.fastcampus.data.model.BoardDTO
import kr.co.fastcampus.data.model.CommonResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * @author soohwan.ok
 */
interface BoardService {

    @GET("boards")
    suspend fun getBoards(
        @Query("page") page:Int,
        @Query("size") size:Int,

    ):CommonResponse<List<BoardDTO>>

    @POST("boards")
    suspend fun postBoard(
        @Body requestBody: RequestBody
    ):CommonResponse<Long>
}