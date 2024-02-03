package kr.co.fastcampus.presentation.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kr.co.fastcampus.presentation.component.FCButton
import kr.co.fastcampus.presentation.component.FCTextField
import kr.co.fastcampus.presentation.theme.ConnectedTheme
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

/**
 * @author soohwan.ok
 */

@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel = hiltViewModel(),
    onNavigateToLoginScreen:()->Unit
) {

    val state = viewModel.collectAsState().value
    val context = LocalContext.current
    viewModel.collectSideEffect{ sideEffect ->
        when(sideEffect){
            is SignUpSideEffect.Toast -> Toast.makeText(context, sideEffect.message, Toast.LENGTH_SHORT).show()
            SignUpSideEffect.NavigateToLoginScreen -> onNavigateToLoginScreen()
        }
    }

    SignUpScreen(
        id = state.id,
        username = state.username,
        password1 = state.password,
        password2 = state.repeatPassword,
        onIdChange = viewModel::onIdChange,
        onUsernameChange = viewModel::onUsernameChange,
        onPassword1Change = viewModel::onPasswordChange,
        onPassword2Change = viewModel::onRepeatPasswordChange,
        onSignUpClick = viewModel::onSignUpClick
    )
}

@Composable
fun SignUpScreen(
    id: String,
    username: String,
    password1: String,
    password2: String,

    onIdChange: (String) -> Unit,
    onUsernameChange: (String) -> Unit,
    onPassword1Change: (String) -> Unit,
    onPassword2Change: (String) -> Unit,

    onSignUpClick: () -> Unit
) {
    Surface {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Column(
                modifier = Modifier.padding(top = 48.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Connected",
                    style = MaterialTheme.typography.displaySmall,
                )
                Text(
                    text = "Your favorite social network",
                    style = MaterialTheme.typography.labelSmall
                )
            }
            Column(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    .background(MaterialTheme.colorScheme.background)
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight()
            ) {
                Text(
                    modifier = Modifier.padding(top = 36.dp),
                    text = "Create an account",
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = "Id",
                    style = MaterialTheme.typography.labelLarge
                )
                FCTextField(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    value = id,
                    onValueChange = onIdChange
                )

                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = "Username",
                    style = MaterialTheme.typography.labelLarge
                )
                FCTextField(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    value = username,
                    onValueChange = onUsernameChange
                )

                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = "Password",
                    style = MaterialTheme.typography.labelLarge
                )
                FCTextField(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    value = password1,
                    visualTransformation = PasswordVisualTransformation(),
                    onValueChange = onPassword1Change
                )

                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = "Repeat password",
                    style = MaterialTheme.typography.labelLarge
                )
                FCTextField(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    visualTransformation = PasswordVisualTransformation(),
                    value = password2,
                    onValueChange = onPassword2Change
                )

                FCButton(
                    modifier = Modifier
                        .padding(vertical = 24.dp)
                        .fillMaxWidth(),
                    text = "Sign up",
                    onClick = onSignUpClick
                )
            }
        }
    }
}

@Preview
@Composable
private fun SignUpScreenPreview() {
    ConnectedTheme {
        SignUpScreen(
            id = "test",
            username = "Charles",
            password1 = "test1234",
            password2 = "test1234",
            onIdChange = {},
            onUsernameChange = {},
            onPassword1Change = {},
            onPassword2Change = {},
            onSignUpClick = {})
    }
}