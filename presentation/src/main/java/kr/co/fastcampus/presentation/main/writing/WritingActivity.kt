package kr.co.fastcampus.presentation.main.writing

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kr.co.fastcampus.presentation.theme.ConnectedTheme

/**
 * @author soohwan.ok
 */
@AndroidEntryPoint
class WritingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConnectedTheme {
                WritingNavHost{ finish() }
            }
        }
    }
}