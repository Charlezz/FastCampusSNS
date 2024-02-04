package kr.co.fastcampus.presentation.model.main.board

import androidx.compose.runtime.Immutable
import kr.co.fastcampus.domain.model.Board
import kr.co.fastcampus.domain.model.Comment

/**
 * @author soohwan.ok
 */
@Immutable
data class BoardCardModel(
    val boardId: Long,
    val username: String,
    val images: List<String>,
    val text: String,
    val comments:List<Comment>
)

fun Board.toUiModel(): BoardCardModel {
    return BoardCardModel(
        boardId = this.id,
        username = this.username,
        images = this.images,
        text = this.content,
        comments = this.comments
    )
}