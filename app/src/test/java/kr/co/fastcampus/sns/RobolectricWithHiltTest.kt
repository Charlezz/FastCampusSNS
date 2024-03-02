package kr.co.fastcampus.sns

import androidx.test.core.app.ApplicationProvider
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kr.co.fastcampus.data.UserDataStore
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
@Config(application = HiltTestApplication::class)
class RobolectricWithHiltTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var userDataStore: UserDataStore

    @Test
    fun 첫번째테스트(){
        hiltRule.inject()
        Assert.assertNotNull(userDataStore)
    }

    @Test
    fun foo접근테스트(){
        val application = ApplicationProvider.getApplicationContext<HiltTestApplication>()
        Assert.assertNotNull(application)

        val entryPoint = EntryPointAccessors.fromApplication(application.applicationContext, FooEntryPoint::class.java)
        Assert.assertEquals("FooModule", entryPoint.foo().tag)
    }
}