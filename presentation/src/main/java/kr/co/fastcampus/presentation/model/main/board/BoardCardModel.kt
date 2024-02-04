package kr.co.fastcampus.presentation.model.main.board

import androidx.compose.runtime.Immutable
import com.mohamedrejeb.richeditor.model.RichTextState
import kr.co.fastcampus.domain.model.Board
import kr.co.fastcampus.domain.model.Comment

/**
 * @author soohwan.ok
 */
@Immutable
data class BoardCardModel(
    val userId:Long,
    val boardId: Long,
    val username: String,
    val profileImageUrl:String?,
    val images: List<String>,
    val richTextState: RichTextState,
    val comments:List<Comment>
)

fun Board.toUiModel(): BoardCardModel {
    return BoardCardModel(
        userId = this.userId,
        boardId = this.id,
        username = this.username,
        profileImageUrl = this.profileImageUrl,
        images = this.images,
        richTextState = RichTextState().apply { setHtml(this@toUiModel.content) },
        comments = this.comments
    )
}