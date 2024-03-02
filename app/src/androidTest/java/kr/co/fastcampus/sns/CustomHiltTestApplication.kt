package kr.co.fastcampus.sns

import android.app.Application
import android.util.Log
import dagger.hilt.android.testing.CustomTestApplication

/**
 * @author soohwan.ok
 */
open class CustomHiltTestApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Log.e("Hilt", "애플리케이션 생성 후, 비즈니스 로직 수행")
    }
}

@CustomTestApplication(CustomHiltTestApplication::class)
interface MyCustom{

}