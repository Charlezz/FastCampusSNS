package kr.co.fastcampus.domain.usecase.main.writing

import kr.co.fastcampus.domain.model.Image

/**
 * @author soohwan.ok
 */
interface GetImageListUseCase {
    suspend operator fun invoke():List<Image>
}