package kr.co.fastcampus.data.usecase.main.writing

import android.content.Context
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kr.co.fastcampus.data.model.BoardParcel
import kr.co.fastcampus.domain.model.Image
import kr.co.fastcampus.domain.usecase.main.writing.PostBoardUseCase
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
class HiltWorkerPostBoardUseCase @Inject constructor(
    private val context:Context
) : PostBoardUseCase {
    override suspend fun invoke(title: String, content: String, images: List<Image>) {
        val boardParcel = BoardParcel(
            title = title,
            content = content,
            images = images
        )

        val boardParcelJson = Json.encodeToString(boardParcel)

        val workRequest = OneTimeWorkRequestBuilder<BoardWorker>()
            .setInputData(
                workDataOf(
                    BoardParcel::class.java.simpleName to boardParcelJson
                )
            )
            .build()

        WorkManager.getInstance(context).enqueue(workRequest)
    }
}

