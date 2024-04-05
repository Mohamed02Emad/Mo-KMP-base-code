package com.mo.newbase.android.features.setup.onBoarding.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mo.newbase.android.core.composables.text.MediumText

@Composable
fun OnBoardingPage(modifier: Modifier = Modifier, image: Int, text: String) {
    Column(verticalArrangement = Arrangement.SpaceEvenly, modifier = modifier) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Row(modifier = Modifier.fillMaxWidth() , horizontalArrangement = Arrangement.Center) {
            MediumText(text = text , modifier = Modifier
                .padding(horizontal = 16.dp) )
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}