package com.adempolat.composenewsapp.presentation.navgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.adempolat.composenewsapp.presentation.bookmark.BookmarkScreen
import com.adempolat.composenewsapp.presentation.bookmark.BookmarkViewModel
import com.adempolat.composenewsapp.presentation.home.HomeScreen
import com.adempolat.composenewsapp.presentation.home.HomeViewModel
import com.adempolat.composenewsapp.presentation.onboarding.OnBoardingScreen
import com.adempolat.composenewsapp.presentation.onboarding.OnBoardingViewModel
import com.adempolat.composenewsapp.presentation.search.SearchScreen
import com.adempolat.composenewsapp.presentation.search.SearchViewModel

@Composable
fun NavGraph(
    startDestination:String
){
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = startDestination){
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ){
            composable(
                route=Route.OnBoardingScreen.route
            ){
                val viewmodel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(onEvent = viewmodel::onEvent)
            }
        }
        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ){
            composable(route= Route.NewsNavigatorScreen.route){
                val viewModel: BookmarkViewModel = hiltViewModel()
                BookmarkScreen(state = viewModel.state.value, navigate = {})
            }
        }
    }
}