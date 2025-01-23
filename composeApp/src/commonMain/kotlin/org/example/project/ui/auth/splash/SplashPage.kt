package org.example.project.ui.auth.splash


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.unit.dp
import kmmapp.composeapp.generated.resources.Res
import kmmapp.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SplashPage(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit,
) {
    Scaffold {
        Column(
            modifier = modifier
                .padding(it)
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        tileMode = TileMode.Decal,
                        colors = listOf(
                            MaterialTheme.colorScheme.error,
                            MaterialTheme.colorScheme.error.copy(alpha = 0.8f)
                        )
                    )
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            SplashLoadingState()
        }
    }

}

@Composable
fun SplashErrorState(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize()
    ) {
        Text(text = "Error Loading")
    }
}

@Composable
fun SplashLoadingState(modifier: Modifier = Modifier) {
    Image(
        modifier = Modifier
            .size(160.dp)
            .background(
                color = MaterialTheme.colorScheme.onPrimary,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(10.dp)
            .border(
                width = 2.dp,
                shape = RoundedCornerShape(8.dp), // Use the same rounded corner radius for the border
                color = Color.Black // Border color
            ),
        painter = painterResource(Res.drawable.compose_multiplatform),
        contentDescription = null
    )
}


@Preview
@Composable
private fun SplashPagePreview() {
    SplashPage(navigateUp = {})
}