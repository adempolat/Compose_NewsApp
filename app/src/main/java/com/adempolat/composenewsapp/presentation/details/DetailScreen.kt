package com.adempolat.composenewsapp.presentation.details

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.adempolat.composenewsapp.R
import com.adempolat.composenewsapp.domain.model.Article
import com.adempolat.composenewsapp.domain.model.Source
import com.adempolat.composenewsapp.presentation.Dimension.ArticleImageHeight
import com.adempolat.composenewsapp.presentation.Dimension.MediumPadding1
import com.adempolat.composenewsapp.presentation.common.ArticleCard
import com.adempolat.composenewsapp.presentation.details.componenets.DetailsTopBar
import com.adempolat.composenewsapp.ui.theme.ComposeNewsAppTheme

@Composable
fun DetailScreen(
    article: Article,
    event: (DetailEvent) -> Unit,
    navigateUp: () -> Unit
){
    val context = LocalContext.current
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        DetailsTopBar(
            onBrowsingClick = {
                      Intent(Intent.ACTION_VIEW).also {
                          it.data = Uri.parse(article.url)
                          if (it.resolveActivity(context.packageManager) != null ){
                              context.startActivity(it)
                          }
                      }
            },
            onShareClick = {
                           Intent(Intent.ACTION_SEND).also {
                               it.putExtra(Intent.EXTRA_TEXT,article.url)
                               it.type="text/plan"
                               if (it.resolveActivity(context.packageManager) != null){
                                   context.startActivity(it)
                               }
                           }
            },
            onBookNarkClick = { event(DetailEvent.SaveArticle) },

            onBackClick = navigateUp)

        LazyColumn(modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(
            start = MediumPadding1,
            end = MediumPadding1,
            top = MediumPadding1
        )
        ){
            item { 
                
                AsyncImage(
                    model = ImageRequest.Builder(
                        context = context).data(article.urlToImage).build(),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(ArticleImageHeight)
                            .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop
                )
                
                Spacer(modifier = Modifier.height(MediumPadding1))
                
                Text(text = article.title, style = MaterialTheme.typography.displaySmall,
                color = colorResource(id = R.color.text_title))

                Text(text = article.content, style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = R.color.body))
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview(){
    ComposeNewsAppTheme(dynamicColor = false) {
        DetailScreen(
            article = Article(
                author = "",
                content = "",
                description = "",
                publishedAt = "2 hours",
                source = Source(id = "", name = "BBC"),
                title = "Bayburtspor küme hattından çıkmaya çalışıyor,son 6 hafta!",
                url = "",
                urlToImage = "https://ichef.bbci.co.uk/live-experience/cps/624/cpsprodpb/11787/production/_124395517_bbcbreakingnewsgraphic.jpg"
            ),
            event = {}
        ) {

        }
    }
}