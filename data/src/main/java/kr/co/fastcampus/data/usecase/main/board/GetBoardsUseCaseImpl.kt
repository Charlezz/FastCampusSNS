package kr.co.fastcampus.data.usecase.main.board

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kr.co.fastcampus.data.database.BoardDatabase
import kr.co.fastcampus.data.database.BoardRemoteMediator
import kr.co.fastcampus.data.model.toDomainModel
import kr.co.fastcampus.domain.model.Board
import kr.co.fastcampus.domain.usecase.main.board.GetBoardsUseCase
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
class GetBoardsUseCaseImpl @Inject constructor(
    private val boardDatabase: BoardDatabase,
    private val mediator: BoardRemoteMediator,
) : GetBoardsUseCase {

    @OptIn(ExperimentalPagingApi::class)
    override suspend fun invoke(): Result<Flow<PagingData<Board>>> = kotlin.runCatching {
        Pager(
            config = PagingConfig(
                pageSize = 10,
                initialLoadSize = 10
            ),
            remoteMediator = mediator,
            pagingSourceFactory = {
                boardDatabase.boardDao().getAll()
            },
        ).flow.map { pagingData ->
            pagingData.map { it.toDomainModel() }
        }
    }
}