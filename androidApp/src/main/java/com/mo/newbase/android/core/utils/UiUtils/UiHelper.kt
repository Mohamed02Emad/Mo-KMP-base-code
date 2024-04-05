package com.mo.newbase.android.core.utils.UiUtils

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp


/**
 Toast
  **/
fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}
fun String.showToast(context: Context) {
    showToast(context, this)
}
fun showToast(context: Context, message: Int) {
    showToast(context, message.toString())
}
fun Int.showToast(context: Context) {
    showToast(context, this.toString())
}
fun showToast(context: Context, message: Double) {
    showToast(context, message.toString())
}
fun Double.showToast(context: Context) {
    showToast(context, this.toString())
}

fun showToast(context: Context, message: Boolean) {
    showToast(context, message.toString())
}

fun Boolean.showToast(context: Context) {
    showToast(context, this.toString())
}

/**-------------------------------------------------------------------------------------------------------------**/
/**-------------------------------------------------------------------------------------------------------------**/

@Composable
fun getScreenHeight() = LocalConfiguration.current.screenHeightDp.dp
@Composable
fun getScreenWidth() = LocalConfiguration.current.screenWidthDp.dp
