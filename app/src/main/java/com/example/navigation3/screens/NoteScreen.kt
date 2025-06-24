package com.example.navigation3.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun NoteScreen(modifier: Modifier = Modifier, onClickDetailsBtn:()-> Unit) {
    Box(modifier = modifier.fillMaxWidth().fillMaxHeight(), contentAlignment = Alignment.Center) {
        Text("Note Screen")
        Button(onClick = onClickDetailsBtn) { Text("Navigate to Details Screen") }
    }
}