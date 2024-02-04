package kr.co.fastcampus.data.usecase.file

import kr.co.fastcampus.data.di.FC_HOST
import kr.co.fastcampus.data.retrofit.FileService
import kr.co.fastcampus.data.retrofit.UriRequestBody
import kr.co.fastcampus.domain.model.Image
import kr.co.fastcampus.domain.usecase.file.GetInputStreamUseCase
import kr.co.fastcampus.domain.usecase.file.UploadImageUseCase
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
class UploadImageUseCaseImpl @Inject constructor(
    private val fileService: FileService,
    private val getInputStreamUseCase: GetInputStreamUseCase,
) : UploadImageUseCase {
    override suspend fun invoke(image: Image): Result<String> = kotlin.runCatching {
        val fileNamePart = MultipartBody.Part.createFormData(
            "fileName",
            image.name
        )
        val requestBody = UriRequestBody(
            contentUri = image.uri,
            getInputStreamUseCase = getInputStreamUseCase,
            contentType = image.mimeType.toMediaType(),
            contentLength = image.size
        )
        val filePart = MultipartBody.Part.createFormData(
            "file",
            image.name,
            requestBody
        )
        FC_HOST+fileService.uploadFile(
            fileName = fileNamePart,
            file = filePart,
        ).data.filePath
    }
}