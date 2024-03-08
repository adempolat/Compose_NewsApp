package com.adempolat.composenewsapp.domain.usecases.app_entry

import com.adempolat.composenewsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {
    operator fun invoke() : Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}