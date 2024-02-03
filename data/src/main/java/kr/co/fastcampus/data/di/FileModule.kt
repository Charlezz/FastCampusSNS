package kr.co.fastcampus.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.fastcampus.data.usecase.file.GetImageUseCaseImpl
import kr.co.fastcampus.data.usecase.file.GetInputStreamUseCaseImpl
import kr.co.fastcampus.data.usecase.file.UploadImageUseCaseImpl
import kr.co.fastcampus.domain.usecase.file.GetImageUseCase
import kr.co.fastcampus.domain.usecase.file.GetInputStreamUseCase
import kr.co.fastcampus.domain.usecase.file.UploadImageUseCase

/**
 * @author soohwan.ok
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class FileModule {
    @Binds
    abstract fun bindGetInputStreamUseCase(uc: GetInputStreamUseCaseImpl):GetInputStreamUseCase

    @Binds
    abstract fun bindGetImageUseCase(uc:GetImageUseCaseImpl):GetImageUseCase

    @Binds
    abstract fun bindUploadImageUseCase(uc: UploadImageUseCaseImpl):UploadImageUseCase
}