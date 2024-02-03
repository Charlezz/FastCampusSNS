package kr.co.fastcampus.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.fastcampus.data.usecase.ClearTokenUseCaseImpl
import kr.co.fastcampus.data.usecase.GetTokenUseCaseImpl
import kr.co.fastcampus.data.usecase.LoginUseCaseImpl
import kr.co.fastcampus.data.usecase.SetTokenUseCaseImpl
import kr.co.fastcampus.data.usecase.SignUpUseCaseImpl
import kr.co.fastcampus.domain.usecase.login.ClearTokenUseCase
import kr.co.fastcampus.domain.usecase.login.GetTokenUseCase
import kr.co.fastcampus.domain.usecase.login.LoginUseCase
import kr.co.fastcampus.domain.usecase.login.SetTokenUseCase
import kr.co.fastcampus.domain.usecase.login.SignUpUseCase

/**
 * @author soohwan.ok
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class UserModule {

    @Binds
    abstract fun bindLoginUseCase(uc:LoginUseCaseImpl):LoginUseCase

    @Binds
    abstract fun bindSignUpUseCase(uc: SignUpUseCaseImpl):SignUpUseCase

    @Binds
    abstract fun bindGetTokenUseCase(uc: GetTokenUseCaseImpl):GetTokenUseCase

    @Binds
    abstract fun bindSetTokenUseCase(uc: SetTokenUseCaseImpl):SetTokenUseCase

    @Binds
    abstract fun bindClearTokenUseCase(uc: ClearTokenUseCaseImpl):ClearTokenUseCase
}