package kr.co.fastcampus.presentation.main.writing

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

/**
 * @author soohwan.ok
 */
@Composable
fun WritingNavHost() {

    val navController = rememberNavController()
    val sharedViewModel:WritingViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = WritingRoute.IMAGE_SELECT_SCREEN.route,
    ) {

        composable(
            route = WritingRoute.IMAGE_SELECT_SCREEN.route
        ){
            ImageSelectScreen(
                viewModel = sharedViewModel
            )
        }

        composable(
            route = WritingRoute.WRITING_SCREEN.route
        ){
            
        }
    }
}