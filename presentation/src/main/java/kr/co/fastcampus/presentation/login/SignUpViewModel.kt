package kr.co.fastcampus.presentation.login

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kr.co.fastcampus.domain.usecase.login.SignUpUseCase
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
) : ViewModel(),
    ContainerHost<SignUpState, SignUpSideEffect> {
    override val container: Container<SignUpState, SignUpSideEffect> = container(
        initialState = SignUpState(),
        buildSettings = {
            this.exceptionHandler = CoroutineExceptionHandler { _, throwable ->
                intent { postSideEffect(SignUpSideEffect.Toast(throwable.message.orEmpty())) }
            }
        }
    )

    fun onIdChange(id: String) = blockingIntent {
        reduce { state.copy(id = id) }
    }

    fun onUsernameChange(username: String) = blockingIntent {
        reduce { state.copy(username = username) }
    }

    fun onPasswordChange(pw: String) = blockingIntent {
        reduce { state.copy(password = pw) }
    }

    fun onRepeatPasswordChange(pw: String) = blockingIntent {
        reduce { state.copy(repeatPassword = pw) }
    }

    fun onSignUpClick() = intent {
        if(state.password != state.repeatPassword){
            postSideEffect(SignUpSideEffect.Toast(message = "패스워드를 다시 확인해주세요."))
            return@intent
        }
        val isSuccessful = signUpUseCase(
            id = state.id,
            username = state.username,
            password = state.password
        ).getOrThrow()

        if(isSuccessful){
            postSideEffect(SignUpSideEffect.NavigateToLoginScreen)
            postSideEffect(SignUpSideEffect.Toast("회원가입에 성공했습니다"))
        }
    }
}

@Immutable
data class SignUpState(
    val id: String = "",
    val username: String = "",
    val password: String = "",
    val repeatPassword: String = "",
)

sealed interface SignUpSideEffect {
    class Toast(val message: String) : SignUpSideEffect

    object NavigateToLoginScreen : SignUpSideEffect
}