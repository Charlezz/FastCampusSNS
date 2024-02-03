package kr.co.fastcampus.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kr.co.fastcampus.domain.usecase.login.GetTokenUseCase
import kr.co.fastcampus.presentation.login.LoginActivity
import kr.co.fastcampus.presentation.main.MainActivity
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    @Inject
    lateinit var getTokenUseCase: GetTokenUseCase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            val isLoggedIn = !getTokenUseCase().isNullOrEmpty()

            if (isLoggedIn) {
                // 로그인 되었을 떄
                startActivity(
                    Intent(
                        this@SplashActivity, MainActivity::class.java
                    ).apply {
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    }
                )
            } else {
                // 로그인 안되었을 때
                startActivity(
                    Intent(
                        this@SplashActivity, LoginActivity::class.java
                    ).apply {
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    }
                )
            }
        }
    }
}