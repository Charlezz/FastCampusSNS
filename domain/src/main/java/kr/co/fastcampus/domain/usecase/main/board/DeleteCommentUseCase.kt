package kr.co.fastcampus.domain.usecase.main.board

/**
 * @author soohwan.ok
 */
interface DeleteCommentUseCase {

    suspend operator fun invoke(
        boardId:Long,
        commentId:Long
    ):Result<Long>
}