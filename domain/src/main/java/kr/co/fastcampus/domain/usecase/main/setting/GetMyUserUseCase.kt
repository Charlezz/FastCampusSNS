package kr.co.fastcampus.domain.usecase.main.setting

import kr.co.fastcampus.domain.model.User

/**
 * @author soohwan.ok
 */
interface GetMyUserUseCase {

    suspend operator fun invoke():Result<User>
}