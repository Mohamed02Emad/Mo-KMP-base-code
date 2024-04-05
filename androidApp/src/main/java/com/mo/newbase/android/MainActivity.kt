package com.mo.newbase.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.mo.newbase.android.core.navigation.Screen
import com.mo.newbase.android.core.navigation.navhosts.AuthNavHost
import com.mo.newbase.android.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

//    private val pushPermissionLauncher = registerForActivityResult(
//        ActivityResultContracts.RequestPermission()
//    ) {
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
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

//    private fun showSplash() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
//            installSplashScreen()
//        } else {
//            runBlocking {
//                delay(600)
//            }
//        }
//    }
//
//    private fun requestForPermission() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            pushPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS)
//        }
//    }
}

