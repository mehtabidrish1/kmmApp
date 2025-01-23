package org.example.project.composable


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction


@OptIn(ExperimentalComposeUiApi::class)@Composable
fun CustomOutlineTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    enable: Boolean = true,
    placeholder: String? = null,
    maxLines: Int = 1,
    minLines: Int = 1,
    trailingIcon: @Composable (() -> Unit)? = null,
    shape: Shape = RoundedCornerShape(30.dp),
    isError: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    textCapitalization: KeyboardCapitalization = KeyboardCapitalization.None,
    readOnly: Boolean = false,
    maxLength: Int? = 50,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant
    ),
    onValidation: ((String) -> String?)? = null, // New validator returning an error message
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    // Tracks if the user has started typing
    var hasStartedTyping by remember { mutableStateOf(false) }
    val errorText = remember(value) {
        if (hasStartedTyping) {
            onValidation?.invoke(value) // Validate only after typing has started
        } else {
            null
        }
    }
    Column(
        modifier = modifier) {
        OutlinedTextField(
            modifier = modifier,
            value = value,

            onValueChange = {
                if (!hasStartedTyping) {
                    hasStartedTyping = true // Start validation after the first input
                }
                if (maxLength == null || it.length <= maxLength) {
                    onValueChange(it)
                }
            },
            shape = shape,
            enabled = enable,
            colors = colors,
            label = label?.let { { Text(it) } },
            placeholder = placeholder?.let { { Text(it) } },
            isError = isError || !errorText.isNullOrEmpty(),
            trailingIcon = trailingIcon,
            minLines = minLines,
            singleLine = maxLines == 1,
            maxLines = maxLines,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                capitalization = textCapitalization,
                imeAction = if (keyboardType == KeyboardType.Text) ImeAction.Next else ImeAction.Done,
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            ),
            textStyle = MaterialTheme.typography.bodyLarge,
            readOnly = readOnly,
            visualTransformation = visualTransformation
        )

        if (!errorText.isNullOrEmpty()) {
            Text(
                text = errorText,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            )
        }
    }
}



