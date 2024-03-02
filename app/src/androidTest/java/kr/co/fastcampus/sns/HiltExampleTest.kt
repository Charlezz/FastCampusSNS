package kr.co.fastcampus.sns

import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kr.co.fastcampus.data.UserDataStore
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
@HiltAndroidTest
//@UninstallModules(FooModule::class)
class HiltExampleTest {

    @Inject
    lateinit var userDataStore: UserDataStore

    @get:Rule
    val hiltRule = HiltAndroidRule(this)


//    @BindValue
//    val foo:Foo = Foo("HiltExampleTest")
//
//    @Inject
//    lateinit var bar:Bar

//    @Test
//    fun 주입테스트() {
//        hiltRule.inject()
//        Assert.assertNotNull(userDataStore)
//    }
//
//    @Test
//    fun bar주입테스트(){
//        hiltRule.inject()
//        Assert.assertNotNull(bar)
//        Assert.assertEquals("HiltExampleTest", bar.foo.tag)
//    }

    @Test
    fun test(){

    }

//    @Test
//    fun foo주입테스트() {
//        hiltRule.inject()
//        Assert.assertEquals("FooModule", foo.tag)
//    }
}