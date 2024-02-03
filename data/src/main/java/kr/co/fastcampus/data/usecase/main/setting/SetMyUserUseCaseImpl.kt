package kr.co.fastcampus.data.usecase.main.setting

import kr.co.fastcampus.data.model.UpdateMyInfoParam
import kr.co.fastcampus.data.retrofit.UserService
import kr.co.fastcampus.domain.usecase.main.setting.GetMyUserUseCase
import kr.co.fastcampus.domain.usecase.main.setting.SetMyUserUseCase
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
class SetMyUserUseCaseImpl @Inject constructor(
    private val userService: UserService,
    private val getMyUserUseCase: GetMyUserUseCase
) : SetMyUserUseCase {
    override suspend fun invoke(
        username: String?,
        profileImageUrl:String?
    ): Result<Unit> = kotlin.runCatching{
        val user = getMyUserUseCase().getOrThrow()
        val requestBody = UpdateMyInfoParam(
            userName = username?:user.username,
            profileFilePath = profileImageUrl?:user.profileImageUrl.orEmpty(),
            extraUserInfo = ""
        ).toRequestBody()
        userService.patchMyPage(requestBody)
    }
}