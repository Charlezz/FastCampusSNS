package kr.co.fastcampus.presentation.login

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import kr.co.fastcampus.presentation.theme.FastcampusSNSTheme

/**
 * @author soohwan.ok
 */
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