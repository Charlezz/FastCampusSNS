package kr.co.fastcampus.data.model

import kotlinx.serialization.Serializable

/**
 * @author soohwan.ok
 */
@Serializable
data class CommonResponse<T>(
    val result: String,
    val data: T,
    val errorCode: String,
    val errorMessage: String,
)