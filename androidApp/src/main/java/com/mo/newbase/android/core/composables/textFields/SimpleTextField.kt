package com.mo.newbase.android.core.composables.textFields

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mo.newbase.android.core.AppMainRadius

@Composable
fun SimpleTextField(
    modifier: Modifier = Modifier,
    borderColor: Color = MaterialTheme.colorScheme.primary,
    borderWidth: Dp = 1.dp,
    initText: String = "",
    keyBoardOptions: KeyboardOptions = KeyboardOptions.Default.copy(
        imeAction = ImeAction.Done
    ),
    maxLines: Int = 1,
    cornerRadius: Float = AppMainRadius,
    placeholderText: String,
    onTextChanged: (String) -> Unit,
) {
    var value by remember {
        mutableStateOf(initText)
    }

    val isPlaceholderVisible = value.isEmpty()

    BasicTextField(
        modifier = modifier
            .height(55.dp)
            .fillMaxWidth(),
        value = value,
        onValueChange = { newText ->
            value = newText
            onTextChanged(newText)
        },
        textStyle = TextStyle(
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
        ),
        keyboardOptions = keyBoardOptions,
        maxLines = maxLines,
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = borderWidth,
                        color = borderColor,
                        shape = RoundedCornerShape(size = cornerRadius.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 12.dp),
            ) {
                AnimatedVisibility(visible = isPlaceholderVisible) {
                    Text(
                        text = placeholderText,
                        color = Color.Gray,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .padding(start = 6.dp, top = 4.dp)
                            .animateContentSize()
                    )
                }
                innerTextField()
            }
        }
    )
}
