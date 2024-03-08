package com.adempolat.composenewsapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.adempolat.composenewsapp.data.remote.dto.NewsApi
import com.adempolat.composenewsapp.domain.model.Article
import com.adempolat.composenewsapp.domain.model.Source
import com.adempolat.composenewsapp.util.Constants.API_KEY

class NewsPagingSource(
    private val newsApi:NewsApi,
    private val source: String
):PagingSource<Int,Article>() {

    private var totalNewsCount = 0


    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1
        return try {
            val newsResponse = newsApi.getNews(sources = source, page = page)
            totalNewsCount += newsResponse.articles.size
            val articles = newsResponse.articles.distinctBy { it.title }  // remove duplicate

            LoadResult.Page(
                data = articles,
                nextKey = if (totalNewsCount==newsResponse.totalResults) null else page+1,
                prevKey = null
            )

        }catch (e:Exception){
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }

}