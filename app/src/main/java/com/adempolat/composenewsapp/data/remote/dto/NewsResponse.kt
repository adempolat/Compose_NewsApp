package com.adempolat.composenewsapp.data.remote.dto

import com.adempolat.composenewsapp.domain.model.Article

data class NewsResponse(
    val articles:List<Article>,
    val status: String,
    val totalResults:Int
)
