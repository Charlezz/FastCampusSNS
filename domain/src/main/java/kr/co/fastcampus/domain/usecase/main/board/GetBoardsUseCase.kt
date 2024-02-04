package kr.co.fastcampus.domain.usecase.main.board

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.co.fastcampus.domain.model.Board

/**
 * @author soohwan.ok
 */
interface GetBoardsUseCase {

    suspend operator fun invoke():Result<Flow<PagingData<Board>>>
}