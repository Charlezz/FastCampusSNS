package kr.co.fastcampus.domain.usecase.login

/**
 * @author soohwan.ok
 */
interface GetTokenUseCase {
    suspend operator fun invoke(): String?
}