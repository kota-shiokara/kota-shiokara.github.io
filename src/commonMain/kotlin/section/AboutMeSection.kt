package section

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import component.SectionTitle
import jp.ikanoshiokara.kota_shiokara.github.io.generated.resources.Res
import jp.ikanoshiokara.kota_shiokara.github.io.generated.resources.my_name_english
import jp.ikanoshiokara.kota_shiokara.github.io.generated.resources.my_name_japanese
import jp.ikanoshiokara.kota_shiokara.github.io.generated.resources.section_about_me_title
import org.jetbrains.compose.resources.stringResource
import utils.ShiokaraTextStyle

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun AboutMeSection(
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
            title = stringResource(Res.string.section_about_me_title)
        )

        Spacer(modifier = Modifier.height(8.dp))

        MyNameRow()

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier =
                    Modifier
                        .padding(8.dp)
                        .border(
                            width = 4.dp,
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(12.dp)
            ) {
                InformationRow("出身", "北海道札幌市")
                InformationRow("好きなもの", listOf("カービィ", "木目調の内装", "クリエイティブコーディング"))
                InformationRow("好きな言語", listOf("Kotlin", "Hot Soup Processor"))
                InformationRow("座右の銘", "明日は明日の風が吹く")
                InformationRow("一言", "学マスたのしい")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun InformationRow(
    key: String = "-",
    value: String = "-",
    modifier: Modifier = Modifier,
) {
    val windowSizeClass = calculateWindowSizeClass()

    InformationRow(
        key = {
            Text(
                text = "$key:",
                color = Color.Black,
                style = ShiokaraTextStyle.contentStyle(windowSizeClass.widthSizeClass)
            )
        },
        value = {
            Text(
                text = value,
                color = Color.Black,
                style = ShiokaraTextStyle.contentStyle(windowSizeClass.widthSizeClass)
            )
        },
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun InformationRow(
    key: String = "-",
    values: List<String> = listOf("-"),
    modifier: Modifier = Modifier,
) {
    val windowSizeClass = calculateWindowSizeClass()

    InformationRow(
        key = {
            Text(
                text = "$key:",
                color = Color.Black,
                style = ShiokaraTextStyle.contentStyle(windowSizeClass.widthSizeClass)
            )
        },
        value = {
            when (windowSizeClass.widthSizeClass) {
                WindowWidthSizeClass.Compact -> {
                    Column {
                        values.forEach {
                            Text(
                                text = it,
                                color = Color.Black,
                                style = ShiokaraTextStyle.contentStyle(windowSizeClass.widthSizeClass)
                            )
                        }
                    }
                }
                else -> {
                    Text(
                        text = values.joinToString(", "),
                        color = Color.Black,
                        style = ShiokaraTextStyle.contentStyle(windowSizeClass.widthSizeClass)
                    )
                }
            }
        },
        modifier = modifier
    )
}

@Composable
fun InformationRow(
    key: @Composable () -> Unit = {},
    value: @Composable () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Row {
            key()
            Spacer(modifier = Modifier.width(8.dp))
            value()
        }
        Spacer(modifier = Modifier.height(6.dp))
    }
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun MyNameRow(
    modifier: Modifier = Modifier
) {
    val windowSizeClass = calculateWindowSizeClass()

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(Res.string.my_name_japanese),
                color = Color.Black,
                style = ShiokaraTextStyle.contentLargeBoldStyle(windowSizeClass.widthSizeClass)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(Res.string.my_name_english),
                color = Color.Black,
                style = ShiokaraTextStyle.contentStyle(windowSizeClass.widthSizeClass)
            )
        }
    }
}

