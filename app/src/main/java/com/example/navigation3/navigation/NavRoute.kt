package com.example.navigation3.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class NavRoute : NavKey {
    @Serializable
    data object NoteScreenRoute : NavRoute()
    @Serializable
    data class NoteDetailsScreenRoute(val id : String) : NavRoute()
}