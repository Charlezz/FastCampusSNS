package kr.co.fastcampus.domain.usecase.login

/**
 * @author soohwan.ok
 */
interface LoginUseCase {

    suspend operator fun invoke(
        id:String,
        password:String
    ):Result<String>
}