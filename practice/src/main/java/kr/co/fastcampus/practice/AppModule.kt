package kr.co.fastcampus.practice

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author soohwan.ok
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMyName():MyName{
        Log.e("AppModule","provideMyName 호출")
        return MyName()
    }
}