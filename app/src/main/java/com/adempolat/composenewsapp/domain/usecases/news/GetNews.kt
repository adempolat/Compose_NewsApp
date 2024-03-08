package com.adempolat.composenewsapp.domain.usecases.news

import androidx.paging.PagingData
import com.adempolat.composenewsapp.domain.model.Article
import com.adempolat.composenewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>>{
        return newsRepository.getNews(source = sources)
    }
}