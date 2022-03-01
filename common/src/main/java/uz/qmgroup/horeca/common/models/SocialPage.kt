package uz.qmgroup.horeca.common.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Language
import androidx.compose.ui.graphics.vector.ImageVector
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.brands.Facebook
import compose.icons.fontawesomeicons.brands.Google
import compose.icons.fontawesomeicons.brands.Instagram
import compose.icons.fontawesomeicons.brands.Telegram

sealed class SocialPage(val icon: ImageVector) {
    object Facebook : SocialPage(FontAwesomeIcons.Brands.Facebook)
    object Instagram : SocialPage(FontAwesomeIcons.Brands.Instagram)
    object WebSite : SocialPage(Icons.Default.Language)
    object Google : SocialPage(FontAwesomeIcons.Brands.Google)
    object Telegram : SocialPage(FontAwesomeIcons.Brands.Telegram)
}