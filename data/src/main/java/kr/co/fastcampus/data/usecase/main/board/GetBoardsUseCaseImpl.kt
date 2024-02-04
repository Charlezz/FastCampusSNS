package kr.co.fastcampus.data.usecase.main.board

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.co.fastcampus.domain.model.Board
import kr.co.fastcampus.domain.usecase.main.board.GetBoardsUseCase
import javax.inject.Inject
import javax.inject.Provider

/**
 * @author soohwan.ok
 */
class GetBoardsUseCaseImpl @Inject constructor(
    private val pagingSource: Provider<BoardPagingSource>
) : GetBoardsUseCase {

    override suspend fun invoke(): Result<Flow<PagingData<Board>>> = kotlin.runCatching{
        Pager(
            config = PagingConfig(
                pageSize = 10,
                initialLoadSize = 10
            ),
            pagingSourceFactory = { pagingSource.get() },
        ).flow
    }
}