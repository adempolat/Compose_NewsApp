package com.adempolat.composenewsapp.presentation.search

import android.app.appsearch.AppSearchManager.SearchContext
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.paging.compose.collectAsLazyPagingItems
import com.adempolat.composenewsapp.presentation.Dimension.MediumPadding1
import com.adempolat.composenewsapp.presentation.common.ArticleList
import com.adempolat.composenewsapp.presentation.common.SearchBar
import com.adempolat.composenewsapp.presentation.navgraph.Route
import java.lang.reflect.Modifier

@Composable
fun SearchScreen(
    state:SearchState,
    event:(SearchEvent) -> Unit,
    navigate:(String) -> Unit
){
    Column(modifier = androidx.compose.ui.Modifier
        .padding(
            top = MediumPadding1,
            start = MediumPadding1,
            end = MediumPadding1
        )
        .statusBarsPadding()
        .fillMaxSize()) {
        SearchBar(
            text = state.searchQuery,
            readOnly = false,
            onValueChange = { event(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = { event ( SearchEvent.SearchNews)}
        ) 
        Spacer(modifier = androidx.compose.ui.Modifier.height(MediumPadding1))
        state.articles?.let { 
            val articles = it.collectAsLazyPagingItems()
            ArticleList(articles =articles, onClick ={navigate(Route.DetailsScreen.route)})
        }
    }
}