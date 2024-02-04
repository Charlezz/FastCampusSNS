package kr.co.fastcampus.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kr.co.fastcampus.presentation.R
import kr.co.fastcampus.presentation.main.board.BoardScreen
import kr.co.fastcampus.presentation.main.board.BoardViewModel
import kr.co.fastcampus.presentation.main.setting.SettingScreen

/**
 * @author soohwan.ok
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavHost(boardViewModel: BoardViewModel) {
    val navController = rememberNavController()
    Surface {
        Scaffold(
            topBar = {
                TopAppBar(
                    modifier = Modifier.background(MaterialTheme.colorScheme.background),
                    title = {
                        Text(text = stringResource(id = R.string.app_name))
                    }
                )
            },
            content = { padding ->
                NavHost(
                    modifier = Modifier.padding(padding),
                    navController = navController,
                    startDestination = MainRoute.BOARD.route
                ) {
                    composable(route = MainRoute.BOARD.route) {
                        BoardScreen(boardViewModel)
                    }
                    composable(route = MainRoute.SETTING.route) {
                        SettingScreen()
                    }
                }
            },
            bottomBar = {
                MainBottomBar(
                    navController = navController
                )
            }
        )
    }
}