package com.example.navigation3.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.navigation3.screens.NoteDetailsScreen
import com.example.navigation3.screens.NoteScreen

@Composable
fun Navigation() {

    val backStack = remember { mutableStateListOf<NavRoute>(NavRoute.NoteScreenRoute) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when(key) {
                is NavRoute.NoteScreenRoute -> NavEntry(key) {
                    NoteScreen(
                        onClickDetailsBtn = {
                            backStack.add(NavRoute.NoteDetailsScreenRoute(id = key.toString()))
                        }
                    )
                }
                is NavRoute.NoteDetailsScreenRoute -> NavEntry(key) {
                    NoteDetailsScreen(key.id)
                }
            }
        }
    )
}