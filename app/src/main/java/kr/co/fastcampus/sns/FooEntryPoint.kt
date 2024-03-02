package kr.co.fastcampus.sns

import dagger.hilt.InstallIn
import dagger.hilt.android.EarlyEntryPoint
import dagger.hilt.components.SingletonComponent

/**
 * @author soohwan.ok
 */
@EarlyEntryPoint
@InstallIn(SingletonComponent::class)
interface FooEntryPoint {
    fun foo():Foo
}