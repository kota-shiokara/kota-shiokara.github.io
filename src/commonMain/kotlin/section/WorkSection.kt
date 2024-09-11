package section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import component.SectionTitle

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun WorkSection(
    modifier: Modifier = Modifier
) {
    val windowSizeClass = calculateWindowSizeClass()
    val horizontalPadding = when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            16.dp
        }
        else -> {
            24.dp
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = horizontalPadding)
    ) {
        SectionTitle(
            icon = {
                Icon(
                    imageVector = Icons.Default.Work,
                    contentDescription = "Work",
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            title = "Work"
        )
        Spacer(modifier = Modifier.height(8.dp))

        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(Color.LightGray),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Comming Soon...")
        }
    }
}