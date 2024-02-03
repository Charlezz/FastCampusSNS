package kr.co.fastcampus.data.usecase

import kr.co.fastcampus.data.UserDataStore
import kr.co.fastcampus.domain.usecase.login.GetTokenUseCase
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
class GetTokenUseCaseImpl @Inject constructor(
    private val userDataStore: UserDataStore
) : GetTokenUseCase {
    override suspend fun invoke(): String? {
        return userDataStore.getToken()
    }
}