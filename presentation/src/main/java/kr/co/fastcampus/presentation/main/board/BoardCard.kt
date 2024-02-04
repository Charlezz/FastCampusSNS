package kr.co.fastcampus.presentation.main.board

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mohamedrejeb.richeditor.model.RichTextState
import com.mohamedrejeb.richeditor.ui.BasicRichText
import kr.co.fastcampus.domain.model.Comment
import kr.co.fastcampus.presentation.component.FCImagePager
import kr.co.fastcampus.presentation.main.board.comment.CommentDialog
import kr.co.fastcampus.presentation.theme.ConnectedTheme

/**
 * @author soohwan.ok
 */
@Composable
fun BoardCard(
    isMine: Boolean,
    boardId: Long,
    profileImageUrl: String? = null,
    username: String,
    images: List<String>,
    richTextState: RichTextState,
    comments: List<Comment>,
    onOptionClick: () -> Unit,
    onDeleteComment: (Long, Comment) -> Unit,
    onCommentSend: (Long, String) -> Unit
) {
    var commentDialogVisible by remember { mutableStateOf(false) }
    Surface {
        Column(
            modifier =
            Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape(16.dp)
                ),
        ) {
            // 헤더
            BoardHeader(
                isMine = isMine,
                modifier = Modifier.fillMaxWidth(),
                profileImageUrl = profileImageUrl,
                username = username,
                onOptionClick = onOptionClick
            )
            // 이미지 페이저
            if (images.isNotEmpty()) {
                FCImagePager(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    images = images,
                )
            }
            var maxLines by remember(richTextState) { mutableStateOf(1) }
            var showMore by remember { mutableStateOf(false) }
            // 내용(텍스트)
            BasicRichText(
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                state = richTextState,
                maxLines = maxLines,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle.Default.copy(color = MaterialTheme.colorScheme.onPrimary),
                onTextLayout = { textLayoutResult ->
                    showMore = textLayoutResult.didOverflowHeight
                }
            )
            if (showMore) {
                TextButton(
                    onClick = {
                        maxLines = Integer.MAX_VALUE
                    }
                ) {
                    Text(
                        text = "더보기",
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
            // 댓글버튼
            TextButton(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .padding(horizontal = 8.dp)
                    .align(Alignment.End),
                onClick = { commentDialogVisible = true }
            ) {
                Text(text = "${comments.size} 댓글")
            }
        }
    }

    CommentDialog(
        isMine = isMine,
        visible = commentDialogVisible,
        comments = comments,
        onDismissRequest = { commentDialogVisible = false },
        onDeleteComment = { comment -> onDeleteComment(boardId, comment) },
        onCloseClick = { commentDialogVisible = false },
        onCommentSend = { text -> onCommentSend(boardId, text) }
    )
}

@Preview
@Composable
private fun BoardCardPreview() {
    ConnectedTheme {
        BoardCard(
            isMine = true,
            boardId = -1L,
            profileImageUrl = null,
            username = "Fast Campus",
            images = emptyList(),
            richTextState = RichTextState(),
            onOptionClick = {},
            comments = emptyList(),
            onDeleteComment = { boardId, comment ->

            }, onCommentSend = { boardId, text ->

            }
        )
    }
}