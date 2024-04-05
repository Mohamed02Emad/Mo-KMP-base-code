package com.mo.newbase.android.core.composables.switches

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun AppSwitch(
    isChecked :Boolean = false,
    checkedIcon : ImageVector = Icons.Default.Check,
    unCheckedIcon : ImageVector =  Icons.Default.Close,
    onCheckedChanged : (Boolean) -> Unit,
) {
    var switchON = isChecked
//    var switchON by remember {
//        mutableStateOf(isChecked)
//    }

    val thumbContent: (@Composable () -> Unit) =
        {
            Icon(
                modifier = Modifier.size(size = SwitchDefaults.IconSize),
                imageVector = if (switchON)  checkedIcon else unCheckedIcon,
                contentDescription = null,
                tint = if (switchON.not()) Color.White else MaterialTheme.colorScheme.primary
            )
        }

    Switch(
        checked = switchON,
        onCheckedChange = { switchState ->
            switchON = switchState
            onCheckedChanged(switchState)
        },
        thumbContent = thumbContent
    )
}