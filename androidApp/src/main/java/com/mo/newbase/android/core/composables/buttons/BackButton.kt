package com.mo.newbase.android.core.composables.buttons
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
   Box(modifier = modifier) {
       Box(
           modifier = Modifier
               .clip(RoundedCornerShape(35.dp))
               .clickable(onClick = onClick)
               .size(35.dp),
           contentAlignment = Alignment.Center
       ) {
           Icon(
               imageVector = Icons.Default.ArrowBack,
               contentDescription = null,
               modifier = Modifier.size(24.dp),
               tint = MaterialTheme.colorScheme.onSurface
           )
       }
   }
}