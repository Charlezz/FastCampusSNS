package kr.co.fastcampus.sns

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * @author soohwan.ok
 */
class LoginViewModel constructor(
    private val repository: UserDataRepository,
):ViewModel(){

    private val _uiState = MutableStateFlow(
        LoginUiState(id = "", pw = "")
    )
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            if(repository.isLoggedIn()){
                val isLoggedInBefore = repository.isLoggedIn()
                if(isLoggedInBefore){
                    _uiState.update { it.copy(userState = UserState.LOGGED_IN) }
                }
            }
        }
    }

    fun login(){
        viewModelScope.launch(Dispatchers.IO) {
            val isLoggedIn = repository.login(
                _uiState.value.id,
                _uiState.value.pw
            )
            val token = repository.getCurrentToken()
            _uiState.update {
                it.copy(userState = if(isLoggedIn) UserState.LOGGED_IN else UserState.FAILED)
            }
        }
    }

    fun onIdChange(value: String) {
        _uiState.update { it.copy(id = value) }

    }

    fun onPwChange(value: String) {
        _uiState.update { it.copy(pw = value) }
    }

}