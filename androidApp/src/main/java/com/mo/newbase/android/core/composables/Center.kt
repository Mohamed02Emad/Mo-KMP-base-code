package com.mo.newbase.android.core.composables
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CenterHorizontal(content : @Composable () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth() , horizontalArrangement = Arrangement.Center ){
        content()
    }
}