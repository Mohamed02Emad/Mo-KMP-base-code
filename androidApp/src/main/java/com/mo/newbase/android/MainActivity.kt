package com.mo.newbase.android

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.mo.newbase.android.core.navigation.Screen
import com.mo.newbase.android.core.navigation.navhosts.AuthNavHost
import com.mo.newbase.android.theme.MyApplicationTheme
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

//    private val pushPermissionLauncher = registerForActivityResult(
//        ActivityResultContracts.RequestPermission()
//    ) {
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        showSplash()
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AuthNavHost(startDestination = Screen.OnBoarding)
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

//    private fun requestForPermission() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            pushPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS)
//        }
//    }
}

