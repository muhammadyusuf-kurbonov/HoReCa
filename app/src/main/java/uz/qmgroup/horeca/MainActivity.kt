package uz.qmgroup.horeca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.imePadding
import com.google.accompanist.insets.systemBarsPadding
import uz.qmgroup.horeca.layouts.AppLayout
import uz.qmgroup.horeca.ui.screens.welcome.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ProvideWindowInsets {
                var welcomeScreen by remember {
                    mutableStateOf(
                        getSharedPreferences("main", 0)
                            .getBoolean("firstRun", true)
                    )
                }

                if (welcomeScreen)
                    WelcomeScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        finishWizard = {
                            welcomeScreen = false
                            getSharedPreferences("main", 0)
                                .edit()
                                .putBoolean("firstRun", false)
                                .apply()
                        }
                    )
                else
                    AppLayout(
                        modifier = Modifier
                            .fillMaxSize()
                            .systemBarsPadding()
                            .imePadding()
                    )

            }
        }
    }
}