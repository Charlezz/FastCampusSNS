package kr.co.fastcampus.data.usecase

import kr.co.fastcampus.data.model.SignUpParam
import kr.co.fastcampus.data.retrofit.UserService
import kr.co.fastcampus.domain.usecase.login.SignUpUseCase
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
class SignUpUseCaseImpl @Inject constructor(
    private val userService: UserService
) : SignUpUseCase {
    override suspend fun invoke(id: String, username: String, password: String): Result<Boolean> = kotlin.runCatching {
        val requestBody = SignUpParam(
            loginId = id,
            name = username,
            password = password,
            extraUserInfo = "",
            profileFilePath = ""
        ).toRequestBody()
        userService.signUp(requestBody = requestBody).result == "SUCCESS"
    }
}