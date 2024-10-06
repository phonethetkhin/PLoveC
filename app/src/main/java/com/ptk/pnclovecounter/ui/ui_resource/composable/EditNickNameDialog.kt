package com.ptk.pnclovecounter.ui.ui_resource.composable

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun EditNickNameDialog(
    showDialog: Boolean,
    textValue: String,
    onDismiss: () -> Unit,
    onValueChange: (String) -> Unit,
    onConfirm: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = { Text(text = "Enter your Nickname") },
            text = {
                CustomUserInput(
                    label = "Nickname",
                    value = textValue,
                    onValChange = {
                        onValueChange(it)
                    },
                    errorMessage = "Nickname cannot be empty",
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    onConfirm()
                }) {
                    Text("Update")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text("Cancel")
                }
            }
        )
    }
}
