package kr.co.fastcampus.dynamicfeature

import dagger.Component
import kr.co.fastcampus.sns.FooEntryPoint

/**
 * @author soohwan.ok
 */
@Component(dependencies = [FooEntryPoint::class])
interface DynamicFeatureComponent {

    fun inject(target:DynamicFeatureActivity)
}