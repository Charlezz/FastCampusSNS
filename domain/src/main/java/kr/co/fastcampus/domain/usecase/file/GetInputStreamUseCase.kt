package kr.co.fastcampus.domain.usecase.file

import java.io.InputStream

/**
 * @author soohwan.ok
 */
interface GetInputStreamUseCase {
    operator fun invoke(contentUri: String): Result<InputStream>
}