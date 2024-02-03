package kr.co.fastcampus.domain.model

import kotlinx.serialization.Serializable

/**
 * @author soohwan.ok
 */

@Serializable
data class Image(
    val uri:String,
    val name:String,
    val size:Long,
    val mimeType:String,
)