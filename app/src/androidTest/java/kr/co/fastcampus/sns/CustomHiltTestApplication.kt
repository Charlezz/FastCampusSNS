package kr.co.fastcampus.sns

import android.app.Application
import android.util.Log
import dagger.hilt.android.EarlyEntryPoints
import dagger.hilt.android.testing.CustomTestApplication

/**
 * @author soohwan.ok
 */
open class CustomHiltTestApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        // to access Foo
//        val fooEntryPoint = EntryPointAccessors.fromApplication(this, FooEntryPoint::class.java)
        val fooEntryPoint = EarlyEntryPoints.get(this, FooEntryPoint::class.java)
        val foo = fooEntryPoint.foo()
        Log.e("Hilt", "foo.tag = ${foo.tag}")
    }
}

@CustomTestApplication(CustomHiltTestApplication::class)
interface MyCustom{

}