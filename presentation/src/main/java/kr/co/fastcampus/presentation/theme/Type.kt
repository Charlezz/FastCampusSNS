package kr.co.fastcampus.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import kr.co.fastcampus.presentation.R

private val pretendardFontFamily = FontFamily(Font(R.font.pretendard))
private val defaultTypography = Typography()

val Typography = Typography(
    titleLarge = defaultTypography.titleLarge.copy(fontFamily = pretendardFontFamily),
    titleMedium = defaultTypography.titleMedium.copy(fontFamily = pretendardFontFamily),
    titleSmall = defaultTypography.titleSmall.copy(fontFamily = pretendardFontFamily),
    labelLarge = defaultTypography.labelLarge.copy(fontFamily = pretendardFontFamily),
    labelMedium = defaultTypography.labelMedium.copy(fontFamily = pretendardFontFamily),
    labelSmall = defaultTypography.labelSmall.copy(fontFamily = pretendardFontFamily),
    bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = pretendardFontFamily),
    bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = pretendardFontFamily),
    bodySmall = defaultTypography.bodySmall.copy(fontFamily = pretendardFontFamily),
    displayLarge = defaultTypography.displayLarge.copy(fontFamily = pretendardFontFamily),
    displayMedium = defaultTypography.displayMedium.copy(fontFamily = pretendardFontFamily),
    displaySmall = defaultTypography.displaySmall.copy(fontFamily = pretendardFontFamily),
    headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = pretendardFontFamily),
    headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = pretendardFontFamily),
    headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = pretendardFontFamily),
)