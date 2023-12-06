package kr.co.fastcampus.sns

import android.content.Context
import androidx.activity.viewModels
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

/**
 * @author soohwan.ok
 */
class AppContainer constructor(private val context: Context) {

    fun createRetrofit():Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://localhost:8080/api/")
            .addConverterFactory(Json.asConverterFactory("application/json; charset=UTF8".toMediaType()))
            .build()
    }


    fun createLoginRetrofitService(): LoginRetrofitService{
        return createRetrofit().create(LoginRetrofitService::class.java)
    }

    fun createUserLocalDataSource():UserLocalDataSource{
        return UserLocalDataSource(context)
    }

    fun createUserRemoteDataSource():UserRemoteDataSource{
        return UserRemoteDataSource(createLoginRetrofitService())
    }

    fun createUserDataRepository():UserDataRepository{
        return UserDataRepository(
            localDataSource = createUserLocalDataSource(),
            remoteDataSource = createUserRemoteDataSource()
        )
    }

    fun createLoginViewModelFactory():AbstractSavedStateViewModelFactory{
        return object : AbstractSavedStateViewModelFactory() {
            val repository = createUserDataRepository()
            override fun <T : ViewModel> create(
                key: String, modelClass: Class<T>, handle: SavedStateHandle
            ): T {
                return LoginViewModel(repository) as T
            }
        }
    }

}
