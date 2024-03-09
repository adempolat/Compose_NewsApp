package com.adempolat.composenewsapp.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.adempolat.composenewsapp.domain.model.Source

@ProvidedTypeConverter
class NewsTypeConvertor {
    @TypeConverter
    fun sourceToString(source: Source):String{
        return "${source.id}, ${source.toString()}"
    }

    @TypeConverter
    fun stringToSource(source: String):Source{
        return source.split(",").let { sourceArray ->
            Source(sourceArray[0],sourceArray[1])
        }
    }
}