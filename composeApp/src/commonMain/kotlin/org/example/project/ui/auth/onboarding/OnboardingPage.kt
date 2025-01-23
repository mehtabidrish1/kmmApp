
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import org.example.project.ui.auth.onboarding.OnBoardingViewModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit,
    viewModel: OnBoardingViewModel = OnBoardingViewModel(),
) {
    val scrollState = rememberScrollState()
    Scaffold {
        val data = viewModel.onboardingState.value.data;
        val state = viewModel.onboardingState.value;
        Column(
            modifier = modifier
                .padding(it)
                .fillMaxSize()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(0.2f))
            Image(
                modifier = Modifier.weight(1f),
                painter = painterResource( data.assets[state.currentIndex]),
                contentDescription = null
            )
            Spacer(modifier = modifier.height(20.dp))
            CustomLinerProgressIndicator(currentIndex = state.currentIndex)
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = modifier.height(20.dp))
                Text(
                    text = data.heading[state.currentIndex],
                    style = MaterialTheme.typography.headlineLarge,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = data.description[state.currentIndex],
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.outline,
                    )
                )
                Spacer(modifier = Modifier.weight(0.5f))
                ElevatedButton(
                    enabled = state.currentIndex == 2,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.error.copy(alpha = 0.9f)
                    ),
                    onClick = {
                        navigateUp();
                    }) {
                    Text(text = "Get Started")
                }
                Spacer(modifier = Modifier.height(10.dp))
                TextButton(onClick = {
                    navigateUp();
                }) {
                    Text(
                        text = "Skip",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = MaterialTheme.colorScheme.error.copy(alpha = 0.8f)
                        )
                    )
                }
                Spacer(modifier = Modifier.weight(0.5f))
            }


        }
    }

}

@Composable
fun CustomLinerProgressIndicator(modifier: Modifier = Modifier, currentIndex: Int) {
    Row {
        for (n in 0..2) {
            Surface(
                modifier = Modifier
                    .height(4.dp)
                    .width(20.dp),
                color = if (currentIndex == n) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.outline
            ) {
            }
            Spacer(modifier = modifier.width(10.dp))


        }
    }

}


@Preview
@Composable
private fun OnBoardingPreview() {
    OnBoardingPage(
        navigateUp = {}
    )
}