package kr.co.fastcampus.presentation.main.writing.toolbar

import androidx.annotation.DrawableRes
import kr.co.fastcampus.presentation.R

/**
 * @author soohwan.ok
 */
enum class WritingToolbarType(
    @DrawableRes val resId:Int,
){

    BOLD(R.drawable.bold),
    ITALIC(R.drawable.italic),
    UNDERLINE(R.drawable.underline),
    STRIKETHROUGH(R.drawable.strikethrough)
}