package kr.co.fastcampus.domain.usecase.main.writing

import kr.co.fastcampus.domain.model.Image

/**
 * @author soohwan.ok
 */
interface PostBoardUseCase {

    suspend operator fun invoke(
        title: String,
        content: String,
        images: List<Image>
    )
}