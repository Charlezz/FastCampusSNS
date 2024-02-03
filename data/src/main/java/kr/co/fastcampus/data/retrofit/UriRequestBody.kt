package kr.co.fastcampus.data.retrofit

import android.util.Log
import kr.co.fastcampus.domain.usecase.file.GetInputStreamUseCase
import okhttp3.MediaType
import okhttp3.RequestBody
import okio.BufferedSink
import okio.FileNotFoundException
import okio.source

/**
 * @author soohwan.ok
 */
class UriRequestBody constructor(
    val contentUri: String,
    val getInputStreamUseCase: GetInputStreamUseCase,
    val contentType: MediaType? = null,
    val contentLength: Long,
) : RequestBody() {
    override fun contentType(): MediaType? {
        return contentType
    }

    override fun contentLength(): Long {
        return contentLength
    }

    override fun writeTo(sink: BufferedSink) {
        try {
            getInputStreamUseCase(
                contentUri = contentUri
            )
                .getOrThrow()
                .use { inputStream ->
                    sink.writeAll(inputStream.source())
                }
        } catch (e: FileNotFoundException) {
            Log.e("UriRequestBody", e.message.orEmpty())
        }

    }
}