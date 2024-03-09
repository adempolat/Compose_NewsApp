package com.adempolat.composenewsapp.presentation.bookmark

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import com.adempolat.composenewsapp.R
import com.adempolat.composenewsapp.presentation.Dimension.MediumPadding1
import com.adempolat.composenewsapp.presentation.common.ArticleList
import com.adempolat.composenewsapp.presentation.navgraph.Route

@Composable
fun BookmarkScreen(
    state: BookmarkState,
    navigate:(String) -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                top = MediumPadding1,
                start = MediumPadding1,
                end = MediumPadding1
            )
    ) {
        Text(
            text = "Bookmark",
            style = MaterialTheme.typography.displayMedium.copy(
                fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.text_title)
        )

        Spacer(modifier = Modifier.height(MediumPadding1))
        
        ArticleList(articles = state.articles, onClick = {navigate(Route.DetailsScreen.route)})

    }
}