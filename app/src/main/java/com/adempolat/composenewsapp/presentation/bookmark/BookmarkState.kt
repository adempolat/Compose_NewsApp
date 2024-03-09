package com.adempolat.composenewsapp.presentation.bookmark

import com.adempolat.composenewsapp.domain.model.Article

data class BookmarkState(
    val articles:List<Article> = emptyList()
)
