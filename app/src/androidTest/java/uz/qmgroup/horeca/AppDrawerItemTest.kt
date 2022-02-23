@file:Suppress("TestFunctionName")

package uz.qmgroup.horeca

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import uz.qmgroup.horeca.layouts.AppDrawerItem
import uz.qmgroup.horeca.ui.theme.HoReCaTheme

@Preview(
    showBackground = true, showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun AppDrawerItemPreview() {
    HoReCaTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            AppDrawerItem(
                modifier = Modifier.fillMaxWidth(),
                iconPainter = rememberVectorPainter(image = Icons.Outlined.Search),
                label = "Search"
            )
        }
    }
}