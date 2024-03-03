package kr.co.fastcampus.dynamicfeature

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import dagger.hilt.android.EntryPointAccessors
import kr.co.fastcampus.data.UserDataStore
import kr.co.fastcampus.sns.FooEntryPoint
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
class DynamicFeatureActivity : ComponentActivity(){

    @Inject
    lateinit var userDataStore: UserDataStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val entryPoint = EntryPointAccessors.fromApplication(applicationContext, FooEntryPoint::class.java)
        val foo = entryPoint.foo()

        val component = DaggerDynamicFeatureComponent.builder()
            .fooEntryPoint(entryPoint)
            .build()

        component.inject(this)

        Log.e("DynamicFeature", "foo = $foo")
        Log.e("DynamicFeature", "userDataStore = ${this::userDataStore.isInitialized}")
    }
}