package theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import jp.ikanoshiokara.kota_shiokara.github.io.generated.resources.NotoSansJP_Black
import jp.ikanoshiokara.kota_shiokara.github.io.generated.resources.NotoSansJP_Bold
import jp.ikanoshiokara.kota_shiokara.github.io.generated.resources.NotoSansJP_ExtraBold
import jp.ikanoshiokara.kota_shiokara.github.io.generated.resources.NotoSansJP_ExtraLight
import jp.ikanoshiokara.kota_shiokara.github.io.generated.resources.NotoSansJP_Light
import jp.ikanoshiokara.kota_shiokara.github.io.generated.resources.NotoSansJP_Medium
import jp.ikanoshiokara.kota_shiokara.github.io.generated.resources.NotoSansJP_Regular
import jp.ikanoshiokara.kota_shiokara.github.io.generated.resources.NotoSansJP_SemiBold
import jp.ikanoshiokara.kota_shiokara.github.io.generated.resources.NotoSansJP_Thin
import jp.ikanoshiokara.kota_shiokara.github.io.generated.resources.Res
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.FontResource

private val fontSets: List<Pair<FontResource, FontWeight>> = listOf(
    Pair(Res.font.NotoSansJP_Medium, FontWeight.Normal),
    Pair(Res.font.NotoSansJP_Regular, FontWeight.Normal),
    Pair(Res.font.NotoSansJP_Black, FontWeight.Black),
    Pair(Res.font.NotoSansJP_Bold, FontWeight.Bold),
    Pair(Res.font.NotoSansJP_ExtraBold, FontWeight.ExtraBold),
    Pair(Res.font.NotoSansJP_ExtraLight, FontWeight.ExtraLight),
    Pair(Res.font.NotoSansJP_Light, FontWeight.Light),
    Pair(Res.font.NotoSansJP_SemiBold, FontWeight.SemiBold),
    Pair(Res.font.NotoSansJP_Thin, FontWeight.Thin)
)

@Composable
fun rememberFontFamily() = FontFamily(
    fontSets.map { (res, weight) -> Font(res, weight) },
)