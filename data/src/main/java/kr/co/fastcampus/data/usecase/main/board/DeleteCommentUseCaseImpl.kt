package kr.co.fastcampus.data.usecase.main.board

import kr.co.fastcampus.data.retrofit.BoardService
import kr.co.fastcampus.domain.usecase.main.board.DeleteCommentUseCase
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
class DeleteCommentUseCaseImpl @Inject constructor(
    private val boardService: BoardService
) : DeleteCommentUseCase{
    override suspend fun invoke(boardId: Long, commentId: Long): Result<Long> = kotlin.runCatching{
        boardService.deleteComment(
            boardId = boardId,
            commentId = commentId
        ).data
    }
}