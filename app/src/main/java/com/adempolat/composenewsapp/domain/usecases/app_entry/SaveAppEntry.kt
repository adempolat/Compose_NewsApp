package com.adempolat.composenewsapp.domain.usecases.app_entry

import com.adempolat.composenewsapp.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}