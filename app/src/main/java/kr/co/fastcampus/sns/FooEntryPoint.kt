package kr.co.fastcampus.sns

import dagger.hilt.InstallIn
import dagger.hilt.android.EarlyEntryPoint
import dagger.hilt.components.SingletonComponent
import kr.co.fastcampus.data.UserDataStore

/**
 * @author soohwan.ok
 */
@EarlyEntryPoint
@InstallIn(SingletonComponent::class)
interface FooEntryPoint {
    fun foo():Foo

    fun userDataStore():UserDataStore
}