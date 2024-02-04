package kr.co.fastcampus.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kr.co.fastcampus.data.model.comment.CommentDTO
import kr.co.fastcampus.data.model.comment.toDomainModel
import kr.co.fastcampus.domain.model.Board

/**
 * @author soohwan.ok
 */
@Serializable
data class BoardDTO(
    val id:Long,
    val title:String,
    val content:String,
    val createdAt:String,
    val updatedAt:String,
    val createUserId:Long,
    val createUserName:String,
    val createUserProfileFilePath:String,
    val commentList:List<CommentDTO>
)

fun BoardDTO.toDomainModel(): Board{
    val contentParam = Json.decodeFromString<ContentParam>(content)
    return Board(
        id = this.id,
        title = this.title,
        content = contentParam.text,
        images = contentParam.images,
        username = this.createUserName,
        profileImageUrl = this.createUserProfileFilePath,
        comments = this.commentList.map { it.toDomainModel() }
    )
}