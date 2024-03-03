package kr.co.fastcampus.hiltextensionapp

import dagger.hilt.components.SingletonComponent
import kr.co.fastcampus.annotations.InstallBinding
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
@InstallBinding(component = SingletonComponent::class)
class AuthenticatorImpl @Inject constructor(): Authenticator