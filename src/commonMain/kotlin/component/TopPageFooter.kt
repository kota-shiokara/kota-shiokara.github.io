package component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import jp.ikanoshiokara.kota_shiokara.github.io.generated.resources.Res
import jp.ikanoshiokara.kota_shiokara.github.io.generated.resources.top_page_footer_copyright
import org.jetbrains.compose.resources.stringResource

@Composable
fun TopPageFooter() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(Res.string.top_page_footer_copyright),
            modifier = Modifier.padding(8.dp),
            color = Color.Black
        )
    }
}