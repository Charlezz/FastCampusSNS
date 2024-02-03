package kr.co.fastcampus.data.usecase.file

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import kr.co.fastcampus.domain.model.Image
import kr.co.fastcampus.domain.usecase.file.GetImageUseCase
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
class GetImageUseCaseImpl @Inject constructor(
    private val context: Context
) : GetImageUseCase {
    override fun invoke(contentUri: String): Image? {
        val uri = Uri.parse(contentUri)
        val projection = arrayOf(
            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.DISPLAY_NAME,
            MediaStore.Images.Media.SIZE,
            MediaStore.Images.Media.MIME_TYPE,
        )
        val cursor = context.contentResolver.query(
            uri,
            projection,
            null,
            null,
            null
        )

        return cursor?.use { c ->
            c.moveToNext()
            val idIndex = c.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
            val nameIndex = c.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME)
            val sizeIndex = c.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE)
            val mimeTypeIndex = c.getColumnIndexOrThrow(MediaStore.Images.Media.MIME_TYPE)

            val name = cursor.getString(nameIndex)
            val size = cursor.getLong(sizeIndex)
            val mimeType = cursor.getString(mimeTypeIndex)
            Image(
                uri = contentUri,
                name = name,
                size = size,
                mimeType = mimeType
            )
        }
    }
}