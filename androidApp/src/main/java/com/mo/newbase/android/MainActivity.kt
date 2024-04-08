package com.mo.newbase.android

import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.mo.newbase.SharedViewModel
import com.mo.newbase.android.core.navigation.navhosts.AuthNavHost
import com.mo.newbase.android.theme.MyApplicationTheme
import com.mo.newbase.core.SharedStates
import com.mo.newbase.core.navigation.Screen
import com.mo.newbase.core.utils.currentLang
import com.mo.newbase.features.more.settings.domain.models.Languages
import com.mo.newbase.features.more.settings.presentation.SettingsViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.koin.android.ext.android.inject
import org.koin.androidx.compose.getViewModel
import java.util.Locale


class MainActivity : ComponentActivity() {

//    private val pushPermissionLauncher = registerForActivityResult(
//        ActivityResultContracts.RequestPermission()
//    ) {
//    }

    private val globalStates: SharedStates by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        showSplash()
        super.onCreate(savedInstanceState)
        setContent {
            val sharedViewModel: SharedViewModel = globalStates.get()
            val settingsViewModel: SettingsViewModel = getViewModel()
            runBlocking {
                sharedViewModel.getStartDestination()
                settingsViewModel.initData()
            }
            val darkMode = settingsViewModel.darkMode.collectAsState()
            val language = settingsViewModel.language.collectAsState()
            val isRtl = settingsViewModel.isRtl.collectAsState()
            val direction = if (isRtl.value) LocalLayoutDirection provides LayoutDirection.Rtl else LocalLayoutDirection provides LayoutDirection.Ltr
            setAppLanguage(language.value)
            CompositionLocalProvider(direction) {
                MyApplicationTheme(darkTheme = darkMode.value) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        AuthNavHost(startDestination = Screen.OnBoarding)
                    }
                }
            }
        }
    }

    private fun showSplash() {
        setTheme(R.style.Theme_My_Base_compose_code)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            installSplashScreen()
        } else {
            runBlocking {
                delay(600)
            }
        }
    }

    private fun setAppLanguage(language: Languages) {
        val lngString = when (language) {
            Languages.system -> {
                val locale: Locale =
                    Resources.getSystem().configuration.locales[0]
                locale.language ?: "en"
            }
            Languages.ar -> {
                "ar"
            }

            Languages.en -> {
                "en"
            }
        }
        val config = resources.configuration
        val locale = Locale(lngString)
        Locale.setDefault(locale)
        config.setLocale(locale)
        createConfigurationContext(config)
        resources.updateConfiguration(config, resources.displayMetrics)
    }

//    private fun requestForPermission() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            pushPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS)
//        }
//    }
}

