package kr.co.fastcampus.data.model

import kotlinx.serialization.Serializable

/**
 * @author soohwan.ok
 */
@Serializable
data class FileDTO(
    val id:Long,
    val fileName:String,
    val createdAt:String,
    val filePath:String
)