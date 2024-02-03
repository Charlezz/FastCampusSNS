package kr.co.fastcampus.domain.usecase.file

import kr.co.fastcampus.domain.model.Image

/**
 * @author soohwan.ok
 */
interface GetImageUseCase {

    operator fun invoke(contentUri: String): Image?
}