package kr.co.fastcampus.assistedinjection

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author soohwan.ok
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideUserService():UserService{
        return UserServiceImpl()
    }
}