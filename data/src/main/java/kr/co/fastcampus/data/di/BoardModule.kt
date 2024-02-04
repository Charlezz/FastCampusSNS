package kr.co.fastcampus.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import kr.co.fastcampus.data.usecase.main.board.DeleteBoardUseCaseImpl
import kr.co.fastcampus.data.usecase.main.board.GetBoardsUseCaseImpl
import kr.co.fastcampus.domain.usecase.main.board.DeleteBoardUseCase
import kr.co.fastcampus.domain.usecase.main.board.GetBoardsUseCase

/**
 * @author soohwan.ok
 */
@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class BoardModule {

    @Binds
    abstract fun bindGetBoardsUseCase(uc:GetBoardsUseCaseImpl):GetBoardsUseCase

    @Binds
    abstract fun bindDeleteBoardUseCase(uc: DeleteBoardUseCaseImpl):DeleteBoardUseCase
}