package com.adempolat.composenewsapp.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.adempolat.composenewsapp.domain.model.Article
import com.adempolat.composenewsapp.domain.model.Source
import com.adempolat.composenewsapp.presentation.Dimension.ArticleCardSize
import com.adempolat.composenewsapp.presentation.Dimension.ExtraSmallPadding
import com.adempolat.composenewsapp.presentation.Dimension.ExtraSmallPadding2
import com.adempolat.composenewsapp.presentation.Dimension.SmallIconSize
import com.adempolat.composenewsapp.ui.theme.ComposeNewsAppTheme
import java.lang.reflect.Modifier

@Composable
fun ArticleCard(
    modifier: androidx.compose.ui.Modifier= androidx.compose.ui.Modifier,
    article: Article,
    onClick:() ->Unit
){
    val context = LocalContext.current
    Row(
        modifier = modifier.clickable { onClick?.invoke() },

        ) {
        AsyncImage(
            modifier = androidx.compose.ui.Modifier
                .size(ArticleCardSize)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context).data(article.urlToImage).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = androidx.compose.ui.Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(ArticleCardSize)
        ) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.bodyMedium.copy(),
                color = colorResource(id = com.adempolat.composenewsapp.R.color.text_title),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = article.source.name,
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = com.adempolat.composenewsapp.R.color.body)
                )
                Spacer(modifier = androidx.compose.ui.Modifier.width(ExtraSmallPadding2))
                Icon(
                    painter = painterResource(id = com.adempolat.composenewsapp.R.drawable.ic_time),
                    contentDescription = null,
                    modifier = androidx.compose.ui.Modifier.size(SmallIconSize),
                    tint = colorResource(id = com.adempolat.composenewsapp.R.color.body)
                )
                Spacer(modifier = androidx.compose.ui.Modifier.width(ExtraSmallPadding))
                Text(
                    text = article.publishedAt,
                    style = MaterialTheme.typography.labelSmall,
                    color = colorResource(id = com.adempolat.composenewsapp.R.color.body)
                )
            }
        }
    }


}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ArticleCardPreview(){
    ComposeNewsAppTheme {
        ArticleCard(article = Article(
            author = "",
            content = "",
            description = "",
            publishedAt = "2 hours",
            source = Source(id = "", name = "BBC"),
            title = "Bayburtspor küme hattından çıkmaya çalışıyor,son 6 hafta!",
            url = "",
            urlToImage = "https://ichef.bbci.co.uk/live-experience/cps/624/cpsprodpb/11787/production/_124395517_bbcbreakingnewsgraphic.jpg"
        )
        ) {

        }
    }

}