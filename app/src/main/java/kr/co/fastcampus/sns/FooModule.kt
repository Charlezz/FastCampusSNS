package kr.co.fastcampus.sns

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
@Module
@InstallIn(SingletonComponent::class)
class FooModule {

//    @Provides
//    fun provideFoo():Foo{
//        return Foo("FooModule")
//    }
}

class Foo(val tag:String)

class Bar @Inject constructor(val foo:Foo)