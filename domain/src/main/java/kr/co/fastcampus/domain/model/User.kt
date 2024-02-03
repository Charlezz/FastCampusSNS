package kr.co.fastcampus.domain.model

/**
 * @author soohwan.ok
 */
data class User(
    val id:Long,
    val loginId:String,
    val username:String,
    val profileImageUrl:String? = null,
)