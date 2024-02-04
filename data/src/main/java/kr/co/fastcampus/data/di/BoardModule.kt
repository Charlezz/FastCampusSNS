package kr.co.fastcampus.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import kr.co.fastcampus.data.usecase.main.board.DeleteBoardUseCaseImpl
import kr.co.fastcampus.data.usecase.main.board.DeleteCommentUseCaseImpl
import kr.co.fastcampus.data.usecase.main.board.GetBoardsUseCaseImpl
import kr.co.fastcampus.data.usecase.main.board.PostCommentUseCaseImpl
import kr.co.fastcampus.domain.usecase.main.board.DeleteBoardUseCase
import kr.co.fastcampus.domain.usecase.main.board.DeleteCommentUseCase
import kr.co.fastcampus.domain.usecase.main.board.GetBoardsUseCase
import kr.co.fastcampus.domain.usecase.main.board.PostCommentUseCase

/**
 * @author soohwan.ok
 */
@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class BoardModule {

    @Binds
    abstract fun bindGetBoardsUseCase(uc: GetBoardsUseCaseImpl): GetBoardsUseCase

    @Binds
    abstract fun bindDeleteBoardUseCase(uc: DeleteBoardUseCaseImpl): DeleteBoardUseCase

    @Binds
    abstract fun bindPostCommentUseCase(uc: PostCommentUseCaseImpl): PostCommentUseCase

    @Binds
    abstract fun bindDeleteCommentUseCase(uc: DeleteCommentUseCaseImpl): DeleteCommentUseCase
}