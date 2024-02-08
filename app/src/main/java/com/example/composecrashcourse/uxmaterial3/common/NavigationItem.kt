package com.example.composecrashcourse.uxmaterial3.common

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon:ImageVector,
    val badgeCount:Int?=null
)
