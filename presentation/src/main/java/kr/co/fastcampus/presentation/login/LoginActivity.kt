package kr.co.fastcampus.presentation.login

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kr.co.fastcampus.presentation.theme.FastcampusSNSTheme

/**
 * @author soohwan.ok
 */
@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FastcampusSNSTheme {
                LoginNavHost()
            }
        }
    }
}