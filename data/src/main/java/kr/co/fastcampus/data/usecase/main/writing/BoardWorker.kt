package kr.co.fastcampus.data.usecase.main.writing

import android.app.Notification
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kr.co.fastcampus.data.model.BoardParam
import kr.co.fastcampus.data.model.BoardParcel
import kr.co.fastcampus.data.model.ContentParam
import kr.co.fastcampus.data.retrofit.BoardService
import kr.co.fastcampus.data.service.PostingService
import kr.co.fastcampus.domain.model.ACTION_POSTED
import kr.co.fastcampus.domain.usecase.file.UploadImageUseCase

@HiltWorker
class BoardWorker @AssistedInject constructor(
    @Assisted private val appContext: Context,
    @Assisted private val params: WorkerParameters,
    private val boardService: BoardService,
    private val uploadImageUseCase: UploadImageUseCase
) : CoroutineWorker(
    appContext.applicationContext, params
) {
    override suspend fun doWork(): Result {
        val boardParcelJson = inputData.getString(BoardParcel::class.java.simpleName)?:return Result.failure()
        val boardParcel = Json.decodeFromString<BoardParcel>(boardParcelJson)
        postBoard(boardParcel)
        return Result.success()
    }

    override suspend fun getForegroundInfo(): ForegroundInfo {
        return ForegroundInfo(
            PostingService.FOREGROUND_NOTIFICATION_ID,
            createNotification()
        )
    }
    
    private fun createNotification(): Notification {
        return NotificationCompat.Builder(appContext, PostingService.CHANNEL_ID).build()
    }
    

    private suspend fun postBoard(boardParcel: BoardParcel) {
        //업로드
        val uploadedImages = boardParcel.images.mapNotNull {image-> uploadImageUseCase(image).getOrNull() }

        val contentParam = ContentParam(
            text = boardParcel.content,
            images = uploadedImages
        )
        val boardParam = BoardParam(boardParcel.title, contentParam.toJson())
        val requestBody = boardParam.toRequestBody()
        boardService.postBoard(requestBody)
        appContext.sendBroadcast(
            Intent(
                ACTION_POSTED
            ).apply {
                setPackage(appContext.packageName)
            }
        )
    }

}