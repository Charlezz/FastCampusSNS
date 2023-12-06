package kr.co.fastcampus.sns

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kr.co.fastcampus.sns.ui.theme.FastcampusSNSTheme

/**
 * @author soohwan.ok
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    id:String,
    pw:String,
    onIdChange:(String)->Unit,
    onPwChange:(String)->Unit,
    onLoginClick:()->Unit
) {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = id,
                onValueChange = onIdChange
            )
            TextField(
                value = pw,
                onValueChange = onPwChange
            )
            TextButton(
                onClick = onLoginClick
            ){
                Text("Login")
            }
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun LoginScreenPreview() {
    FastcampusSNSTheme {
        LoginScreen(
            id = "",
            pw = "",
            onIdChange = {},
            onPwChange = {},
            onLoginClick = {}
        )
    }
}