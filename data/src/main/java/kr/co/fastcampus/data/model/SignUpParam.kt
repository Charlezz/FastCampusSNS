package kr.co.fastcampus.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

/**
 * @author soohwan.ok
 */
@Serializable
data class SignUpParam(
    val loginId:String,
    val name:String,
    val password:String,
    val extraUserInfo:String,
    val profileFilePath:String
){

    fun toRequestBody():RequestBody{
        return Json.encodeToString(this).toRequestBody()
    }
}