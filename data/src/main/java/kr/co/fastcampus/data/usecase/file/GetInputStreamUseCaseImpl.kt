package kr.co.fastcampus.data.usecase.file

import android.content.Context
import android.net.Uri
import kr.co.fastcampus.domain.usecase.file.GetInputStreamUseCase
import java.io.InputStream
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
class GetInputStreamUseCaseImpl @Inject constructor(
    private val context: Context
) : GetInputStreamUseCase {
    override fun invoke(contentUri: String): Result<InputStream> = kotlin.runCatching {
        val uri = Uri.parse(contentUri)
        context.contentResolver.openInputStream(uri)
            ?: throw IllegalStateException("InputStream 얻기 실패")
    }
}