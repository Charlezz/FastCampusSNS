package kr.co.fastcampus.presentation.main

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import dagger.hilt.android.AndroidEntryPoint
import kr.co.fastcampus.domain.model.ACTION_POSTED
import kr.co.fastcampus.presentation.main.board.BoardViewModel
import kr.co.fastcampus.presentation.theme.ConnectedTheme

/**
 * @author soohwan.ok
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val boardViewModel:BoardViewModel by viewModels()

    private val receiver = object: BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            if(intent?.action == ACTION_POSTED){
                boardViewModel.load()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConnectedTheme {
                MainNavHost(boardViewModel)
            }
        }

        ContextCompat.registerReceiver(
            this,
            receiver,
            IntentFilter(ACTION_POSTED),
            ContextCompat.RECEIVER_NOT_EXPORTED
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }

}