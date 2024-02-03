package kr.co.fastcampus.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.fastcampus.data.usecase.LoginUseCaseImpl
import kr.co.fastcampus.domain.usecase.login.LoginUseCase

/**
 * @author soohwan.ok
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class UserModule {

    @Binds
    abstract fun bindLoginUseCase(uc:LoginUseCaseImpl):LoginUseCase
}