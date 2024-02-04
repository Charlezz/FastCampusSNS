package kr.co.fastcampus.data.model.comment

import kotlinx.serialization.Serializable
import kr.co.fastcampus.domain.model.Comment

/**
 * @author soohwan.ok
 */
@Serializable
data class CommentDTO(
    val id: Long,
    val comment: String,
    val createdAt: String,
    val createUserId: Long,
    val createUserName: String,
    val profileImageUrl: String,
)

fun CommentDTO.toDomainModel(): Comment {
    return Comment(
        id = id,
        text = comment,
        username = createUserName,
        profileImageUrl = profileImageUrl
    )
}