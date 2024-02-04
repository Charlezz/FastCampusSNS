package kr.co.fastcampus.domain.model

import java.io.Serializable


/**
 * @author soohwan.ok
 */

@kotlinx.serialization.Serializable
data class Image(
    val uri:String,
    val name:String,
    val size:Long,
    val mimeType:String,
):Serializable