package kr.co.fastcampus.domain.model

/**
 * @author soohwan.ok
 */
data class Board constructor(
    val id:Long,
    val title:String,
    val content:String,
    val images:List<String>,
    val username:String,
    val profileImageUrl:String,
    val comments:List<Comment>
)