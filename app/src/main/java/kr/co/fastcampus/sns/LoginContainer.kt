package kr.co.fastcampus.sns

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 * @author soohwan.ok
 */
class LoginContainer(private val appContainer: AppContainer) {

    private val userDataRepository = UserDataRepository(
        localDataSource = appContainer.createUserLocalDataSource(),
        remoteDataSource = appContainer.createUserRemoteDataSource()
    )
    fun createLoginViewModelFactory(): AbstractSavedStateViewModelFactory {
        return object : AbstractSavedStateViewModelFactory() {
            override fun <T : ViewModel> create(
                key: String, modelClass: Class<T>, handle: SavedStateHandle
            ): T {
                return LoginViewModel(userDataRepository) as T
            }
        }
    }

}
