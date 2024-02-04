package kr.co.fastcampus.data.usecase.main.board

import kr.co.fastcampus.data.model.comment.CommentParam
import kr.co.fastcampus.data.retrofit.BoardService
import kr.co.fastcampus.domain.usecase.main.board.PostCommentUseCase
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
class PostCommentUseCaseImpl @Inject constructor(
    private val boardService: BoardService
) : PostCommentUseCase {
    override suspend fun invoke(boardId: Long, text: String): Result<Long> = kotlin.runCatching {
        val requestBody = CommentParam(text).toRequestBody()
        boardService.postComment(
            boardId = boardId,
            requestBody = requestBody
        ).data
    }
}