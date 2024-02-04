package kr.co.fastcampus.presentation.main.writing.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mohamedrejeb.richeditor.model.RichTextState
import kr.co.fastcampus.presentation.theme.ConnectedTheme

/**
 * @author soohwan.ok
 */
@Composable
fun WritingToolbar(
    modifier: Modifier = Modifier,
    richTextState: RichTextState,
) {
    Row(
        modifier = modifier
            .background(
                color = Color.White,
                shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        IconButton(
            onClick = {
                richTextState.toggleSpanStyle(
                    SpanStyle(
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = WritingToolbarType.BOLD.resId),
                contentDescription = WritingToolbarType.BOLD.name,
                tint = if (richTextState.currentSpanStyle.fontWeight == FontWeight.Bold) Color.Black else Color.LightGray
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        IconButton(
            onClick = {
                richTextState.toggleSpanStyle(
                    SpanStyle(
                        fontStyle = FontStyle.Italic
                    )
                )
            }
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = WritingToolbarType.ITALIC.resId),
                contentDescription = WritingToolbarType.ITALIC.name,
                tint = if (richTextState.currentSpanStyle.fontStyle == FontStyle.Italic) Color.Black else Color.LightGray
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        IconButton(
            onClick = {
                richTextState.toggleSpanStyle(
                    SpanStyle(
                        textDecoration = TextDecoration.Underline
                    )
                )
            }
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = WritingToolbarType.UNDERLINE.resId),
                contentDescription = WritingToolbarType.UNDERLINE.name,
                tint = if (richTextState.currentSpanStyle.textDecoration?.contains(TextDecoration.Underline) == true) Color.Black else Color.LightGray
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        IconButton(
            onClick = {
                richTextState.toggleSpanStyle(
                    SpanStyle(
                        textDecoration = TextDecoration.LineThrough
                    )
                )
            }
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = WritingToolbarType.STRIKETHROUGH.resId),
                contentDescription = WritingToolbarType.STRIKETHROUGH.name,
                tint = if (richTextState.currentSpanStyle.textDecoration?.contains(TextDecoration.LineThrough) == true) Color.Black else Color.LightGray
            )
        }
    }
}

@Preview
@Composable
private fun WritingToolbarPreview() {
    ConnectedTheme {
        Surface {
            var richTextState by remember{ mutableStateOf(RichTextState()) }
            WritingToolbar(
                modifier = Modifier.fillMaxWidth(),
                richTextState = richTextState
            )
        }
    }
}