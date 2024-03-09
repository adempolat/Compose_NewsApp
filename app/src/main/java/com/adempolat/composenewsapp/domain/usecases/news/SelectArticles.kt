package com.adempolat.composenewsapp.domain.usecases.news

import com.adempolat.composenewsapp.data.local.NewsDao
import com.adempolat.composenewsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsDao: NewsDao
) {
    operator fun invoke() : Flow<List<Article>> {
        return newsDao.getArticles()
    }
}