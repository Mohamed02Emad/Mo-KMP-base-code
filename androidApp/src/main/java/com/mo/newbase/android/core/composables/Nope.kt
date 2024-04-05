package com.mo.newbase.android.core.composables
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Nope() {
    Spacer(modifier = Modifier.size(0.dp))
}

@Composable
fun IfOrNope(
    condition: Boolean, child: @Composable () -> Unit,
) {
    if (condition) {
        child()
    } else {
        Nope()
    }
}