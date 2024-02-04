package kr.co.fastcampus.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 * @author soohwan.ok
 */
@Serializable
data class ContentParam(
    val text:String,
    val images:List<String>
){
    fun toJson():String{
        return Json.encodeToString(this)
    }
}