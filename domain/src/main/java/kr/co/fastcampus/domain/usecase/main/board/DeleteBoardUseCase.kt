package kr.co.fastcampus.domain.usecase.main.board

/**
 * @author soohwan.ok
 */
interface DeleteBoardUseCase {

    suspend operator fun invoke(
        boardId:Long
    ):Result<Long>
}