package kr.co.fastcampus.domain.usecase.file

import kr.co.fastcampus.domain.model.Image

/**
 * @author soohwan.ok
 */
interface UploadImageUseCase {
    suspend operator fun invoke(
        image: Image
    ): Result<String>
}