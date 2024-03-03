package kr.co.fastcampus.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import kr.co.fastcampus.data.usecase.main.writing.GetImageListUseCaseImpl
import kr.co.fastcampus.data.usecase.main.writing.HiltWorkerPostBoardUseCase
import kr.co.fastcampus.domain.usecase.main.writing.GetImageListUseCase
import kr.co.fastcampus.domain.usecase.main.writing.PostBoardUseCase

/**
 * @author soohwan.ok
 */
@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class WritingModule {

    @Binds
    abstract fun bindGetImageListUseCase(uc: GetImageListUseCaseImpl): GetImageListUseCase

//    @Binds
//    abstract fun bindPostBoardUseCase(uc: PostBoardUseCaseImpl): PostBoardUseCase

    @Binds
    abstract fun bindPostBoardUseCase(uc: HiltWorkerPostBoardUseCase): PostBoardUseCase
}