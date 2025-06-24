package com.example.navigation3.navigation

sealed class NavRoute {
    data object NoteScreenRoute : NavRoute()
    data class NoteDetailsScreenRoute(val id : String) : NavRoute()
}