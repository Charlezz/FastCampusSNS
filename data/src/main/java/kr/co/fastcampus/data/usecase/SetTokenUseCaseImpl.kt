package kr.co.fastcampus.data.usecase

import kr.co.fastcampus.data.UserDataStore
import kr.co.fastcampus.domain.usecase.login.SetTokenUseCase
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
class SetTokenUseCaseImpl @Inject constructor(
    private val userDataStore: UserDataStore
) :SetTokenUseCase{
    override suspend fun invoke(token: String) {
        userDataStore.setToken(token)
    }

}