package com.example.navigation3.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.navigation3.screens.NoteDetailsScreen
import com.example.navigation3.screens.NoteScreen

@Composable
fun Navigation() {

    // val backStack = remember { mutableStateListOf<NavRoute>(NavRoute.NoteScreenRoute) }
    val backStack = rememberNavBackStack<NavRoute>(NavRoute.NoteScreenRoute) // survive configure change

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
//        entryProvider = { key ->
//            when(key) {
//                is NavRoute.NoteScreenRoute -> NavEntry(key) {
//                    NoteScreen(
//                        onClickDetailsBtn = {
//                            backStack.add(NavRoute.NoteDetailsScreenRoute(id = key.toString()))
//                        }
//                    )
//                }
//                is NavRoute.NoteDetailsScreenRoute -> NavEntry(key) {
//                    NoteDetailsScreen(key.id)
//                }
//            }
//        }
        entryProvider = entryProvider {

            entry<NavRoute.NoteScreenRoute> { key ->
                NoteScreen(
                    onClickDetailsBtn = {
                        backStack.add(NavRoute.NoteDetailsScreenRoute(id = key.toString()))
                    }
                )
            }

            entry<NavRoute.NoteDetailsScreenRoute> { key ->
                NoteDetailsScreen(key.id)
            }
        },
        transitionSpec = {
            // Slide in from right when navigating forward
            slideInHorizontally(initialOffsetX = { it }) togetherWith
                    slideOutHorizontally(targetOffsetX = { -it })
        },
        popTransitionSpec = {
            // Slide in from left when navigating back
            slideInHorizontally(initialOffsetX = { -it }) togetherWith
                    slideOutHorizontally(targetOffsetX = { it })
        },
        predictivePopTransitionSpec = {
            // Slide in from left when navigating back
            slideInHorizontally(initialOffsetX = { -it }) togetherWith
                    slideOutHorizontally(targetOffsetX = { it })
        }
    )
}