package kr.co.fastcampus.data.usecase.main.writing

import android.content.Context
import android.content.Intent
import kr.co.fastcampus.data.model.BoardParcel
import kr.co.fastcampus.data.service.PostingService
import kr.co.fastcampus.domain.model.Image
import kr.co.fastcampus.domain.usecase.main.writing.PostBoardUseCase
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
class PostBoardUseCaseImpl @Inject constructor(
    private val context: Context
) : PostBoardUseCase {
    override suspend fun invoke(title: String, content: String, images: List<Image>) {
        val board = BoardParcel(title = title, content = content, images = images)
        context.startForegroundService(
            Intent(
                context,
                PostingService::class.java
            ).apply {
                putExtra(PostingService.EXTRA_BOARD, board)
            }
        )
    }


}