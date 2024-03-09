package com.adempolat.composenewsapp.presentation.details.componenets

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.adempolat.composenewsapp.R
import com.adempolat.composenewsapp.ui.theme.ComposeNewsAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsTopBar(
    onBrowsingClick:() -> Unit,
    onShareClick:() -> Unit,
    onBookNarkClick:() -> Unit,
    onBackClick:() -> Unit
){
    TopAppBar(
        title = {},
        modifier = Modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Transparent,
            actionIconContentColor = colorResource(id = R.color.body),
            navigationIconContentColor = colorResource(id = R.color.body),
        ),
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(painter = painterResource(id = R.drawable.ic_back_arrow), contentDescription = null)
                
            }
        },
        actions = {
            IconButton(onClick = onBookNarkClick) {
                Icon(painter = painterResource(id = R.drawable.ic_bookmark), contentDescription = null )
            }

            IconButton(onClick = onShareClick) {
                Icon(imageVector = Icons.Default.Share, contentDescription = null )

            }

            IconButton(onClick = onBrowsingClick) {
                Icon(painter = painterResource(id = R.drawable.ic_network), contentDescription = null )
            }
        }
    )
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DetailsTopBarPreview(){
    ComposeNewsAppTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            DetailsTopBar(
                onBrowsingClick = { /*TODO*/ },
                onShareClick = { /*TODO*/ },
                onBookNarkClick = { /*TODO*/ }) {
            }
        }


    }
}