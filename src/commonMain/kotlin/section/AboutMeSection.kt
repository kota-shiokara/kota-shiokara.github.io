package section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import jp.ikanoshiokara.kota_shiokara.github.io.generated.resources.Res
import jp.ikanoshiokara.kota_shiokara.github.io.generated.resources.section_about_me_title
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import theme.ShiokaraTheme
import utils.ShiokaraTextStyle

@Composable
fun AboutMeSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        SectionTitle(
            title = stringResource(Res.string.section_about_me_title)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            MyNameRow()
            InformationRow()
        }
    }
}

@Composable
fun InformationRow(
    key: String = "-",
    value: String = "-",
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.width(32.dp))
        Text(
            text = "$key:",
            color = Color.Black,
            style = ShiokaraTextStyle.contentStyle()
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = value,
            color = Color.Black,
            style = ShiokaraTextStyle.contentStyle()
        )
    }
}

@Composable
fun MyNameRow(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = "田島 鼓太郎",
                color = Color.Black,
                style = ShiokaraTextStyle.contentBigStyle()
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Kotaro Tajima",
                color = Color.Black,
                style = ShiokaraTextStyle.contentStyle()
            )
        }
        HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.primary)
    }
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun SectionTitle(
    title: String,
    modifier: Modifier = Modifier
) {
    val windowSizeClass = calculateWindowSizeClass()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        Spacer(modifier = Modifier.width(32.dp))
        VerticalDivider(
            color = MaterialTheme.colorScheme.primary,
            thickness = 8.dp
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = title,
            color = Color.Black,
            style = ShiokaraTextStyle.sectionTitleStyle(windowSizeClass.widthSizeClass)
        )
    }
}

@Preview
@Composable
private fun SectionTitlePreview() {
    ShiokaraTheme {
        SectionTitle(
            title = ""
        )
    }
}
