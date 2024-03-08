package com.adempolat.composenewsapp.domain.repository

import androidx.paging.PagingData
import com.adempolat.composenewsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(source: List<String>): Flow<PagingData<Article>>

    fun searchNews(searchQuery: String,source: List<String>): Flow<PagingData<Article>>
}