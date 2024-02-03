package kr.co.fastcampus.domain.usecase.login

/**
 * @author soohwan.ok
 */
interface SignUpUseCase {

    suspend operator fun invoke(
        id:String,
        username:String,
        password:String
    ):Result<Boolean>
}