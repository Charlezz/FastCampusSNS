package kr.co.fastcampus.assistedinjection

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
@AndroidEntryPoint
class UserActivity : ComponentActivity() {

    @Inject
    lateinit var getUserInfoUseCaseFactory:GetUserInfoUseCaseFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userNo = intent.getLongExtra("userNo", -1L)

        val getUserInfoUseCase = getUserInfoUseCaseFactory.create(userNo)
        val user = getUserInfoUseCase.getUser()
        Log.e("UserActivity", "user = $user")
    }
}