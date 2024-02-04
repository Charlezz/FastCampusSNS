package kr.co.fastcampus.presentation.main.board.comment

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.fastcampus.presentation.component.FCProfileImage
import kr.co.fastcampus.presentation.theme.ConnectedTheme

/**
 * @author soohwan.ok
 */
@Composable
fun CommentCard(
    modifier: Modifier = Modifier,
    isMine :Boolean,
    profileImageUrl: String? = null,
    username: String = "",
    text: String = "",
    onDeleteComment: () -> Unit
) {
    Surface {
        Row(
            modifier = modifier
                .padding(vertical = 8.dp)
                .padding(start = 16.dp)
            ,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            FCProfileImage(
                modifier = Modifier.size(28.dp),
                profileImageUrl = profileImageUrl,
                borderWidth = 0.7.dp,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = username)
                Text(text = text)
            }
            Spacer(modifier = Modifier.weight(1f))
            if(isMine){
                IconButton(onClick = onDeleteComment) {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        imageVector = Icons.Filled.Clear,
                        contentDescription = "삭제"
                    )
                }
            }
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun CommentCardPreview() {
    ConnectedTheme {
        CommentCard(
            isMine = true,
            profileImageUrl = null,
            username = "Charles",
            text = "안녕하세요 !",
            onDeleteComment = {}
        )
    }
}