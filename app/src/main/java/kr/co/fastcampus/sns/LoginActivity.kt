package kr.co.fastcampus.sns

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import kr.co.fastcampus.sns.ui.theme.FastcampusSNSTheme
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

class LoginActivity : ComponentActivity() {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://localhost:8080/api/")
        .addConverterFactory(Json.asConverterFactory("application/json; charset=UTF8".toMediaType()))
        .build()

    private val loginRetrofitService = retrofit.create(LoginRetrofitService::class.java)
    private val localDataSource = UserLocalDataSource(this)
    private val remoteDataSource = UserRemoteDataSource(loginRetrofitService)
    private val userDataRepository = UserDataRepository(localDataSource, remoteDataSource)

    private val viewModel: LoginViewModel by viewModels {
        object : AbstractSavedStateViewModelFactory() {
            override fun <T : ViewModel> create(
                key: String, modelClass: Class<T>, handle: SavedStateHandle
            ): T {
                return LoginViewModel(userDataRepository) as T
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    when (it.userState) {
                        UserState.NONE -> {
                            // nothing to do
                        }

                        UserState.FAILED -> {
                            Toast.makeText(this@LoginActivity, "로그인에 실패하였습니다", Toast.LENGTH_SHORT)
                                .show()
                        }

                        UserState.LOGGED_IN -> {
                            startActivity(Intent(this@LoginActivity, UserInfoActivity::class.java))
                            finish()
                        }
                    }
                }
            }
        }

        setContent {
            FastcampusSNSTheme {
                val uiState = viewModel.uiState.collectAsState().value
                LoginScreen(
                    id = uiState.id,
                    pw = uiState.pw,
                    onIdChange = viewModel::onIdChange,
                    onPwChange = viewModel::onPwChange,
                    onLoginClick = viewModel::login
                )
            }
        }
    }
}
