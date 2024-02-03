package kr.co.fastcampus.presentation.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * @author soohwan.ok
 */
enum class MainRoute(
    val route:String,
    val contentDescription:String,
    val icon:ImageVector
){
    BOARD(route = "BoardScreen", contentDescription = "글목록", icon = Icons.Filled.Home),
    WRITING(route = "WritingScreen", contentDescription = "글쓰기", icon = Icons.Filled.AddCircle),
    SETTING(route = "SettingScreen", contentDescription = "내 정보", icon = Icons.Filled.AccountCircle),
}