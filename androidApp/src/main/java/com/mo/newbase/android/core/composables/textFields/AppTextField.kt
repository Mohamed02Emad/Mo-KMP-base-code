package com.mo.newbase.android.core.composables.textFields

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mo.newbase.android.core.AppMainRadius
import com.mo.newbase.android.core.composables.text.MediumText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTextField(
    icon: ImageVector? = null,
    isPassword: Boolean = false,
    initialText: String = "",
    placeHolder: String = "",
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    focusedBorderColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    hintColor: Color = Color.Gray,
    unFocusedBorderColor: Color = hintColor,
    elevation: Dp = 0.dp,
    radius: Float = AppMainRadius,
//    validator: ValidationResult? = null,
    keyBoardOptions: KeyboardOptions = KeyboardOptions.Default.copy(
        imeAction = ImeAction.Done
    ),
    onFocusChange: (String) -> Unit = {},
    onNewValidate: (String) -> Unit = {},
    onTextChanged: (String) -> Unit,
) {

    val shape = RoundedCornerShape(radius.dp)

    var txt by remember {
        mutableStateOf(initialText)
    }
    var isFocused by remember { mutableStateOf(false) }
    var showPassword by remember { mutableStateOf(value = isPassword.not()) }
    Column {
        OutlinedTextField(value = txt,
            onValueChange = { newTextFieldValue ->
                txt = newTextFieldValue
                onTextChanged(newTextFieldValue)
            },
            keyboardOptions = keyBoardOptions,
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .shadow(
                    elevation = elevation, shape = shape
                )
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                    if (!focusState.isFocused) {
                        onFocusChange(txt)
                    }
                },
            leadingIcon = {
                if (icon != null) {
                    Icon(
                        icon, contentDescription = null
                    )
                } else null
            },
            shape = shape,
            placeholder = { MediumText(placeHolder, color = hintColor) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = backgroundColor,
                focusedBorderColor = focusedBorderColor,
                unfocusedBorderColor = unFocusedBorderColor,
                textColor = textColor,
                cursorColor = MaterialTheme.colorScheme.primary,
            ),
            visualTransformation = if (showPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            trailingIcon = {
                if (isPassword.not()) {
                    null
                } else if (showPassword) {
                    IconButton(onClick = { showPassword = false }) {
                        Icon(
                            imageVector = Icons.Filled.Visibility,
                            contentDescription = "hide password"
                        )
                    }
                } else {
                    IconButton(onClick = { showPassword = true }) {
                        Icon(
                            imageVector = Icons.Filled.VisibilityOff,
                            contentDescription = "show password"
                        )
                    }
                }
            })

//        if (validator != null) {
//            VSpace(height = 4.dp)
//            AnimatedVisibility(visible = validator.isValid.not()) {
//                SmallText(text = if (validator.message != null) stringResource(id = validator.message!!) else validator.extraMessage, color = Color.Red)
//            }
//        }
    }


}



