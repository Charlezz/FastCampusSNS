package kr.co.fastcampus.sns

import kotlinx.serialization.Serializable

/**
 * @author soohwan.ok
 */
@Serializable
data class LoginParam(
    val loginId: String,
    val password: String
)