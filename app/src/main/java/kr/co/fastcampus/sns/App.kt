package kr.co.fastcampus.sns

import android.app.Application

/**
 * @author soohwan.ok
 */
class App : Application() {
    val appContainer:AppContainer = AppContainer(context = this)
}