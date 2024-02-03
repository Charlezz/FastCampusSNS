package kr.co.fastcampus.domain.usecase.login

/**
 * @author soohwan.ok
 */
interface ClearTokenUseCase {

    suspend operator fun invoke():Result<Unit>
}