package kr.co.fastcampus.presentation.main.writing

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.orbitmvi.orbit.compose.collectSideEffect

/**
 * @author soohwan.ok
 */
@Composable
fun WritingNavHost(
    onFinish: () -> Unit
) {

    val context = LocalContext.current
    val navController = rememberNavController()
    val sharedViewModel: WritingViewModel = viewModel()

    sharedViewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            WritingSideEffect.Finish -> onFinish()
            is WritingSideEffect.Toast -> {
                Toast.makeText(context, sideEffect.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = WritingRoute.IMAGE_SELECT_SCREEN.route,
    ) {

        composable(
            route = WritingRoute.IMAGE_SELECT_SCREEN.route
        ) {
            ImageSelectScreen(
                viewModel = sharedViewModel,
                onBackClick = onFinish,
                onNextClick = {
                    navController.navigate(WritingRoute.WRITING_SCREEN.route)
                }
            )
        }

        composable(
            route = WritingRoute.WRITING_SCREEN.route
        ) {
            WritingScreen(
                viewModel = sharedViewModel,
                onBackClick = { navController.navigateUp() },
            )
        }
    }
}