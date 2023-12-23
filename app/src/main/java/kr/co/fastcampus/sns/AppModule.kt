package kr.co.fastcampus.sns

import android.app.Application
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

/**
 * @author soohwan.ok
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://172.30.1.61:8080/api/")
            .addConverterFactory(Json.asConverterFactory("application/json; charset=UTF8".toMediaType()))
            .build()
    }
    @Provides
    fun provideLoginRetrofitService(retrofit: Retrofit): LoginRetrofitService{
        return retrofit.create(LoginRetrofitService::class.java)
    }

    @Provides
    fun provideUserLocalDataSource(application:Application):UserLocalDataSource{
        return UserLocalDataSource(application)
    }

    @Provides
    fun provideUserRemoteDataSource(loginRetrofitService: LoginRetrofitService):UserRemoteDataSource{
        return UserRemoteDataSource(loginRetrofitService)
    }

}