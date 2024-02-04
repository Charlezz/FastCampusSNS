package kr.co.fastcampus.data.usecase.main.board

import kr.co.fastcampus.data.retrofit.BoardService
import kr.co.fastcampus.domain.usecase.main.board.DeleteBoardUseCase
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
class DeleteBoardUseCaseImpl @Inject constructor(
    private val boardService: BoardService
) : DeleteBoardUseCase {
    override suspend fun invoke(boardId: Long): Result<Long> = kotlin.runCatching {
        boardService.deleteBoard(boardId).data
    }
}