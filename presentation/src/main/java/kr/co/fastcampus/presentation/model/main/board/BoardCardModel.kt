package kr.co.fastcampus.presentation.model.main.board

/**
 * @author soohwan.ok
 */
data class BoardCardModel(
    val boardId:Long,
    val username:String,
    val images:List<String>,
    val text:String,
)