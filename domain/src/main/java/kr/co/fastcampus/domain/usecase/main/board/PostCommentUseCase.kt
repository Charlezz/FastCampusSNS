package kr.co.fastcampus.domain.usecase.main.board

/**
 * @author soohwan.ok
 */
interface PostCommentUseCase {

    suspend operator fun invoke(
        boardId: Long,
        text: String
    ): Result<Long>
}