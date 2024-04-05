package com.mo.newbase.android

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mo.newbase.Greeting
import com.mo.newbase.android.core.utils.navigation.Screen
import com.mo.newbase.android.core.utils.navigation.navhosts.AuthNavHost
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

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

