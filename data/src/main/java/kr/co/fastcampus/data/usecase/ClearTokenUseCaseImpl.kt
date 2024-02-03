package kr.co.fastcampus.data.usecase

import kr.co.fastcampus.data.UserDataStore
import kr.co.fastcampus.domain.usecase.login.ClearTokenUseCase
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
class ClearTokenUseCaseImpl @Inject constructor(
    private val userDataStore: UserDataStore
) :ClearTokenUseCase{
    override suspend fun invoke() :Result<Unit> = kotlin.runCatching{
        userDataStore.clear()
    }

}