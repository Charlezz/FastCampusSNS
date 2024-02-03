package kr.co.fastcampus.domain.usecase.login

/**
 * @author soohwan.ok
 */
interface SetTokenUseCase {
    suspend operator fun invoke(token: String)
}