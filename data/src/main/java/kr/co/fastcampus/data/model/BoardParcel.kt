package kr.co.fastcampus.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kr.co.fastcampus.domain.model.Image

/**
 * @author soohwan.ok
 */
@Parcelize
data class BoardParcel(
    val title: String,
    val content: String,
    val images: List<Image>
) : Parcelable