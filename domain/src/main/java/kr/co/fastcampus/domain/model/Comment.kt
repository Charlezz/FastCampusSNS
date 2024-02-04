package kr.co.fastcampus.domain.model

/**
 * @author soohwan.ok
 */
data class Comment(
    val id: Long,
    val text: String,
    val username: String,
    val profileImageUrl: String? = null
)