package kr.co.fastcampus.data.model

import kotlinx.serialization.Serializable
import kr.co.fastcampus.domain.model.User

/**
 * @author soohwan.ok
 */
@Serializable
data class UserDTO(
    val id: Long,
    val loginId: String,
    val userName: String,
    val extraUserInfo: String,
    val profileFilePath: String,
)

fun UserDTO.toDomainModel(): User {
    return User(
        id = this.id,
        loginId = this.loginId,
        username = this.userName,
        profileImageUrl = this.profileFilePath
    )
}
