package com.adempolat.composenewsapp.domain.usecases.news

import com.adempolat.composenewsapp.data.local.NewsDao
import com.adempolat.composenewsapp.domain.model.Article

class DeleteArticle(
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(article: Article){
        newsDao.delete(article)
    }
}