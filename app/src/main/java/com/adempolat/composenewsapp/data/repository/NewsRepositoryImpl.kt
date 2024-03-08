package com.adempolat.composenewsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.adempolat.composenewsapp.data.remote.NewsPagingSource
import com.adempolat.composenewsapp.data.remote.SearchNewsPagingSource
import com.adempolat.composenewsapp.data.remote.dto.NewsApi
import com.adempolat.composenewsapp.domain.model.Article
import com.adempolat.composenewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsApi: NewsApi
): NewsRepository {
    override fun getNews(source: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    source = source.joinToString(separator = ",")
                )
            }
        ).flow
    }

    override fun searchNews(searchQuery: String, source: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    searchQuery = searchQuery,
                    newsApi = newsApi,
                    sources = source.joinToString(separator = ",")
                )
            }
        ).flow
    }
}