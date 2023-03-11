package com.example.compose.ui.views

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.compose.model.nav_model.Screen
import com.example.compose.ui.theme.Grey

@Composable
fun BottomNavigationBar(navController: NavController, bottomBarState: MutableState<Boolean>, ) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val items = listOf(
        Screen.Main,
        Screen.Search,
        Screen.WatchHolder
    )
    AnimatedVisibility(
        visible = bottomBarState.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        content = {
            BottomNavigation(
                modifier = Modifier.graphicsLayer {
                    shape = RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp)
                    clip = true
                },
                backgroundColor = Grey,
                contentColor = Color.White,
            ) {
                items.forEach { item ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                painterResource(item.icon!!),
                                contentDescription = item.title!!,
                                modifier = Modifier
                                    .padding(bottom = 5.dp, top = 10.dp)
                                    .size(20.dp)
                            )
                        },
                        label = {
                            Text(
                                text = item.title!!
                            )
                        },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.White.copy(0.4f),
                        alwaysShowLabel = true,
                        selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                navController.graph.startDestinationRoute?.let { route ->
                                    popUpTo(route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        })
}