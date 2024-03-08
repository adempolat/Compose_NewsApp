package com.adempolat.composenewsapp.domain.usecases.news

import androidx.paging.PagingData
import com.adempolat.composenewsapp.domain.model.Article
import com.adempolat.composenewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(searchQuery:String,sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.searchNews(searchQuery = searchQuery,source = sources)
    }
}