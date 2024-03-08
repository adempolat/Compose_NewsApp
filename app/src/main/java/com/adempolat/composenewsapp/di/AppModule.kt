package com.adempolat.composenewsapp.di

import android.app.Application
import com.adempolat.composenewsapp.data.manager.LocalUserManagerImpl
import com.adempolat.composenewsapp.data.remote.dto.NewsApi
import com.adempolat.composenewsapp.data.repository.NewsRepositoryImpl
import com.adempolat.composenewsapp.domain.manager.LocalUserManager
import com.adempolat.composenewsapp.domain.repository.NewsRepository
import com.adempolat.composenewsapp.domain.usecases.app_entry.AppEntryUseCases
import com.adempolat.composenewsapp.domain.usecases.app_entry.ReadAppEntry
import com.adempolat.composenewsapp.domain.usecases.app_entry.SaveAppEntry
import com.adempolat.composenewsapp.domain.usecases.news.GetNews
import com.adempolat.composenewsapp.domain.usecases.news.NewsUseCases
import com.adempolat.composenewsapp.domain.usecases.news.SearchNews
import com.adempolat.composenewsapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ):LocalUserManager = LocalUserManagerImpl(application)



    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }


    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImpl(newsApi)

   @Provides
   @Singleton
   fun provideNewsUseCases(
       newsRepository: NewsRepository
   ): NewsUseCases{
       return NewsUseCases(
           getNews = GetNews(newsRepository),
           searchNews = SearchNews(newsRepository)
       )
   }

}