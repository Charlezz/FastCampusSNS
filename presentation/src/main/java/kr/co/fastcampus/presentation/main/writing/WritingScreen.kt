package kr.co.fastcampus.presentation.main.writing

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import com.mohamedrejeb.richeditor.model.RichTextState
import com.mohamedrejeb.richeditor.ui.BasicRichTextEditor
import kr.co.fastcampus.presentation.component.FCImagePager
import kr.co.fastcampus.presentation.main.writing.toolbar.WritingToolbar
import kr.co.fastcampus.presentation.theme.ConnectedTheme
import org.orbitmvi.orbit.compose.collectAsState

/**
 * @author soohwan.ok
 */
@Composable
fun WritingScreen(
    viewModel: WritingViewModel,
    onBackClick: () -> Unit,
) {
    val state = viewModel.collectAsState().value
    WritingScreen(
        richTextState = state.richTextState,
        images = state.selectedImages.map { it.uri },
        onBackClick = onBackClick,
        onPostClick = viewModel::onPostClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun WritingScreen(
    richTextState:RichTextState,
    images: List<String>,
    onBackClick: () -> Unit,
    onPostClick: () -> Unit
) {
    Surface {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = "새 게시물",
                            style = MaterialTheme.typography.headlineSmall
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "뒤로가기"
                            )
                        }
                    },
                    actions = {
                        TextButton(onClick = onPostClick) {
                            Text(text = "게시")
                        }
                    }
                )
            },
            content = { paddingValues ->
                Column(modifier = Modifier.padding(paddingValues)) {
                    FCImagePager(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(2f),
                        images = images
                    )
                    Divider()
                    BasicRichTextEditor(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(3f),
                        state = richTextState,
                        cursorBrush = SolidColor(Color.White),
                        textStyle = MaterialTheme.typography.bodyLarge.copy(color = Color.White),
                        decorationBox = { innerTextField ->
                            if(richTextState.annotatedString.isEmpty()){
                                Text(text = "문구를 입력해 주세요")
                            }
                            innerTextField()
                        }
                    )
                }
            },
            bottomBar = {
                WritingToolbar(
                    modifier = Modifier.fillMaxWidth(),
                    richTextState = richTextState
                )
            }
        )

    }
}

@Preview
@Composable
private fun WritingScreenPreview() {
    ConnectedTheme {
        WritingScreen(
            images = emptyList(),
            onBackClick = {},
            onPostClick = {},
            richTextState = RichTextState(),

        )
    }
}