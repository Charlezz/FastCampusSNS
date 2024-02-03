package kr.co.fastcampus.data.usecase

import kr.co.fastcampus.data.model.LoginParam
import kr.co.fastcampus.data.retrofit.UserService
import kr.co.fastcampus.domain.usecase.login.LoginUseCase
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
class LoginUseCaseImpl @Inject constructor(
    private val userService: UserService,
) : LoginUseCase {
    override suspend fun invoke(id: String, password: String): Result<String> = kotlin.runCatching {
        val requestBody = LoginParam(loginId = id, password = password).toRequestBody()
        userService.login(requestBody = requestBody).data
    }
}