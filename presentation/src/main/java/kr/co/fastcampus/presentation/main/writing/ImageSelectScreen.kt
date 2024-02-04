package kr.co.fastcampus.presentation.main.writing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import kr.co.fastcampus.domain.model.Image
import kr.co.fastcampus.presentation.theme.ConnectedTheme
import org.orbitmvi.orbit.compose.collectAsState

/**
 * @author soohwan.ok
 */

@Composable
fun ImageSelectScreen(
    viewModel: WritingViewModel,
    onBackClick: () -> Unit,
    onNextClick: () -> Unit
) {
    val state = viewModel.collectAsState().value

    ImageSelectScreen(
        selectedImages = state.selectedImages,
        images = state.images,
        onBackClick = onBackClick,
        onNextClick = onNextClick,
        onItemClick = viewModel::onItemClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ImageSelectScreen(
    selectedImages: List<Image>,
    images: List<Image>,
    onBackClick: () -> Unit,
    onNextClick: () -> Unit,
    onItemClick: (Image) -> Unit
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
                        TextButton(onClick = onNextClick) {
                            Text(text = "다음")
                        }
                    }
                )
            },
            content = { paddingValues ->
                Column(modifier = Modifier.padding(paddingValues)) {
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            modifier = Modifier.fillMaxSize(),
                            painter = rememberAsyncImagePainter(
                                model = selectedImages.lastOrNull()?.uri
                            ),
                            contentScale = ContentScale.Crop,
                            contentDescription = null
                        )
                        if (images.isEmpty()) {
                            Text(text = "선택된 이미지가 없습니다.")
                        }
                    }
                    LazyVerticalGrid(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .background(Color.White),
                        columns = GridCells.Adaptive(110.dp),
                        horizontalArrangement = Arrangement.spacedBy(2.dp),
                        verticalArrangement = Arrangement.spacedBy(2.dp),
                    ) {
                        items(
                            count = images.size,
                            key = { index -> images[index].uri }
                        ) { index ->
                            val image = images[index]
                            Box(
                                modifier = Modifier.clickable {
                                    onItemClick(image)
                                }
                            ) {
                                Image(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .aspectRatio(1f),
                                    painter = rememberAsyncImagePainter(
                                        model = image.uri,
                                        contentScale = ContentScale.Crop
                                    ),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop
                                )
                                if (selectedImages.contains(image)) {
                                    Icon(
                                        modifier = Modifier
                                            .padding(start = 4.dp, top = 4.dp)
                                            .clip(CircleShape)
                                            .background(color = Color.White),
                                        imageVector = Icons.Filled.CheckCircle,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                }
                            }
                        }
                    }
                }
            },
        )
    }
}

@Preview
@Composable
private fun ImageSelectScreenPreview() {
    ConnectedTheme {
        ImageSelectScreen(
            selectedImages = emptyList(),
            images = emptyList(),
            onBackClick = {},
            onNextClick = {},
            onItemClick = {},

            )
    }
}