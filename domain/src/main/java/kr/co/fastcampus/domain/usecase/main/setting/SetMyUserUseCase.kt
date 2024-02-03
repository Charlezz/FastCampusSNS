package kr.co.fastcampus.domain.usecase.main.setting

/**
 * @author soohwan.ok
 */
interface SetMyUserUseCase {

    suspend operator fun invoke(
        username: String? = null,
        profileImageUrl:String? = null
    ): Result<Unit>
}