package kr.co.fastcampus.hiltextensionapp

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
@HiltAndroidApp
class App :Application(){

    @Inject
    lateinit var authenticator: Authenticator

    override fun onCreate() {
        super.onCreate()

        Log.e("App", "authenticator = $authenticator")
    }
}