package kr.co.fastcampus.data.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.content.pm.ServiceInfo
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.co.fastcampus.data.model.BoardParam
import kr.co.fastcampus.data.model.BoardParcel
import kr.co.fastcampus.data.model.ContentParam
import kr.co.fastcampus.data.retrofit.BoardService
import kr.co.fastcampus.domain.model.ACTION_POSTED
import kr.co.fastcampus.domain.usecase.file.UploadImageUseCase
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
@AndroidEntryPoint
class PostingService : LifecycleService() {

    @Inject
    lateinit var uploadImageUseCase:UploadImageUseCase

    @Inject
    lateinit var boardService: BoardService

    companion object {
        const val EXTRA_BOARD = "extra_board"
        const val CHANNEL_ID = "게시글 업로드"
        const val CHANNEL_NAME = "게시글 업로드 채널"
        const val FOREGROUND_NOTIFICATION_ID = 1000
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        createNotificationChannel()
        startForeground()
        intent?.run {
            if (hasExtra(EXTRA_BOARD)) {
                val boardParcel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    getParcelableExtra(EXTRA_BOARD, BoardParcel::class.java)
                } else {
                    getParcelableExtra(EXTRA_BOARD)
                }
                boardParcel?.run {
                    lifecycleScope.launch(Dispatchers.IO) {
                        postBoard(this@run)
                    }
                }
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }

    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            CHANNEL_ID,
            CHANNEL_NAME,
            NotificationManager.IMPORTANCE_DEFAULT
        )
        channel.description = "백그라운드에서 글을 업로드 합니다"

        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)
    }

    private fun startForeground() {
        val notification = NotificationCompat.Builder(this, CHANNEL_ID).build()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            startForeground(
                FOREGROUND_NOTIFICATION_ID,
                notification,
                ServiceInfo.FOREGROUND_SERVICE_TYPE_SHORT_SERVICE
            )
        } else {
            startForeground(
                FOREGROUND_NOTIFICATION_ID,
                notification,
            )
        }
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
        sendBroadcast(
            Intent(
                ACTION_POSTED
            ).apply {
                setPackage(packageName)
            }
        )
        stopForeground(STOP_FOREGROUND_DETACH)
    }
}