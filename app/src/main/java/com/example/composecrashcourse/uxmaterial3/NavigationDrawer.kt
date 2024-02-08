package com.example.composecrashcourse.uxmaterial3

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composecrashcourse.uxmaterial3.common.NavigationItem
import com.example.composecrashcourse.uxmaterial3.common.getNavigationItemList
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer(items: List<NavigationItem> = getNavigationItemList()) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val scope = rememberCoroutineScope()

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                items.forEachIndexed { index, navigationItem ->
                    Spacer(modifier = Modifier.height(16.dp))
                    NavigationDrawerItem(label = {
                        Text(text = navigationItem.title)
                    }, selected = index == selectedItemIndex, onClick = {
                        selectedItemIndex = index
                        scope.launch {
                            drawerState.close()
                        }
                    }, icon = {
                        Icon(
                            imageVector = if (index == selectedItemIndex) {
                                navigationItem.selectedIcon
                            } else navigationItem.unselectedIcon,
                            contentDescription = navigationItem.title
                        )
                    }, badge = {
                        navigationItem.badgeCount?.let {
                            Text(text = it.toString())
                        }
                    })
                }
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(topBar = {
            TopAppBar(title = {
                Text(text = "Todo App")
            }, navigationIcon = {
                IconButton(onClick = {
                    scope.launch {
                        drawerState.open()
                    }
                }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                }
            })
        }) {

        }

    }

}