package kr.co.fastcampus.data.usecase.main.setting

import kr.co.fastcampus.data.model.toDomainModel
import kr.co.fastcampus.data.retrofit.UserService
import kr.co.fastcampus.domain.model.User
import kr.co.fastcampus.domain.usecase.main.setting.GetMyUserUseCase
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
class GetMyUserUseCaseImpl @Inject constructor(
    private val userService: UserService
) : GetMyUserUseCase {
    override suspend fun invoke(): Result<User> = kotlin.runCatching {
        userService.getMyPage().data.toDomainModel()
    }
}