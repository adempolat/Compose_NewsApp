package com.adempolat.composenewsapp.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.paging.compose.LazyPagingItems
import com.adempolat.composenewsapp.domain.model.Article
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adempolat.composenewsapp.R
import com.adempolat.composenewsapp.presentation.Dimension.MediumPadding1
import com.adempolat.composenewsapp.presentation.common.ArticleList
import com.adempolat.composenewsapp.presentation.common.SearchBar
import com.adempolat.composenewsapp.presentation.common.SearchBarPreview
import com.adempolat.composenewsapp.presentation.navgraph.Route

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(articles:LazyPagingItems<Article>, navigate: (String) -> Unit){
    val titles by remember {
        derivedStateOf {
            if (articles.itemCount> 10){
                articles.itemSnapshotList.items.slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83D\uDFE5 ") {
                        it!!.title
                    } 
            }else {
                ""
            }
        }
    }
    
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = MediumPadding1)
        .statusBarsPadding()) {

        Image(painter = painterResource(id = R.drawable.ic_logo), contentDescription = null, modifier = Modifier
            .width(150.dp)
            .height(30.dp)
            .padding(horizontal = MediumPadding1))
        Spacer(modifier = Modifier.height(MediumPadding1))

        SearchBar(modifier = Modifier.padding(horizontal = MediumPadding1).fillMaxWidth(),
            text = "",
            readOnly = true,
            onValueChange = {},
            onClick = {
            navigate(Route.SearchScreen.route)
        }, onSearch = {})
        
        Spacer(modifier = Modifier.height(MediumPadding1))
        
        Text(
            text = titles,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = MediumPadding1)
                .basicMarquee(),
            fontSize = 12.sp,
            color = colorResource(id = R.color.placeholder)
        )
        
        Spacer(modifier = Modifier.height(MediumPadding1))

        ArticleList(
            modifier = Modifier.padding(horizontal = MediumPadding1),
            articles = articles, onClick = {
            navigate(Route.DetailsScreen.route)
        })
    }
}