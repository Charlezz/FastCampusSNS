package kr.co.fastcampus.domain.usecase.main.setting

/**
 * @author soohwan.ok
 */
interface SetProfileImageUseCase {
    suspend operator fun invoke(contentUri:String):Result<Unit>
}