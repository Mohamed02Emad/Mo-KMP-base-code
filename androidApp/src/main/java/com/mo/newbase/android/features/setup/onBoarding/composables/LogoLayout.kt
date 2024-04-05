package com.mo.newbase.android.features.setup.onBoarding.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mo.newbase.android.R
import com.mo.newbase.android.core.composables.HSpace
import com.mo.newbase.android.core.composables.text.LargeText

@Composable
fun LogoLayout() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(50.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo"
        )
        HSpace(width = 8.dp)
        LargeText(text = LocalContext.current.getString(R.string.app_name))
    }
}